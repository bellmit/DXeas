package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.eas.farm.pig.breedingsow.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SowReturnbackBill extends CoreBillBase implements ISowReturnbackBill
{
    public SowReturnbackBill()
    {
        super();
        registerInterface(ISowReturnbackBill.class, this);
    }
    public SowReturnbackBill(Context ctx)
    {
        super(ctx);
        registerInterface(ISowReturnbackBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DEEAAD38");
    }
    private SowReturnbackBillController getController() throws BOSException
    {
        return (SowReturnbackBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SowReturnbackBillCollection getSowReturnbackBillCollection() throws BOSException
    {
        try {
            return getController().getSowReturnbackBillCollection(getContext());
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
    public SowReturnbackBillCollection getSowReturnbackBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSowReturnbackBillCollection(getContext(), view);
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
    public SowReturnbackBillCollection getSowReturnbackBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getSowReturnbackBillCollection(getContext(), oql);
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
    public SowReturnbackBillInfo getSowReturnbackBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSowReturnbackBillInfo(getContext(), pk);
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
    public SowReturnbackBillInfo getSowReturnbackBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSowReturnbackBillInfo(getContext(), pk, selector);
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
    public SowReturnbackBillInfo getSowReturnbackBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSowReturnbackBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}