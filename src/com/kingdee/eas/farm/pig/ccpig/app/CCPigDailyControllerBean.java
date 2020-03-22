package com.kingdee.eas.farm.pig.ccpig.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.DefineSysEnum;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.pig.ccpig.CCPigDailyInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class CCPigDailyControllerBean extends AbstractCCPigDailyControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.pig.ccpig.app.CCPigDailyControllerBean");
    
    

    


	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// 状态设置为保存
		CCPigDailyInfo info =  (CCPigDailyInfo)model;
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&&
				info.getBaseStatus() != null){
			throw new EASBizException(new NumericExceptionSubItem("001","只能保存暂存或者新增状态的单据"));
			
		}else{
			
		}
		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, model);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		// 状态设置为保存
		CCPigDailyInfo info =  this.getCCPigDailyInfo(ctx, pk);
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&& 
				!BillBaseStatusEnum.SUBMITED.equals(info.getBaseStatus())){
			throw new EASBizException(new NumericExceptionSubItem("001","只能删除暂存或者新增状态的单据"));
			
		}
		super._delete(ctx, pk);
	}
	
	/**
	 * 提交
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		CCPigDailyInfo billInfo = (CCPigDailyInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()) || 
    						billInfo.getBaseStatus() == null)){
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		
    		return super._submit(ctx, model);
    	}else{
    		throw new EASBizException(new NumericExceptionSubItem("001","只能提交新增或保存状态的单据"));
			
    	}
	}
	
	

	/**
     * 审核
     */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		CCPigDailyInfo billInfo = (CCPigDailyInfo)model;
		
		try {
			if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
				boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
				if(exist){
					throw new FarmException("已经存在下游单据，不能审核");
				}
				
				// 更新单据状态
				AppCommon.updateModelStatus(ctx, "CT_PIG_CCPigDaily", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
				
			}else{
				throw new FarmException("只能审核提交状态的单据");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BOSException(e);
		}
		
	}

	/**
	 * 反审核
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {
		
		CCPigDailyInfo billInfo = (CCPigDailyInfo)model;
		try{
			if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
				boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
				if(exist){
					throw new FarmException("已经存在下游单据，不能反审核");
				}else{
					// 校验当前批次是否已经生成了 日报 
					// TODO 
				}
				// 更新单据状态
				AppCommon.updateModelStatus(ctx, "CT_PIG_CCPigDaily", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
				
			}else{
				throw new FarmException("只能反审核审核状态的单据");
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
			throw new FarmException(e);
		}
	}
//
//	/**
//	 * 生成下游单据
//	 */
//	@Override
//	protected List _genNextBill(Context ctx, IObjectValue model)
//			throws BOSException {
//		
//		// 状态校验
//		CCPigDailyInfo billInfo = (CCPigDailyInfo) model;
//		if(!BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
//			throw new FarmException("只有审核状态的单据才能生成下游单据");
//		}
//		// 下游单据校验
//		boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
//		if(exist){
//			throw new FarmException("已经存在下游单据，不能审核");
//		}
//		
//		List<String> botIDs = AppCommon.getBillBotMappings(ctx, this.getBOSType().toString(), DefineSysEnum.BTP, true);
//		CoreBaseCollection destCol=new CoreBaseCollection();
//		
//		// 结果
//		List<ExecBotpResultInfo>  execResults = new ArrayList<ExecBotpResultInfo>();
//		// 转换规则ID
//		try{
//
//
//			
//			// 获取所有可用的botcoll
//			String srcBillType = this.getBOSType().toString();
//			String[] srcBillIDs = {billInfo.getId().toString()};
//			String[] entryNames = {"entrys"};
//			List entriesKey = new ArrayList<String>();
//			CommecialChilkenDailyEntryCollection entryColl = billInfo.getEntrys();
//			if(entryColl.size() > 0){
//				for(int j = 0; j < entryColl.size(); j++){
//					CommecialChilkenDailyEntryInfo entryInfo = entryColl.get(j);
//					if(entryInfo != null && entryInfo.getId() != null){
//						entriesKey.add(entryInfo.getId().toString());
//					}
//				}
//			}
//			
//			SelectorItemCollection botpSelectors = null;
//			
//			BotpAppCommon botpAppComm = new BotpAppCommon();
//			BOTMappingCollection botColl = botpAppComm.getAllCanUsedBots(ctx,srcBillType,srcBillIDs,entryNames,entriesKey,botpSelectors);
//			
//			// 获取所有可用的botp 后逐个执行操作
//			if(botColl != null && botColl.size() > 0){
//				
//				BOTMappingCollection inbots = new BOTMappingCollection();
//				BOTMappingCollection outbots = new BOTMappingCollection();
//				for(int i = 0; i < botColl.size(); i++){
//					
//					
//					BOTMappingInfo botMappingInfo = botColl.get(i);
//					
//					if(botMappingInfo.getAlias().indexOf("入库") > -1){
//						inbots.add(botMappingInfo);
//					}else{
//						outbots.add(botMappingInfo);
//					}
//					
//				}
//				// 执行结果 
//				ExecBotpResultInfo  resultInfo;
//				// 先生成入库单据
//				for(int i = 0; i < inbots.size(); i++)
//				{
//					{
//						BOTMappingInfo botMappingInfo = inbots.get(i);
//						resultInfo = this.getEmptyExecresult(ctx, billInfo);
//						resultInfo.setMappingName(botMappingInfo.getAlias());
//						resultInfo.setMappingNumber(botMappingInfo.getName());
//						try{
//							
//							IObjectValue destObj = botpAppComm.transformForBotp(ctx, 
//									srcBillIDs,
//									entryNames, 
//									entriesKey, 
//									botpSelectors,
//									botMappingInfo.getDestEntityName(), 
//									new ObjectUuidPK(botMappingInfo.getId()),
//									srcBillType,
//									resultInfo);
//							// 增加到结果列表中
//							execResults.add(resultInfo);
//						}catch(Exception e){
//							System.out.println(botMappingInfo.getAlias());
//	//						if(e.getMessage().indexOf("不符合") > -1){
//								e.printStackTrace();
////								resultInfo.setError(e.getMessage());
//								// 增加到结果列表中
//								execResults.add(resultInfo);
//								continue;
//								
//	//						}else{
//	//							e.printStackTrace();
//	//						}
//						}
//						
//					}
//				}
//				
//				// 后生成调拨单据 和出库单据
//				for(int i = 0; i < outbots.size(); i++)
//				{
//					{
//						BOTMappingInfo botMappingInfo = outbots.get(i);
//						resultInfo = this.getEmptyExecresult(ctx, billInfo);
//						resultInfo.setMappingName(botMappingInfo.getAlias());
//						resultInfo.setMappingNumber(botMappingInfo.getName());
//						try{
//							
//							IObjectValue destObj = botpAppComm.transformForBotp(ctx, 
//									srcBillIDs,
//									entryNames, 
//									entriesKey, 
//									botpSelectors, 
//									botMappingInfo.getDestEntityName(), 
//									new ObjectUuidPK(botMappingInfo.getId()), 
//									srcBillType,
//									resultInfo);
//							// 增加到结果列表中
//							execResults.add(resultInfo);
//							
//						}catch(Exception e){
//							System.out.println(botMappingInfo.getAlias());
//							e.printStackTrace();
//							// 增加到结果列表中
//							execResults.add(resultInfo);
//							continue;
//
//						}
//						
//					}
//				}
//			}
//			
//		
//		
//		}catch(Exception e){
////			AppCommon.deleteBTPBills(ctx, destCol);
//			e.printStackTrace();
//			throw new FarmException(e);
//		}
//		
//		return execResults;
//	}
//	/**
//	 * 根据当前单据获得空（不包含目标单据信息）的返回结果信息
//	 * @param ctx
//	 * @param billInfo
//	 * @return
//	 */
//	private ExecBotpResultInfo getEmptyExecresult(Context ctx,CCPigDailyInfo billInfo){
//		ExecBotpResultInfo execResult = new ExecBotpResultInfo();
//		execResult.setSrcEntiryName("商品鸡日报");
//		execResult.setSrcObjectNumber(billInfo.getNumber());
//		execResult.setSrcEntityBostype(this.getBOSType().toString());
////		execResult.se
//		return execResult;
//		
//		
//	}
}