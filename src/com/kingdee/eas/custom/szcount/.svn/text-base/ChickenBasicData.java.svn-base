package com.kingdee.eas.custom.szcount;

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
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.szcount.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ChickenBasicData extends WlhlDataBase implements IChickenBasicData
{
    public ChickenBasicData()
    {
        super();
        registerInterface(IChickenBasicData.class, this);
    }
    public ChickenBasicData(Context ctx)
    {
        super(ctx);
        registerInterface(IChickenBasicData.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D0049E2E");
    }
    private ChickenBasicDataController getController() throws BOSException
    {
        return (ChickenBasicDataController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ChickenBasicDataInfo getChickenBasicDataInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getChickenBasicDataInfo(getContext(), pk);
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
    public ChickenBasicDataInfo getChickenBasicDataInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getChickenBasicDataInfo(getContext(), pk, selector);
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
    public ChickenBasicDataInfo getChickenBasicDataInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getChickenBasicDataInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ChickenBasicDataCollection getChickenBasicDataCollection() throws BOSException
    {
        try {
            return getController().getChickenBasicDataCollection(getContext());
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
    public ChickenBasicDataCollection getChickenBasicDataCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getChickenBasicDataCollection(getContext(), view);
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
    public ChickenBasicDataCollection getChickenBasicDataCollection(String oql) throws BOSException
    {
        try {
            return getController().getChickenBasicDataCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}