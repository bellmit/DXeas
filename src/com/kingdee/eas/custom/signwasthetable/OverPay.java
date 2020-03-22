package com.kingdee.eas.custom.signwasthetable;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.signwasthetable.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class OverPay extends CoreBillBase implements IOverPay
{
    public OverPay()
    {
        super();
        registerInterface(IOverPay.class, this);
    }
    public OverPay(Context ctx)
    {
        super(ctx);
        registerInterface(IOverPay.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("930300EA");
    }
    private OverPayController getController() throws BOSException
    {
        return (OverPayController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public OverPayCollection getOverPayCollection() throws BOSException
    {
        try {
            return getController().getOverPayCollection(getContext());
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
    public OverPayCollection getOverPayCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getOverPayCollection(getContext(), view);
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
    public OverPayCollection getOverPayCollection(String oql) throws BOSException
    {
        try {
            return getController().getOverPayCollection(getContext(), oql);
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
    public OverPayInfo getOverPayInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getOverPayInfo(getContext(), pk);
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
    public OverPayInfo getOverPayInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getOverPayInfo(getContext(), pk, selector);
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
    public OverPayInfo getOverPayInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getOverPayInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *查看原始合同-User defined method
     *@param model model
     */
    public void viewSrcBill(OverPayInfo model) throws BOSException
    {
        try {
            getController().viewSrcBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(OverPayInfo model) throws BOSException
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
    public void unAudit(OverPayInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}