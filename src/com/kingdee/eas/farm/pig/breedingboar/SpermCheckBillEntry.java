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

public class SpermCheckBillEntry extends CoreBillEntryBase implements ISpermCheckBillEntry
{
    public SpermCheckBillEntry()
    {
        super();
        registerInterface(ISpermCheckBillEntry.class, this);
    }
    public SpermCheckBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISpermCheckBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8B52AA0A");
    }
    private SpermCheckBillEntryController getController() throws BOSException
    {
        return (SpermCheckBillEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public SpermCheckBillEntryInfo getSpermCheckBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSpermCheckBillEntryInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public SpermCheckBillEntryInfo getSpermCheckBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSpermCheckBillEntryInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public SpermCheckBillEntryInfo getSpermCheckBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSpermCheckBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public SpermCheckBillEntryCollection getSpermCheckBillEntryCollection() throws BOSException
    {
        try {
            return getController().getSpermCheckBillEntryCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public SpermCheckBillEntryCollection getSpermCheckBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSpermCheckBillEntryCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public SpermCheckBillEntryCollection getSpermCheckBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSpermCheckBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}