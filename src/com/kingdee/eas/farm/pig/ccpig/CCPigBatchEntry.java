package com.kingdee.eas.farm.pig.ccpig;

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
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.farm.pig.ccpig.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CCPigBatchEntry extends CoreBillEntryBase implements ICCPigBatchEntry
{
    public CCPigBatchEntry()
    {
        super();
        registerInterface(ICCPigBatchEntry.class, this);
    }
    public CCPigBatchEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICCPigBatchEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("87FDE866");
    }
    private CCPigBatchEntryController getController() throws BOSException
    {
        return (CCPigBatchEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CCPigBatchEntryInfo getCCPigBatchEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCCPigBatchEntryInfo(getContext(), pk);
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
    public CCPigBatchEntryInfo getCCPigBatchEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCCPigBatchEntryInfo(getContext(), pk, selector);
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
    public CCPigBatchEntryInfo getCCPigBatchEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCCPigBatchEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CCPigBatchEntryCollection getCCPigBatchEntryCollection() throws BOSException
    {
        try {
            return getController().getCCPigBatchEntryCollection(getContext());
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
    public CCPigBatchEntryCollection getCCPigBatchEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCCPigBatchEntryCollection(getContext(), view);
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
    public CCPigBatchEntryCollection getCCPigBatchEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCCPigBatchEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}