package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.lang.String;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.custom.eas2temp.app.*;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.IDataBase;

public class BarMaterialRel extends DataBase implements IBarMaterialRel
{
    public BarMaterialRel()
    {
        super();
        registerInterface(IBarMaterialRel.class, this);
    }
    public BarMaterialRel(Context ctx)
    {
        super(ctx);
        registerInterface(IBarMaterialRel.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F69D76B3");
    }
    private BarMaterialRelController getController() throws BOSException
    {
        return (BarMaterialRelController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BarMaterialRelInfo getBarMaterialRelInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBarMaterialRelInfo(getContext(), pk);
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
    public BarMaterialRelInfo getBarMaterialRelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBarMaterialRelInfo(getContext(), pk, selector);
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
    public BarMaterialRelInfo getBarMaterialRelInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBarMaterialRelInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BarMaterialRelCollection getBarMaterialRelCollection() throws BOSException
    {
        try {
            return getController().getBarMaterialRelCollection(getContext());
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
    public BarMaterialRelCollection getBarMaterialRelCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBarMaterialRelCollection(getContext(), view);
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
    public BarMaterialRelCollection getBarMaterialRelCollection(String oql) throws BOSException
    {
        try {
            return getController().getBarMaterialRelCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}