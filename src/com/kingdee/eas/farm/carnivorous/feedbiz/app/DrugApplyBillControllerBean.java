package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kingdee.bos.*;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
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
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchHouseEntryCollection;
import com.kingdee.eas.farm.carnivorous.basedata.BatchHouseEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchHouseEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.IBatch;
import com.kingdee.eas.farm.carnivorous.basedata.IBatchHouseEntry;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillFactory;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillInfo;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.OutOrgEnum;
import com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum;
import com.kingdee.eas.farm.stocking.basedata.app.CreateCreatCostObject;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;

import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DrugApplyBillControllerBean extends AbstractDrugApplyBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.feedbiz.app.DrugApplyBillControllerBean");

	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		DrugApplyBillInfo info = DrugApplyBillFactory.getLocalInstance(ctx).getDrugApplyBillInfo(new ObjectUuidPK(((DrugApplyBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有提交的单子才可以执行此操作"));
		try {
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date()); 
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super.save(ctx, info);
		} catch (Exception ex) {
			throw new EASBizException(new NumericExceptionSubItem("001",ex.getMessage()));
		}
	}



	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		DrugApplyBillInfo info = DrugApplyBillFactory.getLocalInstance(ctx).getDrugApplyBillInfo(new ObjectUuidPK(((DrugApplyBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));
		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","有下游单据的单据禁止反审核"));
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		DrugApplyBillInfo info = (DrugApplyBillInfo) model;
		if(info.getBillStatus()!=null&&!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)&&!info.getBillStatus().equals(BillBaseStatusEnum.CLOSED)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		DrugApplyBillInfo info = (DrugApplyBillInfo) model;
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)||info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		DrugApplyBillInfo info = DrugApplyBillFactory.getLocalInstance(ctx).getDrugApplyBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||info.getBillStatus().equals(BillBaseStatusEnum.CLOSED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核或关闭，禁止删除！"));
		}

		super._delete(ctx, pk);
	}

	
	
	@Override
	protected void _close(Context ctx, IObjectValue model) throws BOSException,
	EASBizException {
		DrugApplyBillInfo info = DrugApplyBillFactory.getLocalInstance(ctx).getDrugApplyBillInfo(new ObjectUuidPK(((DrugApplyBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));

		info.setBillStatus(BillBaseStatusEnum.CLOSED);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _unClose(Context ctx, IObjectValue model) throws BOSException,
	EASBizException {
		DrugApplyBillInfo info = DrugApplyBillFactory.getLocalInstance(ctx).getDrugApplyBillInfo(new ObjectUuidPK(((DrugApplyBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.CLOSED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有关闭的单子才可以执行此操作"));

		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


}