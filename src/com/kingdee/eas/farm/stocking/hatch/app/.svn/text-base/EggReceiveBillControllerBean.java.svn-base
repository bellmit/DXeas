package com.kingdee.eas.farm.stocking.hatch.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.OutOrgEnum;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.hatch.EggReceiveBillFactory;
import com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo;
import com.kingdee.eas.farm.stocking.hatch.StatisticsType;
import com.kingdee.eas.farm.stocking.hatch.bean.EggPriceBean;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class EggReceiveBillControllerBean extends AbstractEggReceiveBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.hatch.app.EggReceiveBillControllerBean");
    protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
    	try {
    		EggReceiveBillInfo info = (EggReceiveBillInfo) model;
    		
    		
    		//生成供应链单据
    		createToSCMBill(ctx, info);
    		//生成种蛋结算单单
    		new StockingHatchFacadeControllerBean()._createToEggSettleBill(ctx, info);
    		
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
    }
   
    
    /**
     * 设置分录价格
     * @param ctx
     * @param info
     */
    private void setEntryPrice(Context ctx,EggReceiveBillInfo info) throws Exception {
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	//蛋品物料对应
    	StringBuffer sql=new StringBuffer();
    	sql.append(" select distinct tm.fname_l2 fmaterialName")
    	.append(" from T_FM_EggRelationEntry tentry")
    	.append(" inner join T_FM_EggRelation tmain tmain.fid=tentry.fparentid")
    	.append(" inner join t_bd_material tm on tm.fparentid=tmain.FMaterialID")
    	.append(" where tmain.fcompanyid='").append(info.getCompany().getString("id")).append("'")
    	.append(" and tmain.fbasestatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
    	.append(" and tmain.fmaterialid not in (")
    	.append(" select tentry.FMaterialID")
    	.append(" from T_FM_EggPriceDataPrice tmain")
    	.append(" inner join T_FM_EggPriceDataPriceEntry tentry on tentry.fparentid=tmain.fid")
    	.append(" where tmain.fcompanyID='").append(info.getCompany().getString("id")).append("'")
    	.append(" and FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
    	.append(" and tmain.FBeginDate<={d '").append(sdf.format(info.getBizDate())).append("'}")
    	.append(" and tmain.FEndDate>={d '").append(sdf.format(info.getBizDate())).append("'}")
    	.append(" )");
    	IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
    	String msg="";
    	while(rs.next()) {
    		msg+=rs.getString("fmaterialName")+" ";
    	}
    	if(msg.length()>0) {
    		throw new Exception("物料"+msg+"今日价格尚未维护！");
    	}
    	//<单位,<物料,bean>>
    	HashMap<String,HashMap<String,EggPriceBean> > priceMap=new HashMap<String, HashMap<String,EggPriceBean>>();
    	//蛋品价格
    	sql.setLength(0);
    	sql.append(" select tentryPrice.fmateiralid,tentryPrice.funitid,tentryPrice.fprice,tmain.FFieldNum")
    	.append(" from join T_FM_EggRelation tmain ")
    	.append(" inner join T_FM_EggPriceDataPriceEntry tentryPrice on tentryPrice.fmaterialID=tmain.fmaterialid")
    	.append(" inner join  T_FM_EggPriceDataPrice tmainPrice  on tentryPrice.fparentid=tmain.fid")
    	.append(" where tmain.fcompanyID='").append(info.getCompany().getString("id")).append("'")
    	.append(" and FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
    	.append(" and tmain.FBeginDate<={d '").append(sdf.format(info.getBizDate())).append("'}")
    	.append(" and tmain.FEndDate>={d '").append(sdf.format(info.getBizDate())).append("'}")
    	.append(" and tmain.fcompanyid='").append(info.getCompany().getString("id")).append("'")
    	.append(" and tmain.fbasestatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
    	.append(" )");
    	rs = DbUtil.executeQuery(ctx, sql.toString());
    	String keepID=null;
    	HashMap<String,EggPriceBean> tempMap;
		EggPriceBean bean;
    	while(rs.next()) {
    		if(keepID==null) {
    			keepID=rs.getString("fid");
    		}else{
    			if(!keepID.equals(rs.getString("fid"))) {
    				break;
    			}
    		}
    		if(priceMap.containsKey(rs.getString("funitID"))) {
    			tempMap=priceMap.get(rs.getString("funitID"));
    		}else {
    			tempMap=new HashMap<String, EggPriceBean>();
    			priceMap.put(rs.getString("funitID"), tempMap);
    		}
    		if(tempMap.containsKey(rs.getString("fmaterialid"))) {
    			bean=tempMap.get(rs.getString("fmaterialid"));
    		}else{
	    		bean=new EggPriceBean();
	    		bean.setMaterialID(rs.getString("fmaterialid"));
	    		bean.setUnitID(rs.getString("funitid"));
	    		bean.setPriceField(rs.getString("fprirceField"));
	    		bean.setPrice(rs.getBigDecimal("fprice"));
	    		
	    		tempMap.put(rs.getString("fmaterialid"), bean);
    		}
//    		bean.getFiledList().add(rs.getString("FFieldNum"));
    	}
    	
    	//写入单价
    	String unitID;
    	Iterator<Entry<String, EggPriceBean>> dd;
    	for(int index=0;index<info.getEntrys().size();index++){
    		if(info.getEntrys().get(index).getStatisticsType()==null||info.getEntrys().get(index).getStatisticsType().equals(StatisticsType.AvgWeight)) {
    			continue;
    		}
    		unitID=info.getEntrys().get(index).getUnit().getString("id");
    		
    		if(priceMap.containsKey("unitID")) {
    			tempMap=priceMap.get(unitID);
    			dd = tempMap.entrySet().iterator();
    			if(dd.hasNext()){
    				bean = dd.next().getValue();
    				info.getEntrys().get(index).setBigDecimal(bean.getPriceField(), bean.getPrice());
//    				for(String field:bean.getFiledList()) {
//    					info.getEntrys().get(index).setBigDecimal(field, bean.getPrice());
//    				}
    			}
    		}
    	}
    }
    
    @Override
	protected void _deleteDownBill(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}


	/**
     * 生成供应链单据
     * @param ctx
     * @param info
     */
    private void createToSCMBill(Context ctx,EggReceiveBillInfo info) throws BOSException {
    	try {
    		
    		BaseSysSettingInfo sysInfo = StockingComm.getSysSetting(ctx,info.getCompany().getString("id"));
    		if(!sysInfo.isIsAutoSCM()) {
    			return;
    		}
    		String destBillType=null;
			BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
			OrgUnitInfo orgInfo=info.getCompany();
			

			//如果存在别的养殖公司，先有养殖公司调入，然后再领出
			for(int index=0;index<sysInfo.getStorageEntry().size();index++) {
				if(sysInfo.getStorageEntry().get(index).getOutOrgType().equals(OutOrgEnum.breedOrg)) {
					destBillType=BotpCommUtils.TransBill_BOSTYPE;
					BOTMappingCollection btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
					for(index=0;index<btpCols.size();index++) {
						btpIS.createToSCMBill(ctx, info,destBillType, btpCols.get(index));
					}
					break;
				}
			}
			
    		//内部管理 生成领料出
    		if(sysInfo.isIsInner()) {
    			//然后生成生领料出
    			destBillType=BotpCommUtils.MaterialReq_BOSTYPE;
    			
    		}else{//外部管理 生成销售出
    			destBillType=BotpCommUtils.SaleIssueBill_BOSTYPE;
    		}

			BOTMappingCollection btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
			for(int index=0;index<btpCols.size();index++) {
				btpIS.createToSCMBill(ctx, info,destBillType, btpCols.get(index));
			}
    	}catch(Exception err) {
    		throw new BOSException(err);
    	}
    }
    
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
    {
    	try {
    		EggReceiveBillInfo info = (EggReceiveBillInfo) model;
    		if(info != null && info.getBillStatus() != null && BillBaseStatusEnum.AUDITED.equals(info.getBillStatus())){
    			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), info.getId().toString());
    			if(exist){
    				throw new EASBizException(new NumericExceptionSubItem("001","已经存在下游单据，不能反审核"));
    			}
    		}
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setAuditTime(null);
			info.setAuditor(null);
			
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
    }
    
    
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
    	EggReceiveBillInfo info = (EggReceiveBillInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
    		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
    	}
		return super._save(ctx, info);
	}
    
    @Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
    	EggReceiveBillInfo info = (EggReceiveBillInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
    		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
    	}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		EggReceiveBillInfo info = EggReceiveBillFactory.getLocalInstance(ctx).getEggReceiveBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		
		if(info != null && info.getBillStatus() != null && BillBaseStatusEnum.AUDITED.equals(info.getBillStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), info.getId().toString());
			if(exist){
				throw new EASBizException(new NumericExceptionSubItem("001","已经存在下游单据，不能删除"));
			}
		}
		super._delete(ctx, pk);
	}
	@Override
	protected void _showPriceCol(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void _viewAllBill(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void _toSettleBill(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void _setColor(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}
}