package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.foodtrac.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ThirdpartycheckEntry extends CoreBillEntryBase implements IThirdpartycheckEntry
{
    public ThirdpartycheckEntry()
    {
        super();
        registerInterface(IThirdpartycheckEntry.class, this);
    }
    public ThirdpartycheckEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IThirdpartycheckEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C8A607AE");
    }
    private ThirdpartycheckEntryController getController() throws BOSException
    {
        return (ThirdpartycheckEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ThirdpartycheckEntryInfo getThirdpartycheckEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getThirdpartycheckEntryInfo(getContext(), pk);
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
    public ThirdpartycheckEntryInfo getThirdpartycheckEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getThirdpartycheckEntryInfo(getContext(), pk, selector);
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
    public ThirdpartycheckEntryInfo getThirdpartycheckEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getThirdpartycheckEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ThirdpartycheckEntryCollection getThirdpartycheckEntryCollection() throws BOSException
    {
        try {
            return getController().getThirdpartycheckEntryCollection(getContext());
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
    public ThirdpartycheckEntryCollection getThirdpartycheckEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getThirdpartycheckEntryCollection(getContext(), view);
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
    public ThirdpartycheckEntryCollection getThirdpartycheckEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getThirdpartycheckEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}