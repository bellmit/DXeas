package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.eas.farm.pig.breedingsow.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BabyPig extends CoreBillBase implements IBabyPig
{
    public BabyPig()
    {
        super();
        registerInterface(IBabyPig.class, this);
    }
    public BabyPig(Context ctx)
    {
        super(ctx);
        registerInterface(IBabyPig.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D6E1CF97");
    }
    private BabyPigController getController() throws BOSException
    {
        return (BabyPigController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BabyPigCollection getBabyPigCollection() throws BOSException
    {
        try {
            return getController().getBabyPigCollection(getContext());
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
    public BabyPigCollection getBabyPigCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBabyPigCollection(getContext(), view);
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
    public BabyPigCollection getBabyPigCollection(String oql) throws BOSException
    {
        try {
            return getController().getBabyPigCollection(getContext(), oql);
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
    public BabyPigInfo getBabyPigInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBabyPigInfo(getContext(), pk);
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
    public BabyPigInfo getBabyPigInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBabyPigInfo(getContext(), pk, selector);
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
    public BabyPigInfo getBabyPigInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBabyPigInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}