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

public class EggSettleBill extends CoreBillBase implements IEggSettleBill
{
    public EggSettleBill()
    {
        super();
        registerInterface(IEggSettleBill.class, this);
    }
    public EggSettleBill(Context ctx)
    {
        super(ctx);
        registerInterface(IEggSettleBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7DD0D62D");
    }
    private EggSettleBillController getController() throws BOSException
    {
        return (EggSettleBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EggSettleBillCollection getEggSettleBillCollection() throws BOSException
    {
        try {
            return getController().getEggSettleBillCollection(getContext());
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
    public EggSettleBillCollection getEggSettleBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEggSettleBillCollection(getContext(), view);
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
    public EggSettleBillCollection getEggSettleBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getEggSettleBillCollection(getContext(), oql);
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
    public EggSettleBillInfo getEggSettleBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEggSettleBillInfo(getContext(), pk);
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
    public EggSettleBillInfo getEggSettleBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEggSettleBillInfo(getContext(), pk, selector);
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
    public EggSettleBillInfo getEggSettleBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEggSettleBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(EggSettleBillInfo model) throws BOSException
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
    public void unAudit(EggSettleBillInfo model) throws BOSException
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
    public void showPriceCol(EggSettleBillInfo model) throws BOSException
    {
        try {
            getController().showPriceCol(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *执行结算-User defined method
     *@param model model
     */
    public void exeSettle(EggSettleBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().exeSettle(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *批次提交-User defined method
     *@param model model
     */
    public void batchSubmit(EggSettleBillInfo model) throws BOSException
    {
        try {
            getController().batchSubmit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}