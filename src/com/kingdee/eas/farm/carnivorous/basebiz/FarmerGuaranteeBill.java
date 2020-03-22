package com.kingdee.eas.farm.carnivorous.basebiz;

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
import com.kingdee.eas.farm.carnivorous.basebiz.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmerGuaranteeBill extends CoreBillBase implements IFarmerGuaranteeBill
{
    public FarmerGuaranteeBill()
    {
        super();
        registerInterface(IFarmerGuaranteeBill.class, this);
    }
    public FarmerGuaranteeBill(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmerGuaranteeBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5B16D615");
    }
    private FarmerGuaranteeBillController getController() throws BOSException
    {
        return (FarmerGuaranteeBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FarmerGuaranteeBillCollection getFarmerGuaranteeBillCollection() throws BOSException
    {
        try {
            return getController().getFarmerGuaranteeBillCollection(getContext());
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
    public FarmerGuaranteeBillCollection getFarmerGuaranteeBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmerGuaranteeBillCollection(getContext(), view);
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
    public FarmerGuaranteeBillCollection getFarmerGuaranteeBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmerGuaranteeBillCollection(getContext(), oql);
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
    public FarmerGuaranteeBillInfo getFarmerGuaranteeBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerGuaranteeBillInfo(getContext(), pk);
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
    public FarmerGuaranteeBillInfo getFarmerGuaranteeBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerGuaranteeBillInfo(getContext(), pk, selector);
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
    public FarmerGuaranteeBillInfo getFarmerGuaranteeBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerGuaranteeBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(FarmerGuaranteeBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(FarmerGuaranteeBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}