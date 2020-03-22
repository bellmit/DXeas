package com.kingdee.eas.farm.stocking.webservice;

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

import com.kingdee.eas.custom.commonld.app.WebServiceFacadeControllerBean;

public class WSStockingOfAccountFacadeControllerBean extends AbstractWSStockingOfAccountFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.webservice.WSStockingOfAccountFacadeControllerBean");

	@Override
	protected String _getBillDetailInfo(Context ctx, String param) {
		// TODO Auto-generated method stub
		slorList = new String[]{"*","fIUnit.*","periods.*","farmer.*","handler.*","auditor.*","creator.*","LastUpdateUser.*","ControlUnit.*","cu.*","feedsNew.*","feedsNew.feedsone.*"};
		return super._getBillDetailInfo(ctx, param);
	}

}