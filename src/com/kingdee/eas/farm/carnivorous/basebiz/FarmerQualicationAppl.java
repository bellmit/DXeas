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

public class FarmerQualicationAppl extends CoreBillBase implements IFarmerQualicationAppl
{
    public FarmerQualicationAppl()
    {
        super();
        registerInterface(IFarmerQualicationAppl.class, this);
    }
    public FarmerQualicationAppl(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmerQualicationAppl.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A2D3105D");
    }
    private FarmerQualicationApplController getController() throws BOSException
    {
        return (FarmerQualicationApplController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FarmerQualicationApplCollection getFarmerQualicationApplCollection() throws BOSException
    {
        try {
            return getController().getFarmerQualicationApplCollection(getContext());
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
    public FarmerQualicationApplCollection getFarmerQualicationApplCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmerQualicationApplCollection(getContext(), view);
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
    public FarmerQualicationApplCollection getFarmerQualicationApplCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmerQualicationApplCollection(getContext(), oql);
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
    public FarmerQualicationApplInfo getFarmerQualicationApplInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerQualicationApplInfo(getContext(), pk);
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
    public FarmerQualicationApplInfo getFarmerQualicationApplInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerQualicationApplInfo(getContext(), pk, selector);
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
    public FarmerQualicationApplInfo getFarmerQualicationApplInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerQualicationApplInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(FarmerQualicationApplInfo model) throws BOSException, EASBizException
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
    public void unAudit(FarmerQualicationApplInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *是否模板-User defined method
     *@param model model
     */
    public void isTemplate(FarmerQualicationApplInfo model) throws BOSException
    {
        try {
            getController().isTemplate(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *评定项目修改-User defined method
     *@param model model
     */
    public void isCheckItemEntry(FarmerQualicationApplInfo model) throws BOSException
    {
        try {
            getController().isCheckItemEntry(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *查看担保申请单-User defined method
     *@param model model
     */
    public void viewGuaranteeBill(FarmerQualicationApplInfo model) throws BOSException, EASBizException
    {
        try {
            getController().viewGuaranteeBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}