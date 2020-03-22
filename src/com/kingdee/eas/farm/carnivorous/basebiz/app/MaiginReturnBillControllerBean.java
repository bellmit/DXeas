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
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.basebiz.MaiginReturnBillFactory;
import com.kingdee.eas.farm.carnivorous.basebiz.MaiginReturnBillInfo;
import com.kingdee.eas.farm.carnivorous.basebiz.MaiginReturnBillCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.carnivorous.basebiz.MaiginReturnBillInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MaiginReturnBillControllerBean extends AbstractMaiginReturnBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.carnivorous.basebiz.app.MaiginReturnBillControllerBean");

    protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		MaiginReturnBillInfo info = (MaiginReturnBillInfo) model;

		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有提交的单子才可以执行此操作"));
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

		updateFarmerMarginForAudit(ctx, info);

		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	private void updateFarmerMarginForAudit(Context ctx, MaiginReturnBillInfo info) {
		// TODO Auto-generated method stub
		try {
			BigDecimal payAmount = info.getPayAmount()==null?BigDecimal.ZERO:info.getPayAmount();

			String op=null;
			if(info.getBizType()==com.kingdee.eas.farm.carnivorous.basebiz.bizType.returnBack){
				op="-";
			}else if(info.getBizType()==com.kingdee.eas.farm.carnivorous.basebiz.bizType.receive){
				op="+";
			}
			if(op!=null){
				String sql="update CT_FM_Farmer set cftotalMargin=isnull(cftotalMargin,0)"+op+"("+payAmount+"),cfenableMargin=isnull(cfenableMargin,0)"+op+"("+payAmount+") where fid='"+info.getFarmer().getId().toString()+"'";
				DbUtil.execute(ctx, sql);	
			}

		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		MaiginReturnBillInfo info = (MaiginReturnBillInfo) model;

		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","有下游单据的单据禁止反审核"));

		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));

		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);
		updateFarmerMarginForUnAudit(ctx, info);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	private void updateFarmerMarginForUnAudit(Context ctx, MaiginReturnBillInfo info) {
		// TODO Auto-generated method stub

		BigDecimal payAmount = info.getPayAmount()==null?BigDecimal.ZERO:info.getPayAmount();
		try {
			String op=null;
			if(info.getBizType()==com.kingdee.eas.farm.carnivorous.basebiz.bizType.returnBack){
				op="+";
			}else if(info.getBizType()==com.kingdee.eas.farm.carnivorous.basebiz.bizType.receive){
				op="-";
			}
			if(op!=null){
				String sql="update CT_FM_Farmer set cftotalMargin=isnull(cftotalMargin,0)"+op+"("+payAmount+"),cfenableMargin=isnull(cfenableMargin,0)"+op+"("+payAmount+") where fid='"+info.getFarmer().getId().toString()+"'";
				DbUtil.execute(ctx, sql);	
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MaiginReturnBillInfo info = (MaiginReturnBillInfo) model;

		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增或者保存的单子才可以执行此操作"));

		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		MaiginReturnBillInfo info = (MaiginReturnBillInfo) model;

		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增、保存或提交的单子才可以执行此操作"));

		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED); 
		}
		return super._submit(ctx, info);
	}
	
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MaiginReturnBillInfo info = MaiginReturnBillFactory.getLocalInstance(ctx).getMaiginReturnBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		if(WorkFlowUtil.checkBillInWorkflow(ctx,pk.toString())){
			throw new EASBizException(new NumericExceptionSubItem("001","当前单据尚在工作流执行过程,不能执行该操作"));
		}
		
		super._delete(ctx, pk);
	}
}