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
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class WSStockingBreedDailyFacade extends WebServiceFacade implements IWSStockingBreedDailyFacade
{
    public WSStockingBreedDailyFacade()
    {
        super();
        registerInterface(IWSStockingBreedDailyFacade.class, this);
    }
    public WSStockingBreedDailyFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWSStockingBreedDailyFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2FC9E545");
    }
    private WSStockingBreedDailyFacadeController getController() throws BOSException
    {
        return (WSStockingBreedDailyFacadeController)getBizController();
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