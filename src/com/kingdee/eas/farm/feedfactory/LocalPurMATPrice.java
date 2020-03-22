package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.feedfactory.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LocalPurMATPrice extends WlhlDataBase implements ILocalPurMATPrice
{
    public LocalPurMATPrice()
    {
        super();
        registerInterface(ILocalPurMATPrice.class, this);
    }
    public LocalPurMATPrice(Context ctx)
    {
        super(ctx);
        registerInterface(ILocalPurMATPrice.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E580676D");
    }
    private LocalPurMATPriceController getController() throws BOSException
    {
        return (LocalPurMATPriceController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public LocalPurMATPriceInfo getLocalPurMATPriceInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLocalPurMATPriceInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public LocalPurMATPriceInfo getLocalPurMATPriceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLocalPurMATPriceInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public LocalPurMATPriceInfo getLocalPurMATPriceInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLocalPurMATPriceInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public LocalPurMATPriceCollection getLocalPurMATPriceCollection() throws BOSException
    {
        try {
            return getController().getLocalPurMATPriceCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public LocalPurMATPriceCollection getLocalPurMATPriceCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLocalPurMATPriceCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public LocalPurMATPriceCollection getLocalPurMATPriceCollection(String oql) throws BOSException
    {
        try {
            return getController().getLocalPurMATPriceCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}