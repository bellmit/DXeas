package com.kingdee.eas.custom.eas2temp.app;

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

import java.lang.String;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.eas2temp.DataBaseSettingInfo;
import com.kingdee.eas.custom.eas2temp.DataBaseSettingCollection;
import com.kingdee.eas.custom.stockprice.IsaveRealTimeInventoryFacade;
import com.kingdee.eas.custom.stockprice.saveRealTimeInventoryFacade;
import com.kingdee.eas.custom.stockprice.saveRealTimeInventoryFacadeFactory;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;

public class DataBaseSettingControllerBean extends AbstractDataBaseSettingControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.eas2temp.app.DataBaseSettingControllerBean");

	@Override
	protected void _bakmaterial(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
		IsaveRealTimeInventoryFacade is;
		is = saveRealTimeInventoryFacadeFactory.getLocalInstance(ctx);
		is.saveRealTimeInventory();
		super._bakmaterial(ctx, model);
	}
}