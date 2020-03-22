package com.kingdee.eas.farm.pig.breedingboar;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.pig.breedingboar.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BreedingBoarBreedModel extends CoreBillBase implements IBreedingBoarBreedModel
{
    public BreedingBoarBreedModel()
    {
        super();
        registerInterface(IBreedingBoarBreedModel.class, this);
    }
    public BreedingBoarBreedModel(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedingBoarBreedModel.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1DDF403D");
    }
    private BreedingBoarBreedModelController getController() throws BOSException
    {
        return (BreedingBoarBreedModelController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BreedingBoarBreedModelCollection getBreedingBoarBreedModelCollection() throws BOSException
    {
        try {
            return getController().getBreedingBoarBreedModelCollection(getContext());
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
    public BreedingBoarBreedModelCollection getBreedingBoarBreedModelCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedingBoarBreedModelCollection(getContext(), view);
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
    public BreedingBoarBreedModelCollection getBreedingBoarBreedModelCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedingBoarBreedModelCollection(getContext(), oql);
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
    public BreedingBoarBreedModelInfo getBreedingBoarBreedModelInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedingBoarBreedModelInfo(getContext(), pk);
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
    public BreedingBoarBreedModelInfo getBreedingBoarBreedModelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedingBoarBreedModelInfo(getContext(), pk, selector);
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
    public BreedingBoarBreedModelInfo getBreedingBoarBreedModelInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedingBoarBreedModelInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}