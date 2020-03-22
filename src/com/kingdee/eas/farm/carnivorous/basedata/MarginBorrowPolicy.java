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

public class MarginBorrowPolicy extends DataBase implements IMarginBorrowPolicy
{
    public MarginBorrowPolicy()
    {
        super();
        registerInterface(IMarginBorrowPolicy.class, this);
    }
    public MarginBorrowPolicy(Context ctx)
    {
        super(ctx);
        registerInterface(IMarginBorrowPolicy.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C238A177");
    }
    private MarginBorrowPolicyController getController() throws BOSException
    {
        return (MarginBorrowPolicyController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MarginBorrowPolicyInfo getMarginBorrowPolicyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginBorrowPolicyInfo(getContext(), pk);
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
    public MarginBorrowPolicyInfo getMarginBorrowPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginBorrowPolicyInfo(getContext(), pk, selector);
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
    public MarginBorrowPolicyInfo getMarginBorrowPolicyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginBorrowPolicyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MarginBorrowPolicyCollection getMarginBorrowPolicyCollection() throws BOSException
    {
        try {
            return getController().getMarginBorrowPolicyCollection(getContext());
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
    public MarginBorrowPolicyCollection getMarginBorrowPolicyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMarginBorrowPolicyCollection(getContext(), view);
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
    public MarginBorrowPolicyCollection getMarginBorrowPolicyCollection(String oql) throws BOSException
    {
        try {
            return getController().getMarginBorrowPolicyCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(MarginBorrowPolicyInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(MarginBorrowPolicyInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}