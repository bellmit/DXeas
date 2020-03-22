package com.kingdee.eas.farm.carnivorous.webservice;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.commonld.IWebServiceFacade;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.commonld.WebServiceFacade;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.carnivorous.webservice.*;
import com.kingdee.bos.util.*;

public class WSStockingDailyFacade extends WebServiceFacade implements IWSStockingDailyFacade
{
    public WSStockingDailyFacade()
    {
        super();
        registerInterface(IWSStockingDailyFacade.class, this);
    }
    public WSStockingDailyFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWSStockingDailyFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("49C7CB1C");
    }
    private WSStockingDailyFacadeController getController() throws BOSException
    {
        return (WSStockingDailyFacadeController)getBizController();
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]参数[%returndesc]-User defined method
     *@param param 参数
     *@return
     */
    public String getDailyInitBillInfo(String param) throws BOSException
    {
        try {
            return getController().getDailyInitBillInfo(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}