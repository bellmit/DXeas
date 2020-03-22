package com.kingdee.eas.farm.stocking.processbizill;

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
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class StatementOfAccount extends CoreBillBase implements IStatementOfAccount
{
    public StatementOfAccount()
    {
        super();
        registerInterface(IStatementOfAccount.class, this);
    }
    public StatementOfAccount(Context ctx)
    {
        super(ctx);
        registerInterface(IStatementOfAccount.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6E5153CC");
    }
    private StatementOfAccountController getController() throws BOSException
    {
        return (StatementOfAccountController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public StatementOfAccountCollection getStatementOfAccountCollection() throws BOSException
    {
        try {
            return getController().getStatementOfAccountCollection(getContext());
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
    public StatementOfAccountCollection getStatementOfAccountCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getStatementOfAccountCollection(getContext(), view);
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
    public StatementOfAccountCollection getStatementOfAccountCollection(String oql) throws BOSException
    {
        try {
            return getController().getStatementOfAccountCollection(getContext(), oql);
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
    public StatementOfAccountInfo getStatementOfAccountInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getStatementOfAccountInfo(getContext(), pk);
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
    public StatementOfAccountInfo getStatementOfAccountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getStatementOfAccountInfo(getContext(), pk, selector);
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
    public StatementOfAccountInfo getStatementOfAccountInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getStatementOfAccountInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}