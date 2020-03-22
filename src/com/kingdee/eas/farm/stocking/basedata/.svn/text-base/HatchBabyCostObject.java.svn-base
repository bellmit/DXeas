package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.stocking.basedata.app.*;
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

public class HatchBabyCostObject extends DataBase implements IHatchBabyCostObject
{
    public HatchBabyCostObject()
    {
        super();
        registerInterface(IHatchBabyCostObject.class, this);
    }
    public HatchBabyCostObject(Context ctx)
    {
        super(ctx);
        registerInterface(IHatchBabyCostObject.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3D507851");
    }
    private HatchBabyCostObjectController getController() throws BOSException
    {
        return (HatchBabyCostObjectController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public HatchBabyCostObjectInfo getHatchBabyCostObjectInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBabyCostObjectInfo(getContext(), pk);
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
    public HatchBabyCostObjectInfo getHatchBabyCostObjectInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBabyCostObjectInfo(getContext(), pk, selector);
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
    public HatchBabyCostObjectInfo getHatchBabyCostObjectInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBabyCostObjectInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HatchBabyCostObjectCollection getHatchBabyCostObjectCollection() throws BOSException
    {
        try {
            return getController().getHatchBabyCostObjectCollection(getContext());
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
    public HatchBabyCostObjectCollection getHatchBabyCostObjectCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHatchBabyCostObjectCollection(getContext(), view);
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
    public HatchBabyCostObjectCollection getHatchBabyCostObjectCollection(String oql) throws BOSException
    {
        try {
            return getController().getHatchBabyCostObjectCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}