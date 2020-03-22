package com.kingdee.eas.farm.pig.breedingboar;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.pig.breedingboar.app.*;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BreedingBoarBreedModelEntry extends CoreBillEntryBase implements IBreedingBoarBreedModelEntry
{
    public BreedingBoarBreedModelEntry()
    {
        super();
        registerInterface(IBreedingBoarBreedModelEntry.class, this);
    }
    public BreedingBoarBreedModelEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedingBoarBreedModelEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("57C07635");
    }
    private BreedingBoarBreedModelEntryController getController() throws BOSException
    {
        return (BreedingBoarBreedModelEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BreedingBoarBreedModelEntryInfo getBreedingBoarBreedModelEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedingBoarBreedModelEntryInfo(getContext(), pk);
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
    public BreedingBoarBreedModelEntryInfo getBreedingBoarBreedModelEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedingBoarBreedModelEntryInfo(getContext(), pk, selector);
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
    public BreedingBoarBreedModelEntryInfo getBreedingBoarBreedModelEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedingBoarBreedModelEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BreedingBoarBreedModelEntryCollection getBreedingBoarBreedModelEntryCollection() throws BOSException
    {
        try {
            return getController().getBreedingBoarBreedModelEntryCollection(getContext());
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
    public BreedingBoarBreedModelEntryCollection getBreedingBoarBreedModelEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedingBoarBreedModelEntryCollection(getContext(), view);
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
    public BreedingBoarBreedModelEntryCollection getBreedingBoarBreedModelEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedingBoarBreedModelEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}