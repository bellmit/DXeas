package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.farm.carnivorous.basedata.RewardAndPunishItemFactory;
import com.kingdee.eas.farm.carnivorous.basedata.RewardAndPunishItemInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKCloseAccountFacadeFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillQCEntryCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillQCEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillInfo;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillCollection;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;

import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.base.botp.BOTPException;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PreHouseWgtBillControllerBean extends AbstractPreHouseWgtBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.recyclebiz.app.PreHouseWgtBillControllerBean");

	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		PreHouseWgtBillInfo info = PreHouseWgtBillFactory.getLocalInstance(ctx).getPreHouseWgtBillInfo(new ObjectUuidPK(((PreHouseWgtBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有提交的单子才可以执行此操作"));
		checkIsSettled(ctx, info);		
		checkIsGuanZhang(ctx, info);
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
		//生成屠宰单
		Boolean isHasTuZai=createToCSLBill(ctx, info);
		info.setIsHasTuZai(isHasTuZai);
		//生成结算单
		Boolean isSettled = createToSettleBill(ctx, info);
		updatePreHouseBill(ctx, info, isSettled);
		info.setIsSettled(isSettled);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		PreHouseWgtBillInfo info = PreHouseWgtBillFactory.getLocalInstance(ctx).getPreHouseWgtBillInfo(new ObjectUuidPK(((PreHouseWgtBillInfo) model).getId()));
		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","有下游单据的单据禁止反审核"));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		PreHouseWgtBillInfo info = (PreHouseWgtBillInfo) model;
		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增或者保存的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		PreHouseWgtBillInfo info = (PreHouseWgtBillInfo) model;
		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增、保存或提交的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED); 
		}
		super._update(ctx,new ObjectUuidPK( info.getId()), info);
		_audit(ctx, info);
		info=PreHouseWgtBillFactory.getLocalInstance(ctx).getPreHouseWgtBillInfo(new ObjectUuidPK(((PreHouseWgtBillInfo) model).getId()));
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		PreHouseWgtBillInfo info = PreHouseWgtBillFactory.getLocalInstance(ctx).getPreHouseWgtBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("/*dialect*/update  CT_FM_CCarSendBill  t1 ")
			.append(" set  t1.CFIsHasPQGB ='0'")
			.append(" where t1.fid in(select t3.FSrcObjectID from CT_FM_PreHouseWgtBill t2 inner join T_BOT_Relation t3 ")
			.append(" on t2.fid=t3.FDestObjectID and t3.FSrcEntityID='"+new CCarSendBillInfo().getBOSType().toString()+"' where t2.fid='"+info.getId().toString()+"') ");
			DbUtil.execute(ctx, sql.toString());
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append("/*dialect*/update  CT_FM_ChickenRecBill  t1 ")
			.append(" set  t1.CFIsHasPQGB ='0'")
			.append(" where t1.fid in(select t3.FSrcObjectID from CT_FM_PreHouseWgtBill t2 inner join T_BOT_Relation t3 ")
			.append(" on t2.fid=t3.FDestObjectID and t3.FSrcEntityID='"+new ChickenRecBillInfo().getBOSType().toString()+"' where t2.fid='"+info.getId().toString()+"') ");
			DbUtil.execute(ctx, sqlBuf.toString());
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		super._delete(ctx, pk);
	}

	private void checkIsSettled(Context ctx,PreHouseWgtBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		Boolean isHasSettled = StockingComm.checkIsHasSettled(ctx, info.getBatchContract().getId().toString());
		if(isHasSettled){
			throw new EASBizException(new NumericExceptionSubItem("001","该批次已完全回收结算,操作失败!"));
		}
	}
	
	private void checkIsGuanZhang(Context ctx,PreHouseWgtBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		boolean isGuanZhang=false;
		String companyID = info.getFICompany().getId().toString();
		PeriodInfo period=DateUtilsComm.getPeriodInfoByDate(ctx,info.getBizDate());
		String periodID=period==null?"":period.getId().toString();
		try {
			isGuanZhang= CKCloseAccountFacadeFactory.getLocalInstance(ctx).checkIsClosed(companyID, periodID);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isGuanZhang){
			throw new EASBizException(new NumericExceptionSubItem("001","业务日期对应期间内该公司已执行了关账操作,当前操作失败!"));
		}
	}
	/**
	 * 生成屠宰单
	 * @param ctx
	 * @param info
	 * @throws EASBizException 
	 */
	private Boolean createToCSLBill(Context ctx,PreHouseWgtBillInfo info) throws BOSException, EASBizException{
		Boolean isHasCSL=false;
		String destBillType=null;
		ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
		BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
		OrgUnitInfo orgInfo=info.getFICompany();
		destBillType=new CSlaughterBillInfo().getBOSType().toString();
		BOTMappingCollection btpCols;
		btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
		for(int index=0;index<btpCols.size();index++) {
			CSlaughterBillInfo cSLInfo  = (CSlaughterBillInfo)btpIS.createToOrderBill(ctx, info, destBillType, btpCols.get(index));
			isHasCSL=true;
			try {
				String orgUnitID=ContextUtil.getCurrentOrgUnit(ctx).getId().toString();
				if(iCodingRuleManager.isExist(cSLInfo, orgUnitID)){
					if(iCodingRuleManager.isUseIntermitNumber(cSLInfo, orgUnitID)){
						//编码规则不允许断号 --> 获取断号编码
						cSLInfo.setNumber(iCodingRuleManager.getNonbreakNumber(cSLInfo,orgUnitID));
					}else{
						cSLInfo.setNumber(iCodingRuleManager.getNumber(cSLInfo,orgUnitID));
					}
				}
				cSLInfo=setItemForQc(ctx, cSLInfo);
				BigDecimal dressingPercent = StockingComm.getDressingPercent(ctx, info.getFICompany().getId().toString(), info.getCustomer().getId().toString(), info.getBreedData().getId().toString());
				cSLInfo.setDressingPercent(dressingPercent);
				CSlaughterBillFactory.getLocalInstance(ctx).save(cSLInfo);
			} catch (BOTPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return isHasCSL;
	}

	//反写该批次所有棚前过磅单
	private void updatePreHouseBill(Context ctx, PreHouseWgtBillInfo info,Boolean isSettled) {
		// TODO Auto-generated method stub
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/update CT_FM_PreHouseWgtBill ")
		.append(" set CFIsSettled=").append(isSettled?1:0)
		.append(" where CFBatchContractID ='"+info.getBatchContract().getId().toString()+"' ");
		try {
			DbUtil.execute(ctx, sqlBuf.toString());
		} catch (BOSException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成结算单
	 * @param ctx
	 * @param info
	 * @throws EASBizException 
	 */
	private Boolean createToSettleBill(Context ctx,PreHouseWgtBillInfo info) throws BOSException, EASBizException{
		if(StockingComm.checkIsHasPreHouseSettleBill(ctx, info.getBatchContract().getId().toString(),null)){
			return true;
		}
		String destBillType=null;
		ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
		BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
		OrgUnitInfo orgInfo=info.getFICompany();
		destBillType=new CKSettleBillInfo().getBOSType().toString();
		BOTMappingCollection btpCols;
		btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
		if(btpCols.size()>0) {
			CKSettleBillInfo cKSInfo  = (CKSettleBillInfo)btpIS.createToOrderBill(ctx, info, destBillType, btpCols.get(0));
			try {
				String orgUnitID=ContextUtil.getCurrentOrgUnit(ctx).getId().toString();
				if(iCodingRuleManager.isExist(cKSInfo, orgUnitID)){
					if(iCodingRuleManager.isUseIntermitNumber(cKSInfo, orgUnitID)){
						//编码规则不允许断号 --> 获取断号编码
						cKSInfo.setNumber(iCodingRuleManager.getNonbreakNumber(cKSInfo,orgUnitID));
					}else{
						cKSInfo.setNumber(iCodingRuleManager.getNumber(cKSInfo,orgUnitID));
					}
				}
				CKSettleBillFactory.getLocalInstance(ctx).save(cKSInfo);
				return true;
			} catch (BOTPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	private CSlaughterBillInfo setItemForQc(Context ctx,CSlaughterBillInfo info) {
		String sql="select distinct t1.fid from CT_FM_RewardAndPunishItem t1 inner join CT_FM_RandPPolicy t4 on t4.CFRandPItemID=t1.fid " +
		" inner join T_FM_SettlePolicyAwardsEntry  t2 on t2.CFRandPPolicyID=t4.fid inner join T_FM_SettlePolicy t3 on t2.fparentid=t3.fid  where t3.fid='"+info.getSettlePolicy().getId().toString()+"' and t1.CFScope='0'";
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql);
			while (rs.next()) {
				String id=rs.getString("fid");
				RewardAndPunishItemInfo item=RewardAndPunishItemFactory.getLocalInstance(ctx).getRewardAndPunishItemInfo(new ObjectUuidPK(id));
				CSlaughterBillQCEntryInfo entry=new CSlaughterBillQCEntryInfo();
				entry.setQCItem(item);
				entry.setRandPType(item.getPunishType());
				info.getQCEntrys().add(entry);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}
}