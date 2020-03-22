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

public class BreedArea extends CoreBillBase implements IBreedArea
{
    public BreedArea()
    {
        super();
        registerInterface(IBreedArea.class, this);
    }
    public BreedArea(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedArea.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EF97B007");
    }
    private BreedAreaController getController() throws BOSException
    {
        return (BreedAreaController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BreedAreaCollection getBreedAreaCollection() throws BOSException
    {
        try {
            return getController().getBreedAreaCollection(getContext());
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
    public BreedAreaCollection getBreedAreaCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedAreaCollection(getContext(), view);
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
    public BreedAreaCollection getBreedAreaCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedAreaCollection(getContext(), oql);
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
    public BreedAreaInfo getBreedAreaInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedAreaInfo(getContext(), pk);
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
    public BreedAreaInfo getBreedAreaInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedAreaInfo(getContext(), pk, selector);
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
    public BreedAreaInfo getBreedAreaInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedAreaInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}