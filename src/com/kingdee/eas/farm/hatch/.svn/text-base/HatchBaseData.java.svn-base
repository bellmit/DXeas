package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.app.*;
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

public class HatchBaseData extends DataBase implements IHatchBaseData
{
    public HatchBaseData()
    {
        super();
        registerInterface(IHatchBaseData.class, this);
    }
    public HatchBaseData(Context ctx)
    {
        super(ctx);
        registerInterface(IHatchBaseData.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("22461B2D");
    }
    private HatchBaseDataController getController() throws BOSException
    {
        return (HatchBaseDataController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public HatchBaseDataInfo getHatchBaseDataInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBaseDataInfo(getContext(), pk);
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
    public HatchBaseDataInfo getHatchBaseDataInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBaseDataInfo(getContext(), pk, selector);
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
    public HatchBaseDataInfo getHatchBaseDataInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBaseDataInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HatchBaseDataCollection getHatchBaseDataCollection() throws BOSException
    {
        try {
            return getController().getHatchBaseDataCollection(getContext());
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
    public HatchBaseDataCollection getHatchBaseDataCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHatchBaseDataCollection(getContext(), view);
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
    public HatchBaseDataCollection getHatchBaseDataCollection(String oql) throws BOSException
    {
        try {
            return getController().getHatchBaseDataCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(HatchBaseDataInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(HatchBaseDataInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}