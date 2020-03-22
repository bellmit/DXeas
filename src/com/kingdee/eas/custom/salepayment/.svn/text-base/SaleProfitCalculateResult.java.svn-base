package com.kingdee.eas.custom.salepayment;

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
import com.kingdee.eas.custom.salepayment.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SaleProfitCalculateResult extends CoreBillBase implements ISaleProfitCalculateResult
{
    public SaleProfitCalculateResult()
    {
        super();
        registerInterface(ISaleProfitCalculateResult.class, this);
    }
    public SaleProfitCalculateResult(Context ctx)
    {
        super(ctx);
        registerInterface(ISaleProfitCalculateResult.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9194B9C4");
    }
    private SaleProfitCalculateResultController getController() throws BOSException
    {
        return (SaleProfitCalculateResultController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SaleProfitCalculateResultCollection getSaleProfitCalculateResultCollection() throws BOSException
    {
        try {
            return getController().getSaleProfitCalculateResultCollection(getContext());
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
    public SaleProfitCalculateResultCollection getSaleProfitCalculateResultCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSaleProfitCalculateResultCollection(getContext(), view);
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
    public SaleProfitCalculateResultCollection getSaleProfitCalculateResultCollection(String oql) throws BOSException
    {
        try {
            return getController().getSaleProfitCalculateResultCollection(getContext(), oql);
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
    public SaleProfitCalculateResultInfo getSaleProfitCalculateResultInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleProfitCalculateResultInfo(getContext(), pk);
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
    public SaleProfitCalculateResultInfo getSaleProfitCalculateResultInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleProfitCalculateResultInfo(getContext(), pk, selector);
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
    public SaleProfitCalculateResultInfo getSaleProfitCalculateResultInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleProfitCalculateResultInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}