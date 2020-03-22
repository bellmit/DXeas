package com.kingdee.eas.custom.taihe.weight;

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
import com.kingdee.eas.custom.taihe.weight.app.*;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WgtDisRate extends DataBase implements IWgtDisRate
{
    public WgtDisRate()
    {
        super();
        registerInterface(IWgtDisRate.class, this);
    }
    public WgtDisRate(Context ctx)
    {
        super(ctx);
        registerInterface(IWgtDisRate.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5DBA1500");
    }
    private WgtDisRateController getController() throws BOSException
    {
        return (WgtDisRateController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WgtDisRateInfo getWgtDisRateInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWgtDisRateInfo(getContext(), pk);
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
    public WgtDisRateInfo getWgtDisRateInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWgtDisRateInfo(getContext(), pk, selector);
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
    public WgtDisRateInfo getWgtDisRateInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWgtDisRateInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WgtDisRateCollection getWgtDisRateCollection() throws BOSException
    {
        try {
            return getController().getWgtDisRateCollection(getContext());
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
    public WgtDisRateCollection getWgtDisRateCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWgtDisRateCollection(getContext(), view);
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
    public WgtDisRateCollection getWgtDisRateCollection(String oql) throws BOSException
    {
        try {
            return getController().getWgtDisRateCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}