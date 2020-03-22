package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Appraisalclient extends DataBase implements IAppraisalclient
{
    public Appraisalclient()
    {
        super();
        registerInterface(IAppraisalclient.class, this);
    }
    public Appraisalclient(Context ctx)
    {
        super(ctx);
        registerInterface(IAppraisalclient.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BC51F9E8");
    }
    private AppraisalclientController getController() throws BOSException
    {
        return (AppraisalclientController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AppraisalclientInfo getAppraisalclientInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAppraisalclientInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@param selector 取值
     *@return
     */
    public AppraisalclientInfo getAppraisalclientInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAppraisalclientInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param oql 取值
     *@return
     */
    public AppraisalclientInfo getAppraisalclientInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAppraisalclientInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AppraisalclientCollection getAppraisalclientCollection() throws BOSException
    {
        try {
            return getController().getAppraisalclientCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param view 取集合
     *@return
     */
    public AppraisalclientCollection getAppraisalclientCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAppraisalclientCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param oql 取集合
     *@return
     */
    public AppraisalclientCollection getAppraisalclientCollection(String oql) throws BOSException
    {
        try {
            return getController().getAppraisalclientCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}