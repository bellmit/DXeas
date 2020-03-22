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

public class BabyPigEntry extends CoreBillEntryBase implements IBabyPigEntry
{
    public BabyPigEntry()
    {
        super();
        registerInterface(IBabyPigEntry.class, this);
    }
    public BabyPigEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IBabyPigEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8E936F1B");
    }
    private BabyPigEntryController getController() throws BOSException
    {
        return (BabyPigEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BabyPigEntryInfo getBabyPigEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBabyPigEntryInfo(getContext(), pk);
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
    public BabyPigEntryInfo getBabyPigEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBabyPigEntryInfo(getContext(), pk, selector);
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
    public BabyPigEntryInfo getBabyPigEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBabyPigEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BabyPigEntryCollection getBabyPigEntryCollection() throws BOSException
    {
        try {
            return getController().getBabyPigEntryCollection(getContext());
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
    public BabyPigEntryCollection getBabyPigEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBabyPigEntryCollection(getContext(), view);
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
    public BabyPigEntryCollection getBabyPigEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getBabyPigEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}