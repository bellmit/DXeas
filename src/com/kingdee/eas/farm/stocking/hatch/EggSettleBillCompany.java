package com.kingdee.eas.farm.stocking.hatch;

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
import com.kingdee.eas.farm.stocking.hatch.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EggSettleBillCompany extends CoreBillBase implements IEggSettleBillCompany
{
    public EggSettleBillCompany()
    {
        super();
        registerInterface(IEggSettleBillCompany.class, this);
    }
    public EggSettleBillCompany(Context ctx)
    {
        super(ctx);
        registerInterface(IEggSettleBillCompany.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("72272190");
    }
    private EggSettleBillCompanyController getController() throws BOSException
    {
        return (EggSettleBillCompanyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EggSettleBillCompanyCollection getEggSettleBillCompanyCollection() throws BOSException
    {
        try {
            return getController().getEggSettleBillCompanyCollection(getContext());
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
    public EggSettleBillCompanyCollection getEggSettleBillCompanyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEggSettleBillCompanyCollection(getContext(), view);
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
    public EggSettleBillCompanyCollection getEggSettleBillCompanyCollection(String oql) throws BOSException
    {
        try {
            return getController().getEggSettleBillCompanyCollection(getContext(), oql);
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
    public EggSettleBillCompanyInfo getEggSettleBillCompanyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEggSettleBillCompanyInfo(getContext(), pk);
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
    public EggSettleBillCompanyInfo getEggSettleBillCompanyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEggSettleBillCompanyInfo(getContext(), pk, selector);
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
    public EggSettleBillCompanyInfo getEggSettleBillCompanyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEggSettleBillCompanyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(EggSettleBillCompanyInfo model) throws BOSException
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
    public void unAudit(EggSettleBillCompanyInfo model) throws BOSException
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
    public void showPriceCol(EggSettleBillCompanyInfo model) throws BOSException
    {
        try {
            getController().showPriceCol(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *执行结算-User defined method
     *@param model model
     */
    public void exeSettle(EggSettleBillCompanyInfo model) throws BOSException, EASBizException
    {
        try {
            getController().exeSettle(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}