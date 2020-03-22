package com.kingdee.eas.farm.breed;

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
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PlatFormPermission extends CoreBillBase implements IPlatFormPermission
{
    public PlatFormPermission()
    {
        super();
        registerInterface(IPlatFormPermission.class, this);
    }
    public PlatFormPermission(Context ctx)
    {
        super(ctx);
        registerInterface(IPlatFormPermission.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("427A399C");
    }
    private PlatFormPermissionController getController() throws BOSException
    {
        return (PlatFormPermissionController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PlatFormPermissionCollection getPlatFormPermissionCollection() throws BOSException
    {
        try {
            return getController().getPlatFormPermissionCollection(getContext());
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
    public PlatFormPermissionCollection getPlatFormPermissionCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPlatFormPermissionCollection(getContext(), view);
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
    public PlatFormPermissionCollection getPlatFormPermissionCollection(String oql) throws BOSException
    {
        try {
            return getController().getPlatFormPermissionCollection(getContext(), oql);
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
    public PlatFormPermissionInfo getPlatFormPermissionInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPlatFormPermissionInfo(getContext(), pk);
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
    public PlatFormPermissionInfo getPlatFormPermissionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPlatFormPermissionInfo(getContext(), pk, selector);
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
    public PlatFormPermissionInfo getPlatFormPermissionInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPlatFormPermissionInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *产蛋场权限-User defined method
     *@param model model
     */
    public void layEggPlanPer(PlatFormPermissionInfo model) throws BOSException
    {
        try {
            getController().layEggPlanPer(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *孵化场权限-User defined method
     *@param model model
     */
    public void hatchPlanPer(PlatFormPermissionInfo model) throws BOSException
    {
        try {
            getController().hatchPlanPer(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *商品鸡场权限-User defined method
     *@param model model
     */
    public void cCBreedPlanPer(PlatFormPermissionInfo model) throws BOSException
    {
        try {
            getController().cCBreedPlanPer(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *食品厂权限-User defined method
     *@param model model
     */
    public void slaughterPlanPer(PlatFormPermissionInfo model) throws BOSException
    {
        try {
            getController().slaughterPlanPer(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}