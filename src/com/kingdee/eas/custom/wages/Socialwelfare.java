package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Socialwelfare extends CoreBillBase implements ISocialwelfare
{
    public Socialwelfare()
    {
        super();
        registerInterface(ISocialwelfare.class, this);
    }
    public Socialwelfare(Context ctx)
    {
        super(ctx);
        registerInterface(ISocialwelfare.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0C265977");
    }
    private SocialwelfareController getController() throws BOSException
    {
        return (SocialwelfareController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SocialwelfareCollection getSocialwelfareCollection() throws BOSException
    {
        try {
            return getController().getSocialwelfareCollection(getContext());
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
    public SocialwelfareCollection getSocialwelfareCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSocialwelfareCollection(getContext(), view);
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
    public SocialwelfareCollection getSocialwelfareCollection(String oql) throws BOSException
    {
        try {
            return getController().getSocialwelfareCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SocialwelfareInfo getSocialwelfareInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSocialwelfareInfo(getContext(), pk);
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
    public SocialwelfareInfo getSocialwelfareInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSocialwelfareInfo(getContext(), pk, selector);
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
    public SocialwelfareInfo getSocialwelfareInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSocialwelfareInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(SocialwelfareInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unaudit(SocialwelfareInfo model) throws BOSException
    {
        try {
            getController().unaudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}