package com.kingdee.eas.farm.stocking.assistfunction;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.stocking.assistfunction.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EggReceiveBillColorSetting extends DataBase implements IEggReceiveBillColorSetting
{
    public EggReceiveBillColorSetting()
    {
        super();
        registerInterface(IEggReceiveBillColorSetting.class, this);
    }
    public EggReceiveBillColorSetting(Context ctx)
    {
        super(ctx);
        registerInterface(IEggReceiveBillColorSetting.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A1BD419D");
    }
    private EggReceiveBillColorSettingController getController() throws BOSException
    {
        return (EggReceiveBillColorSettingController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public EggReceiveBillColorSettingInfo getEggReceiveBillColorSettingInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEggReceiveBillColorSettingInfo(getContext(), pk);
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
    public EggReceiveBillColorSettingInfo getEggReceiveBillColorSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEggReceiveBillColorSettingInfo(getContext(), pk, selector);
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
    public EggReceiveBillColorSettingInfo getEggReceiveBillColorSettingInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEggReceiveBillColorSettingInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EggReceiveBillColorSettingCollection getEggReceiveBillColorSettingCollection() throws BOSException
    {
        try {
            return getController().getEggReceiveBillColorSettingCollection(getContext());
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
    public EggReceiveBillColorSettingCollection getEggReceiveBillColorSettingCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEggReceiveBillColorSettingCollection(getContext(), view);
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
    public EggReceiveBillColorSettingCollection getEggReceiveBillColorSettingCollection(String oql) throws BOSException
    {
        try {
            return getController().getEggReceiveBillColorSettingCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}