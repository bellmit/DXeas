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
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class QualityCheckBillEntry extends CoreBillEntryBase implements IQualityCheckBillEntry
{
    public QualityCheckBillEntry()
    {
        super();
        registerInterface(IQualityCheckBillEntry.class, this);
    }
    public QualityCheckBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IQualityCheckBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1AC2DAC0");
    }
    private QualityCheckBillEntryController getController() throws BOSException
    {
        return (QualityCheckBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public QualityCheckBillEntryInfo getQualityCheckBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getQualityCheckBillEntryInfo(getContext(), pk);
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
    public QualityCheckBillEntryInfo getQualityCheckBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getQualityCheckBillEntryInfo(getContext(), pk, selector);
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
    public QualityCheckBillEntryInfo getQualityCheckBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getQualityCheckBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public QualityCheckBillEntryCollection getQualityCheckBillEntryCollection() throws BOSException
    {
        try {
            return getController().getQualityCheckBillEntryCollection(getContext());
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
    public QualityCheckBillEntryCollection getQualityCheckBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getQualityCheckBillEntryCollection(getContext(), view);
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
    public QualityCheckBillEntryCollection getQualityCheckBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getQualityCheckBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}