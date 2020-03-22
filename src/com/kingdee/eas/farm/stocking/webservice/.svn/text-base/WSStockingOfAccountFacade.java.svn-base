package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.stocking.webservice.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.commonld.IWebServiceFacade;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.commonld.WebServiceFacade;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class WSStockingOfAccountFacade extends WebServiceFacade implements IWSStockingOfAccountFacade
{
    public WSStockingOfAccountFacade()
    {
        super();
        registerInterface(IWSStockingOfAccountFacade.class, this);
    }
    public WSStockingOfAccountFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWSStockingOfAccountFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("70BCA48A");
    }
    private WSStockingOfAccountFacadeController getController() throws BOSException
    {
        return (WSStockingOfAccountFacadeController)getBizController();
    }
}