package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

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
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.CTransFodderBillCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.CTransFodderBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.CTransFodderBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReception;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKCloseAccountFacadeFactory;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;
import com.kingdee.eas.base.botp.BOTPException;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CTransFodderBillControllerBean extends AbstractCTransFodderBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.feedbiz.app.CTransFodderBillControllerBean");

	protected void _audit(Context ctx, IObjectValue model)throws BOSException{
		try {
			CTransFodderBillInfo info = CTransFodderBillFactory.getLocalInstance(ctx).getCTransFodderBillInfo(new ObjectUuidPK(((CTransFodderBillInfo) model).getId()));
			checkIsSettled(ctx, info);
			checkIsGuanZhang(ctx, info);
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
			//生成供应链单据
			createToSCMBill(ctx, info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
	}
	/**
	 * add by sun 生成审核状态的转入、转出饲料领用单
	 * @param ctx
	 * @param info
	 * @throws EASBizException 
	 */
	private void createToSCMBill(Context ctx, CTransFodderBillInfo info) throws BOSException, EASBizException {
		String destBillType=null;
		ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
		BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
		OrgUnitInfo orgInfo=info.getCompany();
		destBillType="713C6B15";
		BOTMappingCollection btpCols;
		btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
		for(int index=0;index<btpCols.size();index++) {
			FodderReceptionInfo fodderReceptionInfo  = (FodderReceptionInfo)btpIS.createToOrderBill(ctx, info, destBillType, btpCols.get(index));
			String orgUnitID=ContextUtil.getCurrentOrgUnit(ctx).getId().toString();
			if(iCodingRuleManager.isExist(info, orgUnitID)){
				if(iCodingRuleManager.isUseIntermitNumber(info, orgUnitID)){
					//编码规则不允许断号 --> 获取断号编码
					fodderReceptionInfo.setNumber(iCodingRuleManager.getNonbreakNumber(info,orgUnitID));
				}else{
					fodderReceptionInfo.setNumber(iCodingRuleManager.getNumber(info,orgUnitID));
				}
			}
			fodderReceptionInfo.setIsFromTiaoLiao(true);
			FodderReceptionFactory.getLocalInstance(ctx).submit(fodderReceptionInfo);
			FodderReceptionFactory.getLocalInstance(ctx).audit(fodderReceptionInfo);
		}
	}

	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{			
		CTransFodderBillInfo info = CTransFodderBillFactory.getLocalInstance(ctx).getCTransFodderBillInfo(new ObjectUuidPK(((CTransFodderBillInfo) model).getId()));
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);
		beforeUnAudit(ctx,info);
		try {
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
		CTransFodderBillInfo info = ( CTransFodderBillInfo) model;
		checkIsSettled(ctx, info);
		StockingComm.checkIsOutMonth(ctx, info.getBizDate(), info.getBatchContract().getId().toString());
		StockingComm.checkIsOutMonth(ctx, info.getBizDate(), info.getTargetBatchContract().getId().toString());
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		CTransFodderBillInfo info = ( CTransFodderBillInfo) model;
		checkIsSettled(ctx, info);
		StockingComm.checkIsOutMonth(ctx, info.getBizDate(), info.getBatchContract().getId().toString());
		StockingComm.checkIsOutMonth(ctx, info.getBizDate(), info.getTargetBatchContract().getId().toString());
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CTransFodderBillInfo info =  CTransFodderBillFactory.getLocalInstance(ctx).getCTransFodderBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		super._delete(ctx, pk);
	}


	private void beforeUnAudit(Context ctx, CTransFodderBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		Map<String, HashSet<String>> result1;
		try {
			IFodderReception iFodderReception = FodderReceptionFactory.getLocalInstance(ctx);
			result1 = BotpAppCommon.getBillIDsByRelation(ctx, info.getBOSType().toString(), info.getId().toString(), new FodderReceptionInfo().getBOSType().toString(), null);
			HashSet<String> destBillIDs=result1.get("destBillIDs");
			if(destBillIDs.size()>0){
				for(String destBillID :destBillIDs){
					Map<String, HashSet<String>> result2=BotpAppCommon.getBillIDsByRelation(ctx,new FodderReceptionInfo().getBOSType().toString(), destBillID, null, null);
					HashSet<String> destBillIDs2=result2.get("destBillIDs");
					if(destBillIDs2.size()>0){
						throw new EASBizException(new NumericExceptionSubItem("001","单据的下游单据已生成下下游单据,禁止反审核"));
					}else{
						//删除下游单据(饲料领用单)
						FodderReceptionInfo fodderReceptionInfo=iFodderReception.getFodderReceptionInfo(new ObjectUuidPK(destBillID));
						if(fodderReceptionInfo.getBillStatus().equals(BillBaseStatusEnum.AUDITED)){
							fodderReceptionInfo.setIsFromTiaoLiao(false);
							iFodderReception.update(new ObjectUuidPK(fodderReceptionInfo.getId()), fodderReceptionInfo);
							iFodderReception.unAudit(fodderReceptionInfo);
						}
						iFodderReception.delete(new ObjectUuidPK(destBillID));
					}
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void checkIsSettled(Context ctx,CTransFodderBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		Boolean isHasSettled1 = StockingComm.checkIsHasSettled(ctx, info.getBatchContract().getId().toString());
		Boolean isHasSettled2 = StockingComm.checkIsHasSettled(ctx, info.getTargetBatchContract().getId().toString());
		if(isHasSettled1||isHasSettled2){
			throw new EASBizException(new NumericExceptionSubItem("001","该批次已完全回收结算,操作失败!"));
		}
	}
	
	private void checkIsGuanZhang(Context ctx,CTransFodderBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		boolean isGuanZhang=false;
		String companyID = info.getCompany().getId().toString();
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
}