package com.kingdee.eas.farm.carnivorous.basebiz.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

import com.kingdee.bos.*;
import com.kingdee.bos.ui.face.UIRuleUtil;
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
import java.math.BigDecimal;

import com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillInfo;
import com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillFactory;
import com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillCollection;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.taihe.contract.BatchContract;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MarginUnlockBillControllerBean extends AbstractMarginUnlockBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.basebiz.app.MarginUnlockBillControllerBean");

	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException{
		MarginUnlockBillInfo info = MarginUnlockBillFactory.getLocalInstance(ctx).getMarginUnlockBillInfo(new ObjectUuidPK(((MarginUnlockBillInfo) model).getId()));
		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ���ύ�ĵ��Ӳſ���ִ�д˲���"));
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		updateFarmerMarginForAudit(ctx, info);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	private void updateFarmerMarginForAudit(Context ctx, MarginUnlockBillInfo info) {
		try {
			for(int i=0;i<info.getEntrys().size();i++){
				MarginUnlockBillEntryInfo entry = info.getEntrys().get(i);
				BigDecimal entryUnlockAmt=entry.getUnlockAmt()==null?BigDecimal.ZERO:entry.getUnlockAmt();
				if(entry.isIsUnlockInit()){
					String sql="update CT_FM_MarginInitBillEntry set CFUnLockedOpMargin=isnull(CFUnLockedOpMargin,0)+("+entryUnlockAmt+") where CFFarmerID='"+info.getFarmer().getId().toString()+"'";
					DbUtil.execute(ctx, sql);	
				}else{
					String sql="update T_FM_BatchContractBill set CFUnlockMargin=isnull(CFUnlockMargin,0)+("+entryUnlockAmt+") where fid='"+entry.getBatchContract().getId().toString()+"'";
					DbUtil.execute(ctx, sql);	
				}
				String sqlFarmer="update CT_FM_Farmer set cfenableMargin=isnull(cfenableMargin,0)+("+entryUnlockAmt+"),cfoccupyMargin=isnull(cfoccupyMargin,0)-("+entryUnlockAmt+") where fid='"+info.getFarmer().getId().toString()+"'";
				DbUtil.execute(ctx, sqlFarmer);
			}	
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		MarginUnlockBillInfo info = MarginUnlockBillFactory.getLocalInstance(ctx).getMarginUnlockBillInfo(new ObjectUuidPK(((MarginUnlockBillInfo) model).getId()));
		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","�����ε��ݵĵ��ݽ�ֹ�����"));

		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ����˵ĵ��Ӳſ���ִ�д˲���"));
		if(info.isIsFromSettleBill()){
			throw new EASBizException(new NumericExceptionSubItem("001","�ɽ��㵥���ɵĵ��ݲ�����ִ�д˲���"));
		}
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);
		updateFarmerMarginForUnAudit(ctx, info);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	private void updateFarmerMarginForUnAudit(Context ctx, MarginUnlockBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<info.getEntrys().size();i++){
				MarginUnlockBillEntryInfo entry = info.getEntrys().get(i);
				BigDecimal entryUnlockAmt=entry.getUnlockAmt()==null?BigDecimal.ZERO:entry.getUnlockAmt();
				if(entry.isIsUnlockInit()){
					String sql="update CT_FM_MarginInitBillEntry set CFUnLockedOpMargin=isnull(CFUnLockedOpMargin,0)-("+entryUnlockAmt+") where CFFarmerID='"+info.getFarmer().getId().toString()+"'";
					DbUtil.execute(ctx, sql);	
				}else{
					FarmerInfo farmer=FarmerFactory.getLocalInstance(ctx).getFarmerInfo(new ObjectUuidPK(info.getFarmer().getId().toString()));
					BatchContractBillInfo batchContractBill = BatchContractBillFactory.getLocalInstance(ctx).getBatchContractBillInfo(new ObjectUuidPK(entry.getBatchContract().getId().toString()));
					BigDecimal enableMargin = UIRuleUtil.getBigDecimal(farmer.getEnableMargin());
					BigDecimal canUnlockMargin = UIRuleUtil.getBigDecimal(batchContractBill.getUsedMargin()).subtract(UIRuleUtil.getBigDecimal(batchContractBill.getUnlockMargin()));
					if(enableMargin.compareTo(canUnlockMargin)<0){
						throw new EASBizException(new NumericExceptionSubItem("001","��ǰ�������ñ�֤����С�ڸ����οɽ������,����ʧ��!"));
					}
					String sql="update T_FM_BatchContractBill set CFUnlockMargin=isnull(CFUnlockMargin,0)-("+entryUnlockAmt+") where fid='"+entry.getBatchContract().getId().toString()+"'";
					DbUtil.execute(ctx, sql);	
				}
				String sqlFarmer="update CT_FM_Farmer set cfenableMargin=isnull(cfenableMargin,0)-("+entryUnlockAmt+"),cfoccupyMargin=isnull(cfoccupyMargin,0)+("+entryUnlockAmt+") where fid='"+info.getFarmer().getId().toString()+"'";
				DbUtil.execute(ctx, sqlFarmer);
			}

		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MarginUnlockBillInfo info = (MarginUnlockBillInfo) model;
		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED))
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ���������߱���ĵ��Ӳſ���ִ�д˲���"));
		checkIsHasUnAuditBill(ctx, info);
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		MarginUnlockBillInfo info = (MarginUnlockBillInfo) model;
		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ��������������ύ�ĵ��Ӳſ���ִ�д˲���"));
		checkIsHasUnAuditBill(ctx, info);
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED); 
		}
		return super._submit(ctx, info);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MarginUnlockBillInfo info = MarginUnlockBillFactory.getLocalInstance(ctx).getMarginUnlockBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѿ���ˣ���ֹɾ����"));
		}
		if(WorkFlowUtil.checkBillInWorkflow(ctx,pk.toString())){
			throw new EASBizException(new NumericExceptionSubItem("001","��ǰ�������ڹ�����ִ�й���,����ִ�иò���"));
		}
		super._delete(ctx, pk);
	}

	private void checkIsHasUnAuditBill(Context ctx, MarginUnlockBillInfo info) throws EASBizException {
		for(int i=0;i<info.getEntrys().size();i++){
			MarginUnlockBillEntryInfo entry = info.getEntrys().get(i);
			if(entry.getBatchContract()!=null){
				StringBuffer sqlBuf = new StringBuffer();
				sqlBuf.append(" select t1.fnumber fnumber  from  CT_FM_MarginUnlockBill t1  ")
				.append(" inner join  CT_FM_MarginUnlockBillEntry t2 on t1.fid=t2.fparentid ")
				.append(" where t1.CFBillStatus <> 4 ")
				.append(" and  t2.CFBatchContractID='"+entry.getBatchContract().getId().toString()+"' ");
				if(info.getId()!=null){
					sqlBuf.append(" and t1.fid<>'"+info.getId().toString()+"'");
				}
				IRowSet rs;
				try {
					rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
					if(rs.next()){
						throw new EASBizException(new NumericExceptionSubItem("001","������ͬ���εı��Ϊ"+rs.getString("fnumber")+" �ı�֤�������δ���,����ʧ��!"));
					}
				} catch (BOSException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}