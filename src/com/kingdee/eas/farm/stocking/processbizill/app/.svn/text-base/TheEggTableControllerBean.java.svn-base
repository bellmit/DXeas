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
import com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo;
import com.kingdee.eas.farm.stocking.hatch.app.StockingHatchFacadeControllerBean;
import com.kingdee.eas.farm.stocking.processbizill.TheEggTableCollection;
import com.kingdee.eas.farm.stocking.processbizill.TheEggTableFactory;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.BotpUtils;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class TheEggTableControllerBean extends AbstractTheEggTableControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.processbizill.app.TheEggTableControllerBean");
    protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException{
    	TheEggTableInfo info = (TheEggTableInfo) model;
		
    	if(!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
    		throw new EASBizException(new NumericExceptionSubItem("001","只有提交的单子才能审核"));
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

		super._save(ctx, info);
    }
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException{

    	TheEggTableInfo info = (TheEggTableInfo) model;
    	if(AppCommon.existDestBill(ctx, info.getBOSType().toString(), info.getString("id")))
    		throw new EASBizException(new NumericExceptionSubItem("001","存在下游单据的单子禁止反审核"));
    		
    	if(!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
    		throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才能反审核"));
    	
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);

		super._save(ctx, info);
    }
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		TheEggTableInfo info = (TheEggTableInfo) model;
		
    	if(info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
    		throw new EASBizException(new NumericExceptionSubItem("001","只有保存的单子才能执行该操作"));
    	
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);

		return super._save(ctx, info);
	}
	@Override
	protected void _showPriceCol(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		TheEggTableInfo info = (TheEggTableInfo) model;
    		
    	if(!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
    		throw new EASBizException(new NumericExceptionSubItem("001","只有保存或提交的单子才能执行该操作"));
    	
		info.setBillStatus(BillBaseStatusEnum.SUBMITED);

		return super._submit(ctx, info);
	}
	@Override
	protected void _viewAllBill(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
	}
	@Override
	public void delete(Context arg0, IObjectPK arg1) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		TheEggTableInfo info = TheEggTableFactory.getLocalInstance(arg0).getTheEggTableInfo(arg1);
    		
    	if(!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
    		throw new EASBizException(new NumericExceptionSubItem("001","只有新增或提交的单子才能执行该操作"));
    	

	
		super.delete(arg0, arg1);
	}
    
    
}