package com.kingdee.eas.farm.breed.layegg;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.layegg.app.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EggConveyor extends DataBase implements IEggConveyor
{
    public EggConveyor()
    {
        super();
        registerInterface(IEggConveyor.class, this);
    }
    public EggConveyor(Context ctx)
    {
        super(ctx);
        registerInterface(IEggConveyor.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("453E2B43");
    }
    private EggConveyorController getController() throws BOSException
    {
        return (EggConveyorController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public EggConveyorInfo getEggConveyorInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEggConveyorInfo(getContext(), pk);
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
    public EggConveyorInfo getEggConveyorInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEggConveyorInfo(getContext(), pk, selector);
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
    public EggConveyorInfo getEggConveyorInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEggConveyorInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EggConveyorCollection getEggConveyorCollection() throws BOSException
    {
        try {
            return getController().getEggConveyorCollection(getContext());
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
    public EggConveyorCollection getEggConveyorCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEggConveyorCollection(getContext(), view);
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
    public EggConveyorCollection getEggConveyorCollection(String oql) throws BOSException
    {
        try {
            return getController().getEggConveyorCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}