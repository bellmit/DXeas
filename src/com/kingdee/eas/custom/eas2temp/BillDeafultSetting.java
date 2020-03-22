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

public class BillDeafultSetting extends DataBase implements IBillDeafultSetting
{
    public BillDeafultSetting()
    {
        super();
        registerInterface(IBillDeafultSetting.class, this);
    }
    public BillDeafultSetting(Context ctx)
    {
        super(ctx);
        registerInterface(IBillDeafultSetting.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A3EF1474");
    }
    private BillDeafultSettingController getController() throws BOSException
    {
        return (BillDeafultSettingController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BillDeafultSettingInfo getBillDeafultSettingInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBillDeafultSettingInfo(getContext(), pk);
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
    public BillDeafultSettingInfo getBillDeafultSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBillDeafultSettingInfo(getContext(), pk, selector);
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
    public BillDeafultSettingInfo getBillDeafultSettingInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBillDeafultSettingInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BillDeafultSettingCollection getBillDeafultSettingCollection() throws BOSException
    {
        try {
            return getController().getBillDeafultSettingCollection(getContext());
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
    public BillDeafultSettingCollection getBillDeafultSettingCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBillDeafultSettingCollection(getContext(), view);
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
    public BillDeafultSettingCollection getBillDeafultSettingCollection(String oql) throws BOSException
    {
        try {
            return getController().getBillDeafultSettingCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}