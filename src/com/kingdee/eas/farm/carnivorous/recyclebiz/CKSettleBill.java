package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import java.util.Map;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CKSettleBill extends CoreBillBase implements ICKSettleBill
{
    public CKSettleBill()
    {
        super();
        registerInterface(ICKSettleBill.class, this);
    }
    public CKSettleBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICKSettleBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2A2E0777");
    }
    private CKSettleBillController getController() throws BOSException
    {
        return (CKSettleBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CKSettleBillCollection getCKSettleBillCollection() throws BOSException
    {
        try {
            return getController().getCKSettleBillCollection(getContext());
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
    public CKSettleBillCollection getCKSettleBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCKSettleBillCollection(getContext(), view);
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
    public CKSettleBillCollection getCKSettleBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCKSettleBillCollection(getContext(), oql);
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
    public CKSettleBillInfo getCKSettleBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCKSettleBillInfo(getContext(), pk);
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
    public CKSettleBillInfo getCKSettleBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCKSettleBillInfo(getContext(), pk, selector);
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
    public CKSettleBillInfo getCKSettleBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCKSettleBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CKSettleBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(CKSettleBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *关闭-User defined method
     *@param model model
     */
    public void close(CKSettleBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().close(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反关闭-User defined method
     *@param model model
     */
    public void unClose(CKSettleBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unClose(getContext(), model);
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
    public Map execSettle(CKSettleBillInfo model) throws BOSException, EASBizException
    {
        try {
            return getController().execSettle(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *更新销售信息-User defined method
     *@param model model
     */
    public void updateSaleData(CKSettleBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().updateSaleData(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *更新实际支付-User defined method
     *@param model model
     *@return
     */
    public Map updateActAmt(CKSettleBillInfo model) throws BOSException, EASBizException
    {
        try {
            return getController().updateActAmt(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *更新销售信息及利润-User defined method
     *@param model model
     */
    public void updateSale(CKSettleBillInfo model) throws BOSException
    {
        try {
            getController().updateSale(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *已付风险押金-User defined method
     *@param model model
     */
    public void hasPay(CKSettleBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().hasPay(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}