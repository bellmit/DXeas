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

public class CollectSpermBIllEntry extends CoreBillEntryBase implements ICollectSpermBIllEntry
{
    public CollectSpermBIllEntry()
    {
        super();
        registerInterface(ICollectSpermBIllEntry.class, this);
    }
    public CollectSpermBIllEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICollectSpermBIllEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("828CADB6");
    }
    private CollectSpermBIllEntryController getController() throws BOSException
    {
        return (CollectSpermBIllEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public CollectSpermBIllEntryInfo getCollectSpermBIllEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCollectSpermBIllEntryInfo(getContext(), pk);
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
    public CollectSpermBIllEntryInfo getCollectSpermBIllEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCollectSpermBIllEntryInfo(getContext(), pk, selector);
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
    public CollectSpermBIllEntryInfo getCollectSpermBIllEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCollectSpermBIllEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public CollectSpermBIllEntryCollection getCollectSpermBIllEntryCollection() throws BOSException
    {
        try {
            return getController().getCollectSpermBIllEntryCollection(getContext());
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
    public CollectSpermBIllEntryCollection getCollectSpermBIllEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCollectSpermBIllEntryCollection(getContext(), view);
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
    public CollectSpermBIllEntryCollection getCollectSpermBIllEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCollectSpermBIllEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}