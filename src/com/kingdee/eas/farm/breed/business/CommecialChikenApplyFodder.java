package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.util.List;
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

public class CommecialChikenApplyFodder extends CoreBillBase implements ICommecialChikenApplyFodder
{
    public CommecialChikenApplyFodder()
    {
        super();
        registerInterface(ICommecialChikenApplyFodder.class, this);
    }
    public CommecialChikenApplyFodder(Context ctx)
    {
        super(ctx);
        registerInterface(ICommecialChikenApplyFodder.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("08A076B8");
    }
    private CommecialChikenApplyFodderController getController() throws BOSException
    {
        return (CommecialChikenApplyFodderController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CommecialChikenApplyFodderCollection getCommecialChikenApplyFodderCollection() throws BOSException
    {
        try {
            return getController().getCommecialChikenApplyFodderCollection(getContext());
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
    public CommecialChikenApplyFodderCollection getCommecialChikenApplyFodderCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCommecialChikenApplyFodderCollection(getContext(), view);
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
    public CommecialChikenApplyFodderCollection getCommecialChikenApplyFodderCollection(String oql) throws BOSException
    {
        try {
            return getController().getCommecialChikenApplyFodderCollection(getContext(), oql);
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
    public CommecialChikenApplyFodderInfo getCommecialChikenApplyFodderInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCommecialChikenApplyFodderInfo(getContext(), pk);
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
    public CommecialChikenApplyFodderInfo getCommecialChikenApplyFodderInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCommecialChikenApplyFodderInfo(getContext(), pk, selector);
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
    public CommecialChikenApplyFodderInfo getCommecialChikenApplyFodderInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCommecialChikenApplyFodderInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CommecialChikenApplyFodderInfo model) throws BOSException
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
    public void unAudit(CommecialChikenApplyFodderInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *生成下游单据-User defined method
     *@param model model
     *@return
     */
    public List genNextBill(CommecialChikenApplyFodderInfo model) throws BOSException
    {
        try {
            return getController().genNextBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}