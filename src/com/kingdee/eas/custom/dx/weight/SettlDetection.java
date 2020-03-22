package com.kingdee.eas.custom.dx.weight;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.dx.weight.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SettlDetection extends WlhlBillBase implements ISettlDetection
{
    public SettlDetection()
    {
        super();
        registerInterface(ISettlDetection.class, this);
    }
    public SettlDetection(Context ctx)
    {
        super(ctx);
        registerInterface(ISettlDetection.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("10F5932C");
    }
    private SettlDetectionController getController() throws BOSException
    {
        return (SettlDetectionController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SettlDetectionCollection getSettlDetectionCollection() throws BOSException
    {
        try {
            return getController().getSettlDetectionCollection(getContext());
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
    public SettlDetectionCollection getSettlDetectionCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSettlDetectionCollection(getContext(), view);
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
    public SettlDetectionCollection getSettlDetectionCollection(String oql) throws BOSException
    {
        try {
            return getController().getSettlDetectionCollection(getContext(), oql);
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
    public SettlDetectionInfo getSettlDetectionInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSettlDetectionInfo(getContext(), pk);
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
    public SettlDetectionInfo getSettlDetectionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSettlDetectionInfo(getContext(), pk, selector);
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
    public SettlDetectionInfo getSettlDetectionInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSettlDetectionInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}