package com.kingdee.eas.weighbridge;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.Context;
import com.kingdee.eas.weighbridge.app.*;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class CommSqlFacade extends AbstractBizCtrl implements ICommSqlFacade
{
    public CommSqlFacade()
    {
        super();
        registerInterface(ICommSqlFacade.class, this);
    }
    public CommSqlFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICommSqlFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A2BC1A61");
    }
    private CommSqlFacadeController getController() throws BOSException
    {
        return (CommSqlFacadeController)getBizController();
    }
    /**
     *executeQuery-User defined method
     *@param sqlStr sqlStr
     *@return
     */
    public IRowSet executeQuery(String sqlStr) throws BOSException
    {
        try {
            return getController().executeQuery(getContext(), sqlStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *executeQuery-User defined method
     *@param sqlStr sqlStr
     *@param params params
     *@return
     */
    public IRowSet executeQuery(String sqlStr, Object[] params) throws BOSException
    {
        try {
            return getController().executeQuery(getContext(), sqlStr, params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *execute-User defined method
     *@param sqlStr sqlStr
     */
    public void execute(String sqlStr) throws BOSException
    {
        try {
            getController().execute(getContext(), sqlStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *execute-User defined method
     *@param sqlStr sqlStr
     *@param params params
     */
    public void execute(String sqlStr, Object[] params) throws BOSException
    {
        try {
            getController().execute(getContext(), sqlStr, params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}