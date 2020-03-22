package com.kingdee.eas.farm.breed.business;

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
import com.kingdee.eas.farm.breed.business.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CCBreedPlan extends CoreBillBase implements ICCBreedPlan
{
    public CCBreedPlan()
    {
        super();
        registerInterface(ICCBreedPlan.class, this);
    }
    public CCBreedPlan(Context ctx)
    {
        super(ctx);
        registerInterface(ICCBreedPlan.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("92CDCA4F");
    }
    private CCBreedPlanController getController() throws BOSException
    {
        return (CCBreedPlanController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CCBreedPlanCollection getCCBreedPlanCollection() throws BOSException
    {
        try {
            return getController().getCCBreedPlanCollection(getContext());
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
    public CCBreedPlanCollection getCCBreedPlanCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCCBreedPlanCollection(getContext(), view);
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
    public CCBreedPlanCollection getCCBreedPlanCollection(String oql) throws BOSException
    {
        try {
            return getController().getCCBreedPlanCollection(getContext(), oql);
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
    public CCBreedPlanInfo getCCBreedPlanInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCCBreedPlanInfo(getContext(), pk);
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
    public CCBreedPlanInfo getCCBreedPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCCBreedPlanInfo(getContext(), pk, selector);
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
    public CCBreedPlanInfo getCCBreedPlanInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCCBreedPlanInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CCBreedPlanInfo model) throws BOSException
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
    public void unAudit(CCBreedPlanInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取入栏计划-User defined method
     *@param model model
     */
    public void getCCBreedPlan(CCBreedPlanInfo model) throws BOSException
    {
        try {
            getController().getCCBreedPlan(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}