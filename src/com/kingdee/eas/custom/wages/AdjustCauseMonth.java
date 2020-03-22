package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AdjustCauseMonth extends DataBase implements IAdjustCauseMonth
{
    public AdjustCauseMonth()
    {
        super();
        registerInterface(IAdjustCauseMonth.class, this);
    }
    public AdjustCauseMonth(Context ctx)
    {
        super(ctx);
        registerInterface(IAdjustCauseMonth.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("225D108E");
    }
    private AdjustCauseMonthController getController() throws BOSException
    {
        return (AdjustCauseMonthController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AdjustCauseMonthInfo getAdjustCauseMonthInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustCauseMonthInfo(getContext(), pk);
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
    public AdjustCauseMonthInfo getAdjustCauseMonthInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustCauseMonthInfo(getContext(), pk, selector);
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
    public AdjustCauseMonthInfo getAdjustCauseMonthInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustCauseMonthInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AdjustCauseMonthCollection getAdjustCauseMonthCollection() throws BOSException
    {
        try {
            return getController().getAdjustCauseMonthCollection(getContext());
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
    public AdjustCauseMonthCollection getAdjustCauseMonthCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAdjustCauseMonthCollection(getContext(), view);
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
    public AdjustCauseMonthCollection getAdjustCauseMonthCollection(String oql) throws BOSException
    {
        try {
            return getController().getAdjustCauseMonthCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}