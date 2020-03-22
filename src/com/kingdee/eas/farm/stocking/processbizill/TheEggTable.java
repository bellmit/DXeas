package com.kingdee.eas.farm.stocking.processbizill;

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
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class TheEggTable extends CoreBillBase implements ITheEggTable
{
    public TheEggTable()
    {
        super();
        registerInterface(ITheEggTable.class, this);
    }
    public TheEggTable(Context ctx)
    {
        super(ctx);
        registerInterface(ITheEggTable.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("92FD45D5");
    }
    private TheEggTableController getController() throws BOSException
    {
        return (TheEggTableController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TheEggTableCollection getTheEggTableCollection() throws BOSException
    {
        try {
            return getController().getTheEggTableCollection(getContext());
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
    public TheEggTableCollection getTheEggTableCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTheEggTableCollection(getContext(), view);
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
    public TheEggTableCollection getTheEggTableCollection(String oql) throws BOSException
    {
        try {
            return getController().getTheEggTableCollection(getContext(), oql);
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
    public TheEggTableInfo getTheEggTableInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTheEggTableInfo(getContext(), pk);
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
    public TheEggTableInfo getTheEggTableInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTheEggTableInfo(getContext(), pk, selector);
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
    public TheEggTableInfo getTheEggTableInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTheEggTableInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(TheEggTableInfo model) throws BOSException, EASBizException
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
    public void unAudit(TheEggTableInfo model) throws BOSException, EASBizException
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
    public void showPriceCol(TheEggTableInfo model) throws BOSException
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
    public void viewAllBill(TheEggTableInfo model) throws BOSException
    {
        try {
            getController().viewAllBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}