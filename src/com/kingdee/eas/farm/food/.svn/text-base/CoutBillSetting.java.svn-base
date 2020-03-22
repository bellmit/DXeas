package com.kingdee.eas.farm.food;

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
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CoutBillSetting extends DataBase implements ICoutBillSetting
{
    public CoutBillSetting()
    {
        super();
        registerInterface(ICoutBillSetting.class, this);
    }
    public CoutBillSetting(Context ctx)
    {
        super(ctx);
        registerInterface(ICoutBillSetting.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E105C954");
    }
    private CoutBillSettingController getController() throws BOSException
    {
        return (CoutBillSettingController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CoutBillSettingInfo getCoutBillSettingInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCoutBillSettingInfo(getContext(), pk);
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
    public CoutBillSettingInfo getCoutBillSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCoutBillSettingInfo(getContext(), pk, selector);
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
    public CoutBillSettingInfo getCoutBillSettingInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCoutBillSettingInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CoutBillSettingCollection getCoutBillSettingCollection() throws BOSException
    {
        try {
            return getController().getCoutBillSettingCollection(getContext());
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
    public CoutBillSettingCollection getCoutBillSettingCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCoutBillSettingCollection(getContext(), view);
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
    public CoutBillSettingCollection getCoutBillSettingCollection(String oql) throws BOSException
    {
        try {
            return getController().getCoutBillSettingCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}