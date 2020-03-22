package com.kingdee.eas.custom.szcount;

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
import com.kingdee.eas.custom.szcount.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PackingConversion extends WlhlDataBase implements IPackingConversion
{
    public PackingConversion()
    {
        super();
        registerInterface(IPackingConversion.class, this);
    }
    public PackingConversion(Context ctx)
    {
        super(ctx);
        registerInterface(IPackingConversion.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2640A314");
    }
    private PackingConversionController getController() throws BOSException
    {
        return (PackingConversionController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PackingConversionInfo getPackingConversionInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPackingConversionInfo(getContext(), pk);
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
    public PackingConversionInfo getPackingConversionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPackingConversionInfo(getContext(), pk, selector);
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
    public PackingConversionInfo getPackingConversionInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPackingConversionInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PackingConversionCollection getPackingConversionCollection() throws BOSException
    {
        try {
            return getController().getPackingConversionCollection(getContext());
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
    public PackingConversionCollection getPackingConversionCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPackingConversionCollection(getContext(), view);
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
    public PackingConversionCollection getPackingConversionCollection(String oql) throws BOSException
    {
        try {
            return getController().getPackingConversionCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}