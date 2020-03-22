package com.kingdee.eas.custom.eas2temp;

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
import com.kingdee.eas.custom.eas2temp.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DataBaseSetting extends DataBase implements IDataBaseSetting
{
    public DataBaseSetting()
    {
        super();
        registerInterface(IDataBaseSetting.class, this);
    }
    public DataBaseSetting(Context ctx)
    {
        super(ctx);
        registerInterface(IDataBaseSetting.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2F6377E1");
    }
    private DataBaseSettingController getController() throws BOSException
    {
        return (DataBaseSettingController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DataBaseSettingInfo getDataBaseSettingInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDataBaseSettingInfo(getContext(), pk);
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
    public DataBaseSettingInfo getDataBaseSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDataBaseSettingInfo(getContext(), pk, selector);
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
    public DataBaseSettingInfo getDataBaseSettingInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDataBaseSettingInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DataBaseSettingCollection getDataBaseSettingCollection() throws BOSException
    {
        try {
            return getController().getDataBaseSettingCollection(getContext());
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
    public DataBaseSettingCollection getDataBaseSettingCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDataBaseSettingCollection(getContext(), view);
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
    public DataBaseSettingCollection getDataBaseSettingCollection(String oql) throws BOSException
    {
        try {
            return getController().getDataBaseSettingCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *导出物料-User defined method
     *@param model model
     */
    public void importMaterial(DataBaseSettingInfo model) throws BOSException
    {
        try {
            getController().importMaterial(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *备份物料-User defined method
     *@param model model
     */
    public void bakmaterial(DataBaseSettingInfo model) throws BOSException
    {
        try {
            getController().bakmaterial(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}