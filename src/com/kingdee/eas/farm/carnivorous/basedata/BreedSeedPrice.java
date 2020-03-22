package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
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
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BreedSeedPrice extends DataBase implements IBreedSeedPrice
{
    public BreedSeedPrice()
    {
        super();
        registerInterface(IBreedSeedPrice.class, this);
    }
    public BreedSeedPrice(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedSeedPrice.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("30150866");
    }
    private BreedSeedPriceController getController() throws BOSException
    {
        return (BreedSeedPriceController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BreedSeedPriceInfo getBreedSeedPriceInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedSeedPriceInfo(getContext(), pk);
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
    public BreedSeedPriceInfo getBreedSeedPriceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedSeedPriceInfo(getContext(), pk, selector);
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
    public BreedSeedPriceInfo getBreedSeedPriceInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedSeedPriceInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BreedSeedPriceCollection getBreedSeedPriceCollection() throws BOSException
    {
        try {
            return getController().getBreedSeedPriceCollection(getContext());
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
    public BreedSeedPriceCollection getBreedSeedPriceCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedSeedPriceCollection(getContext(), view);
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
    public BreedSeedPriceCollection getBreedSeedPriceCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedSeedPriceCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(BreedSeedPriceInfo model) throws BOSException, EASBizException
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
    public void unAudit(BreedSeedPriceInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}