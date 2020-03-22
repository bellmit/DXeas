package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.pig.breedingsow.app.*;
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

public class CheckHeatBillEntry extends CoreBillEntryBase implements ICheckHeatBillEntry
{
    public CheckHeatBillEntry()
    {
        super();
        registerInterface(ICheckHeatBillEntry.class, this);
    }
    public CheckHeatBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICheckHeatBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D8896854");
    }
    private CheckHeatBillEntryController getController() throws BOSException
    {
        return (CheckHeatBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CheckHeatBillEntryInfo getCheckHeatBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckHeatBillEntryInfo(getContext(), pk);
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
    public CheckHeatBillEntryInfo getCheckHeatBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckHeatBillEntryInfo(getContext(), pk, selector);
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
    public CheckHeatBillEntryInfo getCheckHeatBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckHeatBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CheckHeatBillEntryCollection getCheckHeatBillEntryCollection() throws BOSException
    {
        try {
            return getController().getCheckHeatBillEntryCollection(getContext());
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
    public CheckHeatBillEntryCollection getCheckHeatBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCheckHeatBillEntryCollection(getContext(), view);
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
    public CheckHeatBillEntryCollection getCheckHeatBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCheckHeatBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}