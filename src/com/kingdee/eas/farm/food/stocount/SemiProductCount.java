package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.food.stocount.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SemiProductCount extends CoreBillBase implements ISemiProductCount
{
    public SemiProductCount()
    {
        super();
        registerInterface(ISemiProductCount.class, this);
    }
    public SemiProductCount(Context ctx)
    {
        super(ctx);
        registerInterface(ISemiProductCount.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1F4754AB");
    }
    private SemiProductCountController getController() throws BOSException
    {
        return (SemiProductCountController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SemiProductCountCollection getSemiProductCountCollection() throws BOSException
    {
        try {
            return getController().getSemiProductCountCollection(getContext());
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
    public SemiProductCountCollection getSemiProductCountCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSemiProductCountCollection(getContext(), view);
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
    public SemiProductCountCollection getSemiProductCountCollection(String oql) throws BOSException
    {
        try {
            return getController().getSemiProductCountCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SemiProductCountInfo getSemiProductCountInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSemiProductCountInfo(getContext(), pk);
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
    public SemiProductCountInfo getSemiProductCountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSemiProductCountInfo(getContext(), pk, selector);
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
    public SemiProductCountInfo getSemiProductCountInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSemiProductCountInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}