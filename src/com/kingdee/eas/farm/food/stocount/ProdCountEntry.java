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

public class ProdCountEntry extends CoreBillEntryBase implements IProdCountEntry
{
    public ProdCountEntry()
    {
        super();
        registerInterface(IProdCountEntry.class, this);
    }
    public ProdCountEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IProdCountEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("701F3757");
    }
    private ProdCountEntryController getController() throws BOSException
    {
        return (ProdCountEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ProdCountEntryInfo getProdCountEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProdCountEntryInfo(getContext(), pk);
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
    public ProdCountEntryInfo getProdCountEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProdCountEntryInfo(getContext(), pk, selector);
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
    public ProdCountEntryInfo getProdCountEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProdCountEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProdCountEntryCollection getProdCountEntryCollection() throws BOSException
    {
        try {
            return getController().getProdCountEntryCollection(getContext());
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
    public ProdCountEntryCollection getProdCountEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProdCountEntryCollection(getContext(), view);
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
    public ProdCountEntryCollection getProdCountEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getProdCountEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}