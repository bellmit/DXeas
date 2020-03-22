package com.kingdee.eas.farm.breed.business.app;

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
import com.kingdee.eas.farm.breed.BreedFacadeFactory;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.IBreedFacade;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyAssEntryCollection;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyAssEntryFactory;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyAssEntryInfo;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyEntryCollection;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyEntryInfo;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyInfo;
import com.kingdee.eas.farm.breed.business.ICommecialChilkenDailyAssEntry;
import com.kingdee.eas.farm.breed.comm.ExecBotpResultInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class CommecialChilkenDailyControllerBean extends AbstractCommecialChilkenDailyControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.breed.business.app.CommecialChilkenDailyControllerBean");




	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// 状态设置为保存
		CommecialChilkenDailyInfo info =  (CommecialChilkenDailyInfo)model;
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&&
				info.getBaseStatus() != null){
			throw new EASBizException(new NumericExceptionSubItem("001","只能保存暂存或者新增状态的单据"));

		}else{
			// 非空栏期的做校验
			if(!info.isIsHenhouseEmpty()){
				// 校验是否当天已经填报过日报
				String id = "";
				if(info.getId() != null){
					id = info.getId().toString();
				}
				//				boolean isExist = BreedFacadeFactory.getLocalInstance(ctx).checkDateDailyState(info.getBreedBatch().getId().toString(),
				//						info.getBizDate(), HenhouseType.CC.getValue(), id);
				//				if(isExist){
				//					throw new EASBizException(new NumericExceptionSubItem("001","该批次对应业务日期已经填报过日报，请不要重复填报"));
				//				}

			}
			// 校验饲料调拨计划 是否存在重复记录
			checkFodderPlan(ctx,info);
		}
		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, model);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
	EASBizException {
		// 状态设置为保存
		CommecialChilkenDailyInfo info =  this.getCommecialChilkenDailyInfo(ctx, pk);
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
		CommecialChilkenDailyInfo billInfo = (CommecialChilkenDailyInfo)model;
		if(billInfo != null  && 
				(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()) || 
						billInfo.getBaseStatus() == null)){
			billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);

			// 非空栏期的做校验
			if(!billInfo.isIsHenhouseEmpty()){
				// 校验是否当天已经填报过日报

				String id = "";
				if(billInfo.getId() != null){
					id = billInfo.getId().toString();
				}
				//				boolean isExist = BreedFacadeFactory.getLocalInstance(ctx).checkDateDailyState(billInfo.getBreedBatch().getId().toString(),
				//						billInfo.getBizDate(), HenhouseType.CC.getValue(), id);
				//				if(isExist){
				//					throw new EASBizException(new NumericExceptionSubItem("001","该批次对应业务日期已经填报过日报，请不要重复填报"));
				//				}
			}
			// 校验饲料调拨计划 是否存在重复记录
			checkFodderPlan(ctx,billInfo);
			// 提交前分摊燃煤和 燃油
			shareCoalAndDiesel(ctx,billInfo);

			return super._submit(ctx, model);
		}else{
			throw new EASBizException(new NumericExceptionSubItem("001","只能提交新增或保存状态的单据"));

		}
	}



	/**
	 * 校验 产蛋日报 要料计划，同一天不能有重复要料计划
	 * @param ctx
	 * @param billInfo
	 * @throws EASBizException 
	 * @throws BOSException 
	 */
	private void checkFodderPlan(Context ctx,CommecialChilkenDailyInfo billInfo) throws EASBizException, BOSException{

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 单据内校验不能有重复记录
		StringBuilder dateStrs = new StringBuilder("(");
		String billID = "";
		if(billInfo != null && billInfo.getId() != null){
			billID = billInfo.getId().toString();
		}
		// 单据要料计划分录
		if(billInfo.getFodderPlanEntrys() != null && billInfo.getFodderPlanEntrys().size() > 0){
			// 查询重复的日期
			String sql = "select 1 from CT_FM_CommecialCDFPE te where  te.CFFodderTowerID = ? and to_char(te.CFFodderDate,'yyyy-mm-dd') =? ";
			if(StringUtils.isNotBlank(billID)){
				sql = "select 1 from CT_FM_CommecialCDFPE te  where te.CFFodderTowerID = ? and to_char(te.CFFodderDate,'yyyy-mm-dd') =? and te.fparentid <> ?";
			}
			for(int i = 0; i < billInfo.getFodderPlanEntrys().size(); i++){
				String currPlanDateStr = sdf.format(billInfo.getFodderPlanEntrys().get(i).getFodderDate());
				String towerID = billInfo.getFodderPlanEntrys().get(i).getFodderTower().getId().toString();
				// 同一个料塔 有重复要料信息
				if(dateStrs.indexOf(currPlanDateStr+towerID) >= 0){
					throw new EASBizException(new NumericExceptionSubItem("001","要料计划分录中存在日期重复的数据"));
				}

				// 数据暂存
				dateStrs.append("'").append(currPlanDateStr).append(towerID).append("',");

				Object[] args1  = {towerID,currPlanDateStr};
				Object[] args2  = {towerID,currPlanDateStr,billID};


				try{

					IRowSet rs ;
					if(StringUtils.isNotBlank(billID)){
						rs = DbUtil.executeQuery(ctx, sql,args2);
					}else{
						rs = DbUtil.executeQuery(ctx, sql,args1);
					}
					if(rs.next()){
						throw new EASBizException(new NumericExceptionSubItem("001","要料计划分录中第" + (i+1) +"行分录料塔已经存在对应要料日期的要料计划，不能重复要料"));
					}
				}catch(SQLException sqle){
					sqle.printStackTrace();
					throw new BOSException(sqle);
				}

			}


		}
	}
	/**
	 * 分摊燃煤和 柴油
	 * @param ctx
	 * @param billInfo
	 */
	private CommecialChilkenDailyInfo shareCoalAndDiesel(Context ctx,CommecialChilkenDailyInfo billInfo){
		if(billInfo != null){
			BigDecimal coal = billInfo.getCoalFual()==null?BigDecimal.ZERO : billInfo.getCoalFual();
			BigDecimal diesel = billInfo.getDieselFual()==null?BigDecimal.ZERO : billInfo.getDieselFual();

			CommecialChilkenDailyEntryCollection entryColl = billInfo.getEntrys();
			if(entryColl != null && entryColl.size() > 0){
				BigDecimal coalShare = coal.divide(new BigDecimal(entryColl.size()), 2,RoundingMode.HALF_UP);
				BigDecimal dieselShare = diesel.divide(new BigDecimal(entryColl.size()), 2,RoundingMode.HALF_UP);
				// 尾差放到最后一条分录中
				BigDecimal coalResidue = coal.subtract(coalShare.multiply(new BigDecimal(entryColl.size())));
				BigDecimal dieselResidue = diesel.subtract(dieselShare.multiply(new BigDecimal(entryColl.size())));
				for(int i = 0; i < entryColl.size(); i++){
					CommecialChilkenDailyEntryInfo entryInfo = entryColl.get(i);
					if(i == entryColl.size() - 1){
						entryInfo.setCoalShare(coalShare.add(coalResidue));
						entryInfo.setDieselShare(dieselShare.add(dieselResidue));
					}else{
						entryInfo.setCoalShare(coalShare);
						entryInfo.setDieselShare(dieselShare);
					}
				}

			}
		}

		return billInfo;
	}
	/**
	 * 审核
	 */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		CommecialChilkenDailyInfo billInfo = (CommecialChilkenDailyInfo)model;

		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能审核");
			}

			// 根据分录状态更新 批次分录 出栏状态
			if(billInfo.getBreedBatch() != null){
				CommecialChilkenDailyAssEntryCollection entryColl = billInfo.getAssEntrys();
				String batchID = billInfo.getBreedBatch().getId().toString();

				ICommecialChilkenDailyAssEntry iEntry = CommecialChilkenDailyAssEntryFactory.getLocalInstance(ctx);
				IBreedFacade breedFacade = BreedFacadeFactory.getLocalInstance(ctx);
				for(int i = 0; i < entryColl.size(); i++){
					CommecialChilkenDailyAssEntryInfo entryInfo = entryColl.get(i);

					if(entryInfo.getHenhouse() == null){
						try {
							entryInfo = iEntry.getCommecialChilkenDailyAssEntryInfo(new ObjectUuidPK(entryInfo.getId()));
						} catch (EASBizException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// 获取出栏数量 TODO

					// 如果勾选了全部出栏
					if(entryInfo.isIsMarketed()){
						int markedQty = entryInfo.getMarketQty();
						
						breedFacade.updateBatchEntryOutState(batchID,entryInfo.getHenhouse().getId().toString(),
								true, entryInfo.getMarketQty(),billInfo.getBizDate());
					}

				}

			}
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_CommecialChilkenDaily", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);

		}else{
			throw new FarmException("只能审核提交状态的单据");
		}

	}

	/**
	 * 反审核
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException {

		CommecialChilkenDailyInfo billInfo = (CommecialChilkenDailyInfo)model;
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能反审核");
			}
			// 根据分录状态更新 批次分录 出栏状态
			if(billInfo.getBreedBatch() != null){
				CommecialChilkenDailyAssEntryCollection entryColl = billInfo.getAssEntrys();
				String batchID = billInfo.getBreedBatch().getId().toString();

				ICommecialChilkenDailyAssEntry iEntry = CommecialChilkenDailyAssEntryFactory.getLocalInstance(ctx);
				IBreedFacade breedFacade = BreedFacadeFactory.getLocalInstance(ctx);
				for(int i = 0; i < entryColl.size(); i++){
					CommecialChilkenDailyAssEntryInfo entryInfo = entryColl.get(i);

					if(entryInfo.getHenhouse() == null){
						try {
							entryInfo = iEntry.getCommecialChilkenDailyAssEntryInfo(new ObjectUuidPK(entryInfo.getId()));
						} catch (EASBizException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// 如果勾选了全部出栏
					if(entryInfo.isIsMarketed()){
						breedFacade.updateBatchEntryOutState(batchID,
								entryInfo.getHenhouse().getId().toString(),
								false, 
								0,
								null);
					}

				}

			}
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_CommecialChilkenDaily", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);

		}else{
			throw new FarmException("只能反审核审核状态的单据");
		}
	}

	/**
	 * 生成下游单据
	 */
	@Override
	protected List _genNextBill(Context ctx, IObjectValue model)
	throws BOSException {

		// 状态校验
		CommecialChilkenDailyInfo billInfo = (CommecialChilkenDailyInfo) model;
		if(!BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			throw new FarmException("只有审核状态的单据才能生成下游单据");
		}
		// 下游单据校验
		boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
		if(exist){
			throw new FarmException("已经存在下游单据，不能审核");
		}

		List<String> botIDs = AppCommon.getBillBotMappings(ctx, this.getBOSType().toString(), DefineSysEnum.BTP, true);
		CoreBaseCollection destCol=new CoreBaseCollection();

		// 结果
		List<ExecBotpResultInfo>  execResults = new ArrayList<ExecBotpResultInfo>();
		// 转换规则ID
		try{



			// 获取所有可用的botcoll
			String srcBillType = this.getBOSType().toString();
			String[] srcBillIDs = {billInfo.getId().toString()};
			String[] entryNames = {"entrys"};
			List entriesKey = new ArrayList<String>();
			CommecialChilkenDailyEntryCollection entryColl = billInfo.getEntrys();
			if(entryColl.size() > 0){
				for(int j = 0; j < entryColl.size(); j++){
					CommecialChilkenDailyEntryInfo entryInfo = entryColl.get(j);
					if(entryInfo != null && entryInfo.getId() != null){
						entriesKey.add(entryInfo.getId().toString());
					}
				}
			}

			SelectorItemCollection botpSelectors = null;

			BotpAppCommon botpAppComm = new BotpAppCommon();
			BOTMappingCollection botColl = botpAppComm.getAllCanUsedBots(ctx,srcBillType,srcBillIDs,entryNames,entriesKey,botpSelectors);

			// 获取所有可用的botp 后逐个执行操作
			if(botColl != null && botColl.size() > 0){

				BOTMappingCollection inbots = new BOTMappingCollection();
				BOTMappingCollection outbots = new BOTMappingCollection();
				for(int i = 0; i < botColl.size(); i++){


					BOTMappingInfo botMappingInfo = botColl.get(i);

					if(botMappingInfo.getAlias().indexOf("入库") > -1){
						inbots.add(botMappingInfo);
					}else{
						outbots.add(botMappingInfo);
					}

				}
				// 执行结果 
				ExecBotpResultInfo  resultInfo;
				// 先生成入库单据
				for(int i = 0; i < inbots.size(); i++)
				{
					{
						BOTMappingInfo botMappingInfo = inbots.get(i);
						resultInfo = this.getEmptyExecresult(ctx, billInfo);
						resultInfo.setMappingName(botMappingInfo.getAlias());
						resultInfo.setMappingNumber(botMappingInfo.getName());
						try{

							IObjectValue destObj = botpAppComm.transformForBotp(ctx, 
									srcBillIDs,
									entryNames, 
									entriesKey, 
									botpSelectors,
									botMappingInfo.getDestEntityName(), 
									new ObjectUuidPK(botMappingInfo.getId()),
									srcBillType,
									resultInfo);
							// 增加到结果列表中
							execResults.add(resultInfo);
						}catch(Exception e){
							System.out.println(botMappingInfo.getAlias());
							//						if(e.getMessage().indexOf("不符合") > -1){
							e.printStackTrace();
							//								resultInfo.setError(e.getMessage());
							// 增加到结果列表中
							execResults.add(resultInfo);
							continue;

							//						}else{
							//							e.printStackTrace();
							//						}
						}

					}
				}

				// 后生成调拨单据 和出库单据
				for(int i = 0; i < outbots.size(); i++)
				{
					{
						BOTMappingInfo botMappingInfo = outbots.get(i);
						resultInfo = this.getEmptyExecresult(ctx, billInfo);
						resultInfo.setMappingName(botMappingInfo.getAlias());
						resultInfo.setMappingNumber(botMappingInfo.getName());
						try{

							IObjectValue destObj = botpAppComm.transformForBotp(ctx, 
									srcBillIDs,
									entryNames, 
									entriesKey, 
									botpSelectors, 
									botMappingInfo.getDestEntityName(), 
									new ObjectUuidPK(botMappingInfo.getId()), 
									srcBillType,
									resultInfo);
							// 增加到结果列表中
							execResults.add(resultInfo);

						}catch(Exception e){
							System.out.println(botMappingInfo.getAlias());
							e.printStackTrace();
							// 增加到结果列表中
							execResults.add(resultInfo);
							continue;

						}

					}
				}
			}



		}catch(Exception e){
			//			AppCommon.deleteBTPBills(ctx, destCol);
			e.printStackTrace();
			throw new FarmException(e);
		}

		return execResults;
	}
	/**
	 * 根据当前单据获得空（不包含目标单据信息）的返回结果信息
	 * @param ctx
	 * @param billInfo
	 * @return
	 */
	private ExecBotpResultInfo getEmptyExecresult(Context ctx,CommecialChilkenDailyInfo billInfo){
		ExecBotpResultInfo execResult = new ExecBotpResultInfo();
		execResult.setSrcEntiryName("商品鸡日报");
		execResult.setSrcObjectNumber(billInfo.getNumber());
		execResult.setSrcEntityBostype(this.getBOSType().toString());
		//		execResult.se
		return execResult;


	}

}