package com.kingdee.eas.farm.breed.freedplan;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.breed.freedplan.app.*;
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

public class BreedFodderPlan extends CoreBillBase implements IBreedFodderPlan
{
    public BreedFodderPlan()
    {
        super();
        registerInterface(IBreedFodderPlan.class, this);
    }
    public BreedFodderPlan(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedFodderPlan.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6CE20F2C");
    }
    private BreedFodderPlanController getController() throws BOSException
    {
        return (BreedFodderPlanController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BreedFodderPlanCollection getBreedFodderPlanCollection() throws BOSException
    {
        try {
            return getController().getBreedFodderPlanCollection(getContext());
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
    public BreedFodderPlanCollection getBreedFodderPlanCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedFodderPlanCollection(getContext(), view);
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
    public BreedFodderPlanCollection getBreedFodderPlanCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedFodderPlanCollection(getContext(), oql);
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
    public BreedFodderPlanInfo getBreedFodderPlanInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedFodderPlanInfo(getContext(), pk);
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
    public BreedFodderPlanInfo getBreedFodderPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedFodderPlanInfo(getContext(), pk, selector);
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
    public BreedFodderPlanInfo getBreedFodderPlanInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedFodderPlanInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}