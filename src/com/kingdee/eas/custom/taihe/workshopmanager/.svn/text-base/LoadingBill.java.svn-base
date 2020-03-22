package com.kingdee.eas.custom.taihe.workshopmanager;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.taihe.workshopmanager.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LoadingBill extends WlhlBillBase implements ILoadingBill
{
    public LoadingBill()
    {
        super();
        registerInterface(ILoadingBill.class, this);
    }
    public LoadingBill(Context ctx)
    {
        super(ctx);
        registerInterface(ILoadingBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BEDBE401");
    }
    private LoadingBillController getController() throws BOSException
    {
        return (LoadingBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LoadingBillCollection getLoadingBillCollection() throws BOSException
    {
        try {
            return getController().getLoadingBillCollection(getContext());
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
    public LoadingBillCollection getLoadingBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLoadingBillCollection(getContext(), view);
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
    public LoadingBillCollection getLoadingBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getLoadingBillCollection(getContext(), oql);
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
    public LoadingBillInfo getLoadingBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLoadingBillInfo(getContext(), pk);
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
    public LoadingBillInfo getLoadingBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLoadingBillInfo(getContext(), pk, selector);
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
    public LoadingBillInfo getLoadingBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLoadingBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *移动端查看-User defined method
     *@param model model
     */
    public void mobileQuery(LoadingBillInfo model) throws BOSException
    {
        try {
            getController().mobileQuery(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *移动端新增-User defined method
     *@param model model
     */
    public void mobifyAddNew(LoadingBillInfo model) throws BOSException
    {
        try {
            getController().mobifyAddNew(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}