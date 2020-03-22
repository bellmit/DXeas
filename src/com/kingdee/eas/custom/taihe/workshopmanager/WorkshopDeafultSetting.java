package com.kingdee.eas.custom.taihe.workshopmanager;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.taihe.workshopmanager.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WorkshopDeafultSetting extends WlhlDataBase implements IWorkshopDeafultSetting
{
    public WorkshopDeafultSetting()
    {
        super();
        registerInterface(IWorkshopDeafultSetting.class, this);
    }
    public WorkshopDeafultSetting(Context ctx)
    {
        super(ctx);
        registerInterface(IWorkshopDeafultSetting.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F00325C2");
    }
    private WorkshopDeafultSettingController getController() throws BOSException
    {
        return (WorkshopDeafultSettingController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WorkshopDeafultSettingInfo getWorkshopDeafultSettingInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkshopDeafultSettingInfo(getContext(), pk);
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
    public WorkshopDeafultSettingInfo getWorkshopDeafultSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkshopDeafultSettingInfo(getContext(), pk, selector);
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
    public WorkshopDeafultSettingInfo getWorkshopDeafultSettingInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkshopDeafultSettingInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WorkshopDeafultSettingCollection getWorkshopDeafultSettingCollection() throws BOSException
    {
        try {
            return getController().getWorkshopDeafultSettingCollection(getContext());
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
    public WorkshopDeafultSettingCollection getWorkshopDeafultSettingCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWorkshopDeafultSettingCollection(getContext(), view);
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
    public WorkshopDeafultSettingCollection getWorkshopDeafultSettingCollection(String oql) throws BOSException
    {
        try {
            return getController().getWorkshopDeafultSettingCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}