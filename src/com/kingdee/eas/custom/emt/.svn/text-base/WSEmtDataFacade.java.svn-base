package com.kingdee.eas.custom.emt;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.emt.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class WSEmtDataFacade extends AbstractBizCtrl implements IWSEmtDataFacade
{
    public WSEmtDataFacade()
    {
        super();
        registerInterface(IWSEmtDataFacade.class, this);
    }
    public WSEmtDataFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWSEmtDataFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A34B4C6D");
    }
    private WSEmtDataFacadeController getController() throws BOSException
    {
        return (WSEmtDataFacadeController)getBizController();
    }
    /**
     *getUserFeedInfo-User defined method
     *@param lastUpdateDate lastUpdateDate
     *@return
     */
    public String getUserFeedInfo(String lastUpdateDate) throws BOSException
    {
        try {
            return getController().getUserFeedInfo(getContext(), lastUpdateDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getUserFeedBatchInfo-User defined method
     *@param lastUpdateTime lastUpdateTime
     *@return
     */
    public String getUserFeedBatchInfo(String lastUpdateTime) throws BOSException
    {
        try {
            return getController().getUserFeedBatchInfo(getContext(), lastUpdateTime);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getUserInComeInfo-User defined method
     *@param lastUpdateTime lastUpdateTime
     *@return
     */
    public String getUserInComeInfo(String lastUpdateTime) throws BOSException
    {
        try {
            return getController().getUserInComeInfo(getContext(), lastUpdateTime);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getUserPayInfo-User defined method
     *@param lastUpdateTime lastUpdateTime
     *@return
     */
    public String getUserPayInfo(String lastUpdateTime) throws BOSException
    {
        try {
            return getController().getUserPayInfo(getContext(), lastUpdateTime);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}