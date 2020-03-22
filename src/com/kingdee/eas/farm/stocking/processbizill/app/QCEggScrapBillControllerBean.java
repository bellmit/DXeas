package com.kingdee.eas.farm.stocking.processbizill.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
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

import com.kingdee.eas.farm.stocking.processbizill.QCEggScrapBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.QCEggScrapBillInfo;
import com.kingdee.eas.farm.stocking.processbizill.QCEggScrapBillCollection;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.stocking.processbizill.QCEggScrapBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class QCEggScrapBillControllerBean extends AbstractQCEggScrapBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.processbizill.app.QCEggScrapBillControllerBean");

    protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		QCEggScrapBillInfo info = getQCEggScrapBillInfo(ctx,new ObjectUuidPK(((QCEggScrapBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有提交的单子才可以执行此操作"));
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException{
		QCEggScrapBillInfo info = getQCEggScrapBillInfo(ctx,new ObjectUuidPK(((QCEggScrapBillInfo) model).getId()));
		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","有下游单据的单据禁止反审核"));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		QCEggScrapBillInfo info = (QCEggScrapBillInfo) model;
		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增或者保存的单子才可以执行此操作"));
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		QCEggScrapBillInfo info = (QCEggScrapBillInfo) model;
		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增、保存或提交的单子才可以执行此操作"));
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED); 
		}
		return super._submit(ctx, info);
	}

	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		QCEggScrapBillInfo info = QCEggScrapBillFactory.getLocalInstance(ctx).getQCEggScrapBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		if(WorkFlowUtil.checkBillInWorkflow(ctx,pk.toString())){
			throw new EASBizException(new NumericExceptionSubItem("001","当前单据尚在工作流执行过程,不能执行该操作"));
		}
		super._delete(ctx, pk);
	}
}