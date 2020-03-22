package com.kingdee.eas.farm.breed.layegg;

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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.layegg.app.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LayEggHouseSet extends CoreBillBase implements ILayEggHouseSet
{
    public LayEggHouseSet()
    {
        super();
        registerInterface(ILayEggHouseSet.class, this);
    }
    public LayEggHouseSet(Context ctx)
    {
        super(ctx);
        registerInterface(ILayEggHouseSet.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D7AFD1D0");
    }
    private LayEggHouseSetController getController() throws BOSException
    {
        return (LayEggHouseSetController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public LayEggHouseSetCollection getLayEggHouseSetCollection() throws BOSException
    {
        try {
            return getController().getLayEggHouseSetCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public LayEggHouseSetCollection getLayEggHouseSetCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLayEggHouseSetCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public LayEggHouseSetCollection getLayEggHouseSetCollection(String oql) throws BOSException
    {
        try {
            return getController().getLayEggHouseSetCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public LayEggHouseSetInfo getLayEggHouseSetInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLayEggHouseSetInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public LayEggHouseSetInfo getLayEggHouseSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLayEggHouseSetInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public LayEggHouseSetInfo getLayEggHouseSetInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLayEggHouseSetInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}