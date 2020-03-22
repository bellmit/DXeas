package com.kingdee.eas.farm.carnivorous.recyclebiz;

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
import com.kingdee.eas.farm.carnivorous.recyclebiz.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LiveBirdWgtBill extends CoreBillBase implements ILiveBirdWgtBill
{
    public LiveBirdWgtBill()
    {
        super();
        registerInterface(ILiveBirdWgtBill.class, this);
    }
    public LiveBirdWgtBill(Context ctx)
    {
        super(ctx);
        registerInterface(ILiveBirdWgtBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("90D40009");
    }
    private LiveBirdWgtBillController getController() throws BOSException
    {
        return (LiveBirdWgtBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LiveBirdWgtBillCollection getLiveBirdWgtBillCollection() throws BOSException
    {
        try {
            return getController().getLiveBirdWgtBillCollection(getContext());
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
    public LiveBirdWgtBillCollection getLiveBirdWgtBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLiveBirdWgtBillCollection(getContext(), view);
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
    public LiveBirdWgtBillCollection getLiveBirdWgtBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getLiveBirdWgtBillCollection(getContext(), oql);
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
    public LiveBirdWgtBillInfo getLiveBirdWgtBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLiveBirdWgtBillInfo(getContext(), pk);
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
    public LiveBirdWgtBillInfo getLiveBirdWgtBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLiveBirdWgtBillInfo(getContext(), pk, selector);
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
    public LiveBirdWgtBillInfo getLiveBirdWgtBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLiveBirdWgtBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(LiveBirdWgtBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(LiveBirdWgtBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}