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

public class DayrateFeeItem extends DataBase implements IDayrateFeeItem
{
    public DayrateFeeItem()
    {
        super();
        registerInterface(IDayrateFeeItem.class, this);
    }
    public DayrateFeeItem(Context ctx)
    {
        super(ctx);
        registerInterface(IDayrateFeeItem.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3D245642");
    }
    private DayrateFeeItemController getController() throws BOSException
    {
        return (DayrateFeeItemController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DayrateFeeItemInfo getDayrateFeeItemInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDayrateFeeItemInfo(getContext(), pk);
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
    public DayrateFeeItemInfo getDayrateFeeItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDayrateFeeItemInfo(getContext(), pk, selector);
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
    public DayrateFeeItemInfo getDayrateFeeItemInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDayrateFeeItemInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DayrateFeeItemCollection getDayrateFeeItemCollection() throws BOSException
    {
        try {
            return getController().getDayrateFeeItemCollection(getContext());
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
    public DayrateFeeItemCollection getDayrateFeeItemCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDayrateFeeItemCollection(getContext(), view);
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
    public DayrateFeeItemCollection getDayrateFeeItemCollection(String oql) throws BOSException
    {
        try {
            return getController().getDayrateFeeItemCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void audit(DayrateFeeItemInfo model) throws BOSException, EASBizException
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
    public void unAudit(DayrateFeeItemInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}