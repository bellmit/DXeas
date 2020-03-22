package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wages.farm.app.*;
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

public class HatchAssessEntry extends CoreBillEntryBase implements IHatchAssessEntry
{
    public HatchAssessEntry()
    {
        super();
        registerInterface(IHatchAssessEntry.class, this);
    }
    public HatchAssessEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IHatchAssessEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("71E55B38");
    }
    private HatchAssessEntryController getController() throws BOSException
    {
        return (HatchAssessEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public HatchAssessEntryInfo getHatchAssessEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchAssessEntryInfo(getContext(), pk);
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
    public HatchAssessEntryInfo getHatchAssessEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchAssessEntryInfo(getContext(), pk, selector);
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
    public HatchAssessEntryInfo getHatchAssessEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchAssessEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HatchAssessEntryCollection getHatchAssessEntryCollection() throws BOSException
    {
        try {
            return getController().getHatchAssessEntryCollection(getContext());
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
    public HatchAssessEntryCollection getHatchAssessEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHatchAssessEntryCollection(getContext(), view);
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
    public HatchAssessEntryCollection getHatchAssessEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getHatchAssessEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}