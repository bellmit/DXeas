package com.kingdee.eas.farm.stocking.processbizill;

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
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class QeggAndDuckSeedEarly extends CoreBillBase implements IQeggAndDuckSeedEarly
{
    public QeggAndDuckSeedEarly()
    {
        super();
        registerInterface(IQeggAndDuckSeedEarly.class, this);
    }
    public QeggAndDuckSeedEarly(Context ctx)
    {
        super(ctx);
        registerInterface(IQeggAndDuckSeedEarly.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("63C0631B");
    }
    private QeggAndDuckSeedEarlyController getController() throws BOSException
    {
        return (QeggAndDuckSeedEarlyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public QeggAndDuckSeedEarlyCollection getQeggAndDuckSeedEarlyCollection() throws BOSException
    {
        try {
            return getController().getQeggAndDuckSeedEarlyCollection(getContext());
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
    public QeggAndDuckSeedEarlyCollection getQeggAndDuckSeedEarlyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getQeggAndDuckSeedEarlyCollection(getContext(), view);
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
    public QeggAndDuckSeedEarlyCollection getQeggAndDuckSeedEarlyCollection(String oql) throws BOSException
    {
        try {
            return getController().getQeggAndDuckSeedEarlyCollection(getContext(), oql);
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
    public QeggAndDuckSeedEarlyInfo getQeggAndDuckSeedEarlyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getQeggAndDuckSeedEarlyInfo(getContext(), pk);
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
    public QeggAndDuckSeedEarlyInfo getQeggAndDuckSeedEarlyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getQeggAndDuckSeedEarlyInfo(getContext(), pk, selector);
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
    public QeggAndDuckSeedEarlyInfo getQeggAndDuckSeedEarlyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getQeggAndDuckSeedEarlyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(QeggAndDuckSeedEarlyInfo model) throws BOSException
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
    public void unAudit(QeggAndDuckSeedEarlyInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}