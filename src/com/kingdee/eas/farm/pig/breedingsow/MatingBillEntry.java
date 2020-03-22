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

public class MatingBillEntry extends CoreBillEntryBase implements IMatingBillEntry
{
    public MatingBillEntry()
    {
        super();
        registerInterface(IMatingBillEntry.class, this);
    }
    public MatingBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IMatingBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1BA7E008");
    }
    private MatingBillEntryController getController() throws BOSException
    {
        return (MatingBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MatingBillEntryInfo getMatingBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMatingBillEntryInfo(getContext(), pk);
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
    public MatingBillEntryInfo getMatingBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMatingBillEntryInfo(getContext(), pk, selector);
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
    public MatingBillEntryInfo getMatingBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMatingBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MatingBillEntryCollection getMatingBillEntryCollection() throws BOSException
    {
        try {
            return getController().getMatingBillEntryCollection(getContext());
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
    public MatingBillEntryCollection getMatingBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMatingBillEntryCollection(getContext(), view);
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
    public MatingBillEntryCollection getMatingBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getMatingBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}