package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ConFeedPolicy extends DataBase implements IConFeedPolicy
{
    public ConFeedPolicy()
    {
        super();
        registerInterface(IConFeedPolicy.class, this);
    }
    public ConFeedPolicy(Context ctx)
    {
        super(ctx);
        registerInterface(IConFeedPolicy.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3BB25130");
    }
    private ConFeedPolicyController getController() throws BOSException
    {
        return (ConFeedPolicyController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ConFeedPolicyInfo getConFeedPolicyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getConFeedPolicyInfo(getContext(), pk);
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
    public ConFeedPolicyInfo getConFeedPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getConFeedPolicyInfo(getContext(), pk, selector);
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
    public ConFeedPolicyInfo getConFeedPolicyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getConFeedPolicyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ConFeedPolicyCollection getConFeedPolicyCollection() throws BOSException
    {
        try {
            return getController().getConFeedPolicyCollection(getContext());
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
    public ConFeedPolicyCollection getConFeedPolicyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getConFeedPolicyCollection(getContext(), view);
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
    public ConFeedPolicyCollection getConFeedPolicyCollection(String oql) throws BOSException
    {
        try {
            return getController().getConFeedPolicyCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void audit(ConFeedPolicyInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反核准-User defined method
     *@param model model
     */
    public void unAudit(ConFeedPolicyInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}