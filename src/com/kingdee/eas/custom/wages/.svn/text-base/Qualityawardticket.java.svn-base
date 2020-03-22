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

public class Qualityawardticket extends CoreBillBase implements IQualityawardticket
{
    public Qualityawardticket()
    {
        super();
        registerInterface(IQualityawardticket.class, this);
    }
    public Qualityawardticket(Context ctx)
    {
        super(ctx);
        registerInterface(IQualityawardticket.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E4D44F52");
    }
    private QualityawardticketController getController() throws BOSException
    {
        return (QualityawardticketController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public QualityawardticketCollection getQualityawardticketCollection() throws BOSException
    {
        try {
            return getController().getQualityawardticketCollection(getContext());
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
    public QualityawardticketCollection getQualityawardticketCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getQualityawardticketCollection(getContext(), view);
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
    public QualityawardticketCollection getQualityawardticketCollection(String oql) throws BOSException
    {
        try {
            return getController().getQualityawardticketCollection(getContext(), oql);
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
    public QualityawardticketInfo getQualityawardticketInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getQualityawardticketInfo(getContext(), pk);
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
    public QualityawardticketInfo getQualityawardticketInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getQualityawardticketInfo(getContext(), pk, selector);
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
    public QualityawardticketInfo getQualityawardticketInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getQualityawardticketInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(QualityawardticketInfo model) throws BOSException
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
    public void unaudit(QualityawardticketInfo model) throws BOSException
    {
        try {
            getController().unaudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}