package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.dx.baseset.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Changepacking extends WlhlBillBase implements IChangepacking
{
    public Changepacking()
    {
        super();
        registerInterface(IChangepacking.class, this);
    }
    public Changepacking(Context ctx)
    {
        super(ctx);
        registerInterface(IChangepacking.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("35D43EAD");
    }
    private ChangepackingController getController() throws BOSException
    {
        return (ChangepackingController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ChangepackingCollection getChangepackingCollection() throws BOSException
    {
        try {
            return getController().getChangepackingCollection(getContext());
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
    public ChangepackingCollection getChangepackingCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getChangepackingCollection(getContext(), view);
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
    public ChangepackingCollection getChangepackingCollection(String oql) throws BOSException
    {
        try {
            return getController().getChangepackingCollection(getContext(), oql);
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
    public ChangepackingInfo getChangepackingInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getChangepackingInfo(getContext(), pk);
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
    public ChangepackingInfo getChangepackingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getChangepackingInfo(getContext(), pk, selector);
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
    public ChangepackingInfo getChangepackingInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getChangepackingInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取数据-User defined method
     *@param model model
     */
    public void getData(ChangepackingInfo model) throws BOSException
    {
        try {
            getController().getData(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}