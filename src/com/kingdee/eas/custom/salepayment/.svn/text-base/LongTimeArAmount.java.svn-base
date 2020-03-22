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

public class LongTimeArAmount extends CoreBillBase implements ILongTimeArAmount
{
    public LongTimeArAmount()
    {
        super();
        registerInterface(ILongTimeArAmount.class, this);
    }
    public LongTimeArAmount(Context ctx)
    {
        super(ctx);
        registerInterface(ILongTimeArAmount.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4F196166");
    }
    private LongTimeArAmountController getController() throws BOSException
    {
        return (LongTimeArAmountController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LongTimeArAmountCollection getLongTimeArAmountCollection() throws BOSException
    {
        try {
            return getController().getLongTimeArAmountCollection(getContext());
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
    public LongTimeArAmountCollection getLongTimeArAmountCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLongTimeArAmountCollection(getContext(), view);
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
    public LongTimeArAmountCollection getLongTimeArAmountCollection(String oql) throws BOSException
    {
        try {
            return getController().getLongTimeArAmountCollection(getContext(), oql);
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
    public LongTimeArAmountInfo getLongTimeArAmountInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLongTimeArAmountInfo(getContext(), pk);
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
    public LongTimeArAmountInfo getLongTimeArAmountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLongTimeArAmountInfo(getContext(), pk, selector);
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
    public LongTimeArAmountInfo getLongTimeArAmountInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLongTimeArAmountInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}