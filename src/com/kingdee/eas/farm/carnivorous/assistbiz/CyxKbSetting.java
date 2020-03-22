package com.kingdee.eas.farm.carnivorous.assistbiz;

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
import com.kingdee.eas.farm.carnivorous.assistbiz.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CyxKbSetting extends DataBase implements ICyxKbSetting
{
    public CyxKbSetting()
    {
        super();
        registerInterface(ICyxKbSetting.class, this);
    }
    public CyxKbSetting(Context ctx)
    {
        super(ctx);
        registerInterface(ICyxKbSetting.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8363C686");
    }
    private CyxKbSettingController getController() throws BOSException
    {
        return (CyxKbSettingController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CyxKbSettingInfo getCyxKbSettingInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCyxKbSettingInfo(getContext(), pk);
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
    public CyxKbSettingInfo getCyxKbSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCyxKbSettingInfo(getContext(), pk, selector);
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
    public CyxKbSettingInfo getCyxKbSettingInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCyxKbSettingInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CyxKbSettingCollection getCyxKbSettingCollection() throws BOSException
    {
        try {
            return getController().getCyxKbSettingCollection(getContext());
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
    public CyxKbSettingCollection getCyxKbSettingCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCyxKbSettingCollection(getContext(), view);
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
    public CyxKbSettingCollection getCyxKbSettingCollection(String oql) throws BOSException
    {
        try {
            return getController().getCyxKbSettingCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void audit(CyxKbSettingInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反核准-User defined method
     *@param model model
     */
    public void unAudit(CyxKbSettingInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}