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

public class StatementsBill extends CoreBillBase implements IStatementsBill
{
    public StatementsBill()
    {
        super();
        registerInterface(IStatementsBill.class, this);
    }
    public StatementsBill(Context ctx)
    {
        super(ctx);
        registerInterface(IStatementsBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("18D671B0");
    }
    private StatementsBillController getController() throws BOSException
    {
        return (StatementsBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public StatementsBillCollection getStatementsBillCollection() throws BOSException
    {
        try {
            return getController().getStatementsBillCollection(getContext());
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
    public StatementsBillCollection getStatementsBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getStatementsBillCollection(getContext(), view);
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
    public StatementsBillCollection getStatementsBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getStatementsBillCollection(getContext(), oql);
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
    public StatementsBillInfo getStatementsBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getStatementsBillInfo(getContext(), pk);
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
    public StatementsBillInfo getStatementsBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getStatementsBillInfo(getContext(), pk, selector);
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
    public StatementsBillInfo getStatementsBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getStatementsBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(StatementsBillInfo model) throws BOSException
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
    public void unAudit(StatementsBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *执行结算-User defined method
     *@param model model
     *@return
     */
    public Object btnExeCal(StatementsBillInfo model) throws BOSException, EASBizException
    {
        try {
            return getController().btnExeCal(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *全部結算-User defined method
     *@param param param
     *@return
     */
    public Object exeAllCal(Object param) throws BOSException, EASBizException
    {
        try {
            return getController().exeAllCal(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *批量提交-User defined method
     *@param model model
     */
    public void multiSubmit(StatementsBillInfo model) throws BOSException
    {
        try {
            getController().multiSubmit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *生成对账单-User defined method
     *@param model model
     */
    public void breateBill(StatementsBillInfo model) throws BOSException
    {
        try {
            getController().breateBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *育成冲回批量-User defined method
     *@param model model
     */
    public void calYC(StatementsBillInfo model) throws BOSException
    {
        try {
            getController().calYC(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *结转-User defined method
     *@param model model
     */
    public void carryover(StatementsBillInfo model) throws BOSException
    {
        try {
            getController().carryover(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}