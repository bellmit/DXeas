package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmerBorrowNew extends CoreBillBase implements IFarmerBorrowNew
{
    public FarmerBorrowNew()
    {
        super();
        registerInterface(IFarmerBorrowNew.class, this);
    }
    public FarmerBorrowNew(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmerBorrowNew.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A6258D66");
    }
    private FarmerBorrowNewController getController() throws BOSException
    {
        return (FarmerBorrowNewController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FarmerBorrowNewCollection getFarmerBorrowNewCollection() throws BOSException
    {
        try {
            return getController().getFarmerBorrowNewCollection(getContext());
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
    public FarmerBorrowNewCollection getFarmerBorrowNewCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmerBorrowNewCollection(getContext(), view);
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
    public FarmerBorrowNewCollection getFarmerBorrowNewCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmerBorrowNewCollection(getContext(), oql);
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
    public FarmerBorrowNewInfo getFarmerBorrowNewInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerBorrowNewInfo(getContext(), pk);
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
    public FarmerBorrowNewInfo getFarmerBorrowNewInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerBorrowNewInfo(getContext(), pk, selector);
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
    public FarmerBorrowNewInfo getFarmerBorrowNewInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerBorrowNewInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(FarmerBorrowNewInfo model) throws BOSException, EASBizException
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
    public void unAudit(FarmerBorrowNewInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}