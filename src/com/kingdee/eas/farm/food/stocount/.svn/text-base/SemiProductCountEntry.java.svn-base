package com.kingdee.eas.farm.food.stocount;

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
import com.kingdee.eas.farm.food.stocount.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SemiProductCountEntry extends CoreBillEntryBase implements ISemiProductCountEntry
{
    public SemiProductCountEntry()
    {
        super();
        registerInterface(ISemiProductCountEntry.class, this);
    }
    public SemiProductCountEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISemiProductCountEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D3F9F687");
    }
    private SemiProductCountEntryController getController() throws BOSException
    {
        return (SemiProductCountEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SemiProductCountEntryInfo getSemiProductCountEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSemiProductCountEntryInfo(getContext(), pk);
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
    public SemiProductCountEntryInfo getSemiProductCountEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSemiProductCountEntryInfo(getContext(), pk, selector);
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
    public SemiProductCountEntryInfo getSemiProductCountEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSemiProductCountEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SemiProductCountEntryCollection getSemiProductCountEntryCollection() throws BOSException
    {
        try {
            return getController().getSemiProductCountEntryCollection(getContext());
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
    public SemiProductCountEntryCollection getSemiProductCountEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSemiProductCountEntryCollection(getContext(), view);
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
    public SemiProductCountEntryCollection getSemiProductCountEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSemiProductCountEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}