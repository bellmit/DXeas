package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BorrowItemReturn extends DataBase implements IBorrowItemReturn
{
    public BorrowItemReturn()
    {
        super();
        registerInterface(IBorrowItemReturn.class, this);
    }
    public BorrowItemReturn(Context ctx)
    {
        super(ctx);
        registerInterface(IBorrowItemReturn.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("723CAF9A");
    }
    private BorrowItemReturnController getController() throws BOSException
    {
        return (BorrowItemReturnController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BorrowItemReturnInfo getBorrowItemReturnInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBorrowItemReturnInfo(getContext(), pk);
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
    public BorrowItemReturnInfo getBorrowItemReturnInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBorrowItemReturnInfo(getContext(), pk, selector);
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
    public BorrowItemReturnInfo getBorrowItemReturnInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBorrowItemReturnInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BorrowItemReturnCollection getBorrowItemReturnCollection() throws BOSException
    {
        try {
            return getController().getBorrowItemReturnCollection(getContext());
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
    public BorrowItemReturnCollection getBorrowItemReturnCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBorrowItemReturnCollection(getContext(), view);
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
    public BorrowItemReturnCollection getBorrowItemReturnCollection(String oql) throws BOSException
    {
        try {
            return getController().getBorrowItemReturnCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audtit(BorrowItemReturnInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audtit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(BorrowItemReturnInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}