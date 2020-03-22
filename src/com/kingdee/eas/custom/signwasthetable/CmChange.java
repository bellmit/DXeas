package com.kingdee.eas.custom.signwasthetable;

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
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.signwasthetable.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CmChange extends CoreBillBase implements ICmChange
{
    public CmChange()
    {
        super();
        registerInterface(ICmChange.class, this);
    }
    public CmChange(Context ctx)
    {
        super(ctx);
        registerInterface(ICmChange.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D82D25C4");
    }
    private CmChangeController getController() throws BOSException
    {
        return (CmChangeController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CmChangeCollection getCmChangeCollection() throws BOSException
    {
        try {
            return getController().getCmChangeCollection(getContext());
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
    public CmChangeCollection getCmChangeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCmChangeCollection(getContext(), view);
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
    public CmChangeCollection getCmChangeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCmChangeCollection(getContext(), oql);
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
    public CmChangeInfo getCmChangeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCmChangeInfo(getContext(), pk);
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
    public CmChangeInfo getCmChangeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCmChangeInfo(getContext(), pk, selector);
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
    public CmChangeInfo getCmChangeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCmChangeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}