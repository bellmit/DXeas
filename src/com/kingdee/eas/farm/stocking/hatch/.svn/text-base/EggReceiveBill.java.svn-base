package com.kingdee.eas.farm.stocking.hatch;

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
import com.kingdee.eas.farm.stocking.hatch.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EggReceiveBill extends CoreBillBase implements IEggReceiveBill
{
    public EggReceiveBill()
    {
        super();
        registerInterface(IEggReceiveBill.class, this);
    }
    public EggReceiveBill(Context ctx)
    {
        super(ctx);
        registerInterface(IEggReceiveBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("38D35EAF");
    }
    private EggReceiveBillController getController() throws BOSException
    {
        return (EggReceiveBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EggReceiveBillCollection getEggReceiveBillCollection() throws BOSException
    {
        try {
            return getController().getEggReceiveBillCollection(getContext());
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
    public EggReceiveBillCollection getEggReceiveBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEggReceiveBillCollection(getContext(), view);
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
    public EggReceiveBillCollection getEggReceiveBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getEggReceiveBillCollection(getContext(), oql);
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
    public EggReceiveBillInfo getEggReceiveBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEggReceiveBillInfo(getContext(), pk);
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
    public EggReceiveBillInfo getEggReceiveBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEggReceiveBillInfo(getContext(), pk, selector);
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
    public EggReceiveBillInfo getEggReceiveBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEggReceiveBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(EggReceiveBillInfo model) throws BOSException
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
    public void unAudit(EggReceiveBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *显示单价-User defined method
     *@param model model
     */
    public void showPriceCol(EggReceiveBillInfo model) throws BOSException
    {
        try {
            getController().showPriceCol(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *查看所有数据-User defined method
     *@param model model
     */
    public void viewAllBill(EggReceiveBillInfo model) throws BOSException
    {
        try {
            getController().viewAllBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *删除下游单据-User defined method
     *@param model model
     */
    public void deleteDownBill(EggReceiveBillInfo model) throws BOSException
    {
        try {
            getController().deleteDownBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *生成结算单-User defined method
     *@param model model
     */
    public void toSettleBill(EggReceiveBillInfo model) throws BOSException
    {
        try {
            getController().toSettleBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *设置颜色-User defined method
     *@param model model
     */
    public void setColor(EggReceiveBillInfo model) throws BOSException
    {
        try {
            getController().setColor(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}