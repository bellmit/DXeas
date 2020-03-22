package com.kingdee.eas.custom.salepayment;

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
import com.kingdee.eas.custom.salepayment.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LongTimeArAmountEntry extends CoreBillEntryBase implements ILongTimeArAmountEntry
{
    public LongTimeArAmountEntry()
    {
        super();
        registerInterface(ILongTimeArAmountEntry.class, this);
    }
    public LongTimeArAmountEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ILongTimeArAmountEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("70A9A6AC");
    }
    private LongTimeArAmountEntryController getController() throws BOSException
    {
        return (LongTimeArAmountEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public LongTimeArAmountEntryInfo getLongTimeArAmountEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLongTimeArAmountEntryInfo(getContext(), pk);
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
    public LongTimeArAmountEntryInfo getLongTimeArAmountEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLongTimeArAmountEntryInfo(getContext(), pk, selector);
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
    public LongTimeArAmountEntryInfo getLongTimeArAmountEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLongTimeArAmountEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LongTimeArAmountEntryCollection getLongTimeArAmountEntryCollection() throws BOSException
    {
        try {
            return getController().getLongTimeArAmountEntryCollection(getContext());
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
    public LongTimeArAmountEntryCollection getLongTimeArAmountEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLongTimeArAmountEntryCollection(getContext(), view);
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
    public LongTimeArAmountEntryCollection getLongTimeArAmountEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getLongTimeArAmountEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}