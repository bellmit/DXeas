package com.kingdee.eas.custom.stockprice;

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
import com.kingdee.eas.custom.stockprice.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BasePriceOfOtherCompany extends CoreBillBase implements IBasePriceOfOtherCompany
{
    public BasePriceOfOtherCompany()
    {
        super();
        registerInterface(IBasePriceOfOtherCompany.class, this);
    }
    public BasePriceOfOtherCompany(Context ctx)
    {
        super(ctx);
        registerInterface(IBasePriceOfOtherCompany.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2AA4536C");
    }
    private BasePriceOfOtherCompanyController getController() throws BOSException
    {
        return (BasePriceOfOtherCompanyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BasePriceOfOtherCompanyCollection getBasePriceOfOtherCompanyCollection() throws BOSException
    {
        try {
            return getController().getBasePriceOfOtherCompanyCollection(getContext());
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
    public BasePriceOfOtherCompanyCollection getBasePriceOfOtherCompanyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBasePriceOfOtherCompanyCollection(getContext(), view);
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
    public BasePriceOfOtherCompanyCollection getBasePriceOfOtherCompanyCollection(String oql) throws BOSException
    {
        try {
            return getController().getBasePriceOfOtherCompanyCollection(getContext(), oql);
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
    public BasePriceOfOtherCompanyInfo getBasePriceOfOtherCompanyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBasePriceOfOtherCompanyInfo(getContext(), pk);
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
    public BasePriceOfOtherCompanyInfo getBasePriceOfOtherCompanyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBasePriceOfOtherCompanyInfo(getContext(), pk, selector);
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
    public BasePriceOfOtherCompanyInfo getBasePriceOfOtherCompanyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBasePriceOfOtherCompanyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取所有物料-User defined method
     *@param model model
     */
    public void getAllMaterial(BasePriceOfOtherCompanyInfo model) throws BOSException
    {
        try {
            getController().getAllMaterial(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *导入分录-User defined method
     *@param model model
     */
    public void impExcel(BasePriceOfOtherCompanyInfo model) throws BOSException
    {
        try {
            getController().impExcel(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *模板导出-User defined method
     *@param model model
     */
    public void expModel(BasePriceOfOtherCompanyInfo model) throws BOSException
    {
        try {
            getController().expModel(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(BasePriceOfOtherCompanyInfo model) throws BOSException, EASBizException
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
    public void unAudit(BasePriceOfOtherCompanyInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}