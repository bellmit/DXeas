package com.kingdee.eas.custom.workflow;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.eas.custom.workflow.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class WSRptDataFacade extends AbstractBizCtrl implements IWSRptDataFacade
{
    public WSRptDataFacade()
    {
        super();
        registerInterface(IWSRptDataFacade.class, this);
    }
    public WSRptDataFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWSRptDataFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("296E4B7A");
    }
    private WSRptDataFacadeController getController() throws BOSException
    {
        return (WSRptDataFacadeController)getBizController();
    }
    /**
     *getProductRptDataByJson-User defined method
     *@param jsonData jsonData
     *@return
     */
    public String getProductRptDataByJson(String jsonData) throws BOSException
    {
        try {
            return getController().getProductRptDataByJson(getContext(), jsonData);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getMakerRptDataByJson-User defined method
     *@param jsonData jsonData
     *@return
     */
    public String getMakerRptDataByJson(String jsonData) throws BOSException
    {
        try {
            return getController().getMakerRptDataByJson(getContext(), jsonData);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}