package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.signwasthetable.app.*;
import com.kingdee.bos.util.*;

public class signTableSysFacade extends AbstractBizCtrl implements IsignTableSysFacade
{
    public signTableSysFacade()
    {
        super();
        registerInterface(IsignTableSysFacade.class, this);
    }
    public signTableSysFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IsignTableSysFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E1118520");
    }
    private signTableSysFacadeController getController() throws BOSException
    {
        return (signTableSysFacadeController)getBizController();
    }
    /**
     *禁用-User defined method
     *@param id 传入的单据的ID
     */
    public void signTypeCancel(String id) throws BOSException
    {
        try {
            getController().signTypeCancel(getContext(), id);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *启用-User defined method
     *@param id 传入的单据ID
     */
    public void signTypeCancelcancel(String id) throws BOSException
    {
        try {
            getController().signTypeCancelcancel(getContext(), id);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *工程项目禁用-User defined method
     *@param id ID
     */
    public void engProjectCancel(String id) throws BOSException
    {
        try {
            getController().engProjectCancel(getContext(), id);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *工程项目启用-User defined method
     *@param id ID
     */
    public void engProjectCancelCancel(String id) throws BOSException
    {
        try {
            getController().engProjectCancelCancel(getContext(), id);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *合同类型禁用-User defined method
     *@param id ID
     */
    public void cTypeCancel(String id) throws BOSException
    {
        try {
            getController().cTypeCancel(getContext(), id);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *合同类别启用-User defined method
     *@param id ID
     */
    public void cTypeCancelCancel(String id) throws BOSException
    {
        try {
            getController().cTypeCancelCancel(getContext(), id);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}