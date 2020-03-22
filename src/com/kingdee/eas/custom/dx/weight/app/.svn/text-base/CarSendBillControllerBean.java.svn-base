package com.kingdee.eas.custom.dx.weight.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import com.kingdee.bos.*;
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

import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.custom.dx.weight.CarSendBillCollection;
import com.kingdee.eas.custom.dx.weight.CarSendBillFactory;
import com.kingdee.eas.custom.dx.weight.CarSendBillInfo;
import java.lang.String;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlBillBaseControllerBean;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CarSendBillControllerBean extends AbstractCarSendBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.dx.weight.app.CarSendBillControllerBean");
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CarSendBillInfo carInfo = (CarSendBillInfo)model;
		if(carInfo.getCarNum()==null){
			throw new EASBizException(new NumericExceptionSubItem("001","车牌号不能为空"));
		}
		
		return super._submit(ctx, model);
		
		
	}
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		super._audit(ctx, model);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		CarSendBillInfo carInfo = CarSendBillFactory.getLocalInstance(ctx).getCarSendBillInfo(pk);
		IObjectPK pks = LogUtil.beginLog(ctx, "_delete", carInfo.getBOSType(), pk, "删除派车单："+carInfo.getNumber());
		super._delete(ctx, pk);
		LogUtil.afterLog(ctx, pks);
	}
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super._unAudit(ctx, model);
	}
    
}