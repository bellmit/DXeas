package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.dayratecost.app.*;
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
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DayRateBaseSetting extends DataBase implements IDayRateBaseSetting
{
    public DayRateBaseSetting()
    {
        super();
        registerInterface(IDayRateBaseSetting.class, this);
    }
    public DayRateBaseSetting(Context ctx)
    {
        super(ctx);
        registerInterface(IDayRateBaseSetting.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("11CFDC28");
    }
    private DayRateBaseSettingController getController() throws BOSException
    {
        return (DayRateBaseSettingController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DayRateBaseSettingInfo getDayRateBaseSettingInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDayRateBaseSettingInfo(getContext(), pk);
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
    public DayRateBaseSettingInfo getDayRateBaseSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDayRateBaseSettingInfo(getContext(), pk, selector);
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
    public DayRateBaseSettingInfo getDayRateBaseSettingInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDayRateBaseSettingInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DayRateBaseSettingCollection getDayRateBaseSettingCollection() throws BOSException
    {
        try {
            return getController().getDayRateBaseSettingCollection(getContext());
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
    public DayRateBaseSettingCollection getDayRateBaseSettingCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDayRateBaseSettingCollection(getContext(), view);
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
    public DayRateBaseSettingCollection getDayRateBaseSettingCollection(String oql) throws BOSException
    {
        try {
            return getController().getDayRateBaseSettingCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}