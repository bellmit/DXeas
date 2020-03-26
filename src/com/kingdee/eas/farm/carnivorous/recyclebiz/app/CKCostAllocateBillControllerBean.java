package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

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
import com.kingdee.eas.farm.carnivorous.basedata.DailyOutSaleCPriceInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillFactory;

import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CKCostAllocateBillControllerBean extends AbstractCKCostAllocateBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.carnivorous.recyclebiz.app.CKCostAllocateBillControllerBean");
    
    protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
    {
    		CKCostAllocateBillInfo info = CKCostAllocateBillFactory.getLocalInstance(ctx).getCKCostAllocateBillInfo(new ObjectUuidPK(((CKCostAllocateBillInfo) model).getId()));
    		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
    			throw new EASBizException(new NumericExceptionSubItem("001","只有提交的单子才可以执行此操作"));
//    		checkIsHasSame(ctx, info);
    		info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
    }
  
    
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
    {
    		CKCostAllocateBillInfo info = CKCostAllocateBillFactory.getLocalInstance(ctx).getCKCostAllocateBillInfo(new ObjectUuidPK(((CKCostAllocateBillInfo) model).getId()));
    		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
    			throw new EASBizException(new NumericExceptionSubItem("001","有下游单据的单据禁止反审核"));
    			if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
    			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));
    	
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setAuditTime(null);
			info.setAuditor(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
    }
    
    
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
    	CKCostAllocateBillInfo info = (CKCostAllocateBillInfo) model;
    	if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增或者保存的单子才可以执行此操作"));
//		checkIsHasSame(ctx, info);
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
    		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
    	}
		return super._save(ctx, info);
	}
    
    @Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
    	CKCostAllocateBillInfo info = (CKCostAllocateBillInfo) model;
    	if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增、保存或提交的单子才可以执行此操作"));
//		checkIsHasSame(ctx, info);
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
    		info.setBillStatus(BillBaseStatusEnum.SUBMITED); 
    	}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CKCostAllocateBillInfo info = CKCostAllocateBillFactory.getLocalInstance(ctx).getCKCostAllocateBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		if(WorkFlowUtil.checkBillInWorkflow(ctx,pk.toString())){
			throw new EASBizException(new NumericExceptionSubItem("001","当前单据尚在工作流执行过程,不能执行该操作"));
		}
		super._delete(ctx, pk);
	}
	
	private void checkIsHasSame(Context ctx,CKCostAllocateBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		String sql="/*dialect*/select * from CT_FM_CKCostAllocateBill where CFBillStatus =4 and CFFICompanyID='"+info.getFICompany().getId().toString()+"' " +
				"and CFPeriodID='"+info.getPeriod().getId().toString()+"'" +
						" and CFCostCenterID = '"+info.getCostCenter().getId()+"'";
		try {
			if(DbUtil.executeQuery(ctx, sql).size()>0){
				throw new EASBizException(new NumericExceptionSubItem("001","该期间该成本中心已存在已审核的费用分摊单,执行失败!"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}