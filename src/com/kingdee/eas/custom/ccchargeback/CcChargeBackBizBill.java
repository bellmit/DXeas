package com.kingdee.eas.custom.ccchargeback;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.eas.custom.ccchargeback.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CcChargeBackBizBill extends CoreBillBase implements ICcChargeBackBizBill
{
    public CcChargeBackBizBill()
    {
        super();
        registerInterface(ICcChargeBackBizBill.class, this);
    }
    public CcChargeBackBizBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICcChargeBackBizBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("42A0B697");
    }
    private CcChargeBackBizBillController getController() throws BOSException
    {
        return (CcChargeBackBizBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CcChargeBackBizBillCollection getCcChargeBackBizBillCollection() throws BOSException
    {
        try {
            return getController().getCcChargeBackBizBillCollection(getContext());
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
    public CcChargeBackBizBillCollection getCcChargeBackBizBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCcChargeBackBizBillCollection(getContext(), view);
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
    public CcChargeBackBizBillCollection getCcChargeBackBizBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCcChargeBackBizBillCollection(getContext(), oql);
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
    public CcChargeBackBizBillInfo getCcChargeBackBizBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCcChargeBackBizBillInfo(getContext(), pk);
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
    public CcChargeBackBizBillInfo getCcChargeBackBizBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCcChargeBackBizBillInfo(getContext(), pk, selector);
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
    public CcChargeBackBizBillInfo getCcChargeBackBizBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCcChargeBackBizBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CcChargeBackBizBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(CcChargeBackBizBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}