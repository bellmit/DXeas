package com.kingdee.eas.custom.dx.weight;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.dx.weight.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class StapleSupplier extends WlhlDataBase implements IStapleSupplier
{
    public StapleSupplier()
    {
        super();
        registerInterface(IStapleSupplier.class, this);
    }
    public StapleSupplier(Context ctx)
    {
        super(ctx);
        registerInterface(IStapleSupplier.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3C3D2296");
    }
    private StapleSupplierController getController() throws BOSException
    {
        return (StapleSupplierController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public StapleSupplierInfo getStapleSupplierInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getStapleSupplierInfo(getContext(), pk);
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
    public StapleSupplierInfo getStapleSupplierInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getStapleSupplierInfo(getContext(), pk, selector);
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
    public StapleSupplierInfo getStapleSupplierInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getStapleSupplierInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public StapleSupplierCollection getStapleSupplierCollection() throws BOSException
    {
        try {
            return getController().getStapleSupplierCollection(getContext());
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
    public StapleSupplierCollection getStapleSupplierCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getStapleSupplierCollection(getContext(), view);
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
    public StapleSupplierCollection getStapleSupplierCollection(String oql) throws BOSException
    {
        try {
            return getController().getStapleSupplierCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}