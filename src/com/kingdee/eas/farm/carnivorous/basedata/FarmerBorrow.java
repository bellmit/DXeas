package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmerBorrow extends DataBase implements IFarmerBorrow
{
    public FarmerBorrow()
    {
        super();
        registerInterface(IFarmerBorrow.class, this);
    }
    public FarmerBorrow(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmerBorrow.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F47D9DDA");
    }
    private FarmerBorrowController getController() throws BOSException
    {
        return (FarmerBorrowController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FarmerBorrowInfo getFarmerBorrowInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerBorrowInfo(getContext(), pk);
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
    public FarmerBorrowInfo getFarmerBorrowInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerBorrowInfo(getContext(), pk, selector);
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
    public FarmerBorrowInfo getFarmerBorrowInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerBorrowInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FarmerBorrowCollection getFarmerBorrowCollection() throws BOSException
    {
        try {
            return getController().getFarmerBorrowCollection(getContext());
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
    public FarmerBorrowCollection getFarmerBorrowCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmerBorrowCollection(getContext(), view);
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
    public FarmerBorrowCollection getFarmerBorrowCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmerBorrowCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(FarmerBorrowInfo model) throws BOSException, EASBizException
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
    public void unAudit(FarmerBorrowInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *生成凭证-User defined method
     *@param model model
     */
    public void voucher(FarmerBorrowInfo model) throws BOSException
    {
        try {
            getController().voucher(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}