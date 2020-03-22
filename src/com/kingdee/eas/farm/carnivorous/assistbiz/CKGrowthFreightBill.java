package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.carnivorous.assistbiz.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CKGrowthFreightBill extends DataBase implements ICKGrowthFreightBill
{
    public CKGrowthFreightBill()
    {
        super();
        registerInterface(ICKGrowthFreightBill.class, this);
    }
    public CKGrowthFreightBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICKGrowthFreightBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FA6F692C");
    }
    private CKGrowthFreightBillController getController() throws BOSException
    {
        return (CKGrowthFreightBillController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CKGrowthFreightBillInfo getCKGrowthFreightBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCKGrowthFreightBillInfo(getContext(), pk);
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
    public CKGrowthFreightBillInfo getCKGrowthFreightBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCKGrowthFreightBillInfo(getContext(), pk, selector);
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
    public CKGrowthFreightBillInfo getCKGrowthFreightBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCKGrowthFreightBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CKGrowthFreightBillCollection getCKGrowthFreightBillCollection() throws BOSException
    {
        try {
            return getController().getCKGrowthFreightBillCollection(getContext());
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
    public CKGrowthFreightBillCollection getCKGrowthFreightBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCKGrowthFreightBillCollection(getContext(), view);
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
    public CKGrowthFreightBillCollection getCKGrowthFreightBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCKGrowthFreightBillCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void audit(CKGrowthFreightBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反核准-User defined method
     *@param model model
     */
    public void unAudit(CKGrowthFreightBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}