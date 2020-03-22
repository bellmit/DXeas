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

public class GestationCheck extends CoreBillBase implements IGestationCheck
{
    public GestationCheck()
    {
        super();
        registerInterface(IGestationCheck.class, this);
    }
    public GestationCheck(Context ctx)
    {
        super(ctx);
        registerInterface(IGestationCheck.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("07CBAC73");
    }
    private GestationCheckController getController() throws BOSException
    {
        return (GestationCheckController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public GestationCheckCollection getGestationCheckCollection() throws BOSException
    {
        try {
            return getController().getGestationCheckCollection(getContext());
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
    public GestationCheckCollection getGestationCheckCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getGestationCheckCollection(getContext(), view);
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
    public GestationCheckCollection getGestationCheckCollection(String oql) throws BOSException
    {
        try {
            return getController().getGestationCheckCollection(getContext(), oql);
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
    public GestationCheckInfo getGestationCheckInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getGestationCheckInfo(getContext(), pk);
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
    public GestationCheckInfo getGestationCheckInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getGestationCheckInfo(getContext(), pk, selector);
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
    public GestationCheckInfo getGestationCheckInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getGestationCheckInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}