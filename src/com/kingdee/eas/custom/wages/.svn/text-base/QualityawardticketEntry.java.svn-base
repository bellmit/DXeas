package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class QualityawardticketEntry extends CoreBillEntryBase implements IQualityawardticketEntry
{
    public QualityawardticketEntry()
    {
        super();
        registerInterface(IQualityawardticketEntry.class, this);
    }
    public QualityawardticketEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IQualityawardticketEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5E728C40");
    }
    private QualityawardticketEntryController getController() throws BOSException
    {
        return (QualityawardticketEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public QualityawardticketEntryInfo getQualityawardticketEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getQualityawardticketEntryInfo(getContext(), pk);
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
    public QualityawardticketEntryInfo getQualityawardticketEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getQualityawardticketEntryInfo(getContext(), pk, selector);
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
    public QualityawardticketEntryInfo getQualityawardticketEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getQualityawardticketEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public QualityawardticketEntryCollection getQualityawardticketEntryCollection() throws BOSException
    {
        try {
            return getController().getQualityawardticketEntryCollection(getContext());
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
    public QualityawardticketEntryCollection getQualityawardticketEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getQualityawardticketEntryCollection(getContext(), view);
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
    public QualityawardticketEntryCollection getQualityawardticketEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getQualityawardticketEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}