package com.kingdee.eas.farm.breed.business;

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
import com.kingdee.eas.farm.breed.business.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CCLeaveBill extends CoreBillBase implements ICCLeaveBill
{
    public CCLeaveBill()
    {
        super();
        registerInterface(ICCLeaveBill.class, this);
    }
    public CCLeaveBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICCLeaveBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("607BFEF0");
    }
    private CCLeaveBillController getController() throws BOSException
    {
        return (CCLeaveBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CCLeaveBillCollection getCCLeaveBillCollection() throws BOSException
    {
        try {
            return getController().getCCLeaveBillCollection(getContext());
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
    public CCLeaveBillCollection getCCLeaveBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCCLeaveBillCollection(getContext(), view);
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
    public CCLeaveBillCollection getCCLeaveBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCCLeaveBillCollection(getContext(), oql);
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
    public CCLeaveBillInfo getCCLeaveBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCCLeaveBillInfo(getContext(), pk);
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
    public CCLeaveBillInfo getCCLeaveBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCCLeaveBillInfo(getContext(), pk, selector);
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
    public CCLeaveBillInfo getCCLeaveBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCCLeaveBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CCLeaveBillInfo model) throws BOSException
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
    public void unAudit(CCLeaveBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}