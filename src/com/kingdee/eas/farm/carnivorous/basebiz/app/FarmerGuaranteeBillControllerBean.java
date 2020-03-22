package com.kingdee.eas.farm.carnivorous.basebiz.app;

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
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillFactory;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillCollection;
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

public class FarmerGuaranteeBillControllerBean extends AbstractFarmerGuaranteeBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.carnivorous.basebiz.app.FarmerGuaranteeBillControllerBean");
    
    protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
    {
    		FarmerGuaranteeBillInfo info = FarmerGuaranteeBillFactory.getLocalInstance(ctx).getFarmerGuaranteeBillInfo(new ObjectUuidPK(((FarmerGuaranteeBillInfo) model).getId()));
    		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
    			throw new EASBizException(new NumericExceptionSubItem("001","ֻ���ύ�ĵ��Ӳſ���ִ�д˲���"));
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

			super._update(ctx, new ObjectUuidPK(info.getId()), info);
    }
  
    
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
    {
    		FarmerGuaranteeBillInfo info = FarmerGuaranteeBillFactory.getLocalInstance(ctx).getFarmerGuaranteeBillInfo(new ObjectUuidPK(((FarmerGuaranteeBillInfo) model).getId()));
    		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
    			throw new EASBizException(new NumericExceptionSubItem("001","�����ε��ݵĵ��ݽ�ֹ�����"));
    			if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
    			throw new EASBizException(new NumericExceptionSubItem("001","ֻ����˵ĵ��Ӳſ���ִ�д˲���"));
    		
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setAuditTime(null);
			info.setAuditor(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
    }
    
    
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
    	FarmerGuaranteeBillInfo info = (FarmerGuaranteeBillInfo) model;
    	if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ���������߱���ĵ��Ӳſ���ִ�д˲���"));
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
    		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
    	}
		return super._save(ctx, info);
	}
    
    @Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
    	FarmerGuaranteeBillInfo info = (FarmerGuaranteeBillInfo) model;
    	if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ��������������ύ�ĵ��Ӳſ���ִ�д˲���"));
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
    		info.setBillStatus(BillBaseStatusEnum.SUBMITED); 
    	}
		return super._submit(ctx, info);
	}
    
  //����
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerGuaranteeBillInfo info = FarmerGuaranteeBillFactory.getLocalInstance(ctx).getFarmerGuaranteeBillInfo(new ObjectUuidPK(((FarmerGuaranteeBillInfo) model).getId()));
		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ����˵ĵ��Ӳſ���ִ�д˲���"));
		info.setBillStatus(BillBaseStatusEnum.cancel);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}
	
	//����
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerGuaranteeBillInfo info = FarmerGuaranteeBillFactory.getLocalInstance(ctx).getFarmerGuaranteeBillInfo(new ObjectUuidPK(((FarmerGuaranteeBillInfo) model).getId()));
		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.cancel))
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ�н��õĵ��Ӳſ���ִ�д˲���"));
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}
    
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerGuaranteeBillInfo info = FarmerGuaranteeBillFactory.getLocalInstance(ctx).getFarmerGuaranteeBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѿ���ˣ���ֹɾ����"));
		}
		if(WorkFlowUtil.checkBillInWorkflow(ctx,pk.toString())){
			throw new EASBizException(new NumericExceptionSubItem("001","��ǰ�������ڹ�����ִ�й���,����ִ�иò���"));
		}
		super._delete(ctx, pk);
	}
}