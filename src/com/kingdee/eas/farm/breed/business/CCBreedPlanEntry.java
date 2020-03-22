package com.kingdee.eas.farm.breed.business;

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
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.eas.farm.breed.business.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CCBreedPlanEntry extends CoreBillEntryBase implements ICCBreedPlanEntry
{
    public CCBreedPlanEntry()
    {
        super();
        registerInterface(ICCBreedPlanEntry.class, this);
    }
    public CCBreedPlanEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICCBreedPlanEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("630F6763");
    }
    private CCBreedPlanEntryController getController() throws BOSException
    {
        return (CCBreedPlanEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CCBreedPlanEntryInfo getCCBreedPlanEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCCBreedPlanEntryInfo(getContext(), pk);
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
    public CCBreedPlanEntryInfo getCCBreedPlanEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCCBreedPlanEntryInfo(getContext(), pk, selector);
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
    public CCBreedPlanEntryInfo getCCBreedPlanEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCCBreedPlanEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CCBreedPlanEntryCollection getCCBreedPlanEntryCollection() throws BOSException
    {
        try {
            return getController().getCCBreedPlanEntryCollection(getContext());
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
    public CCBreedPlanEntryCollection getCCBreedPlanEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCCBreedPlanEntryCollection(getContext(), view);
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
    public CCBreedPlanEntryCollection getCCBreedPlanEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCCBreedPlanEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}