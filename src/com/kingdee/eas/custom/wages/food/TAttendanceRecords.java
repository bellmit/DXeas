package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.wages.food.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class TAttendanceRecords extends CoreBillBase implements ITAttendanceRecords
{
    public TAttendanceRecords()
    {
        super();
        registerInterface(ITAttendanceRecords.class, this);
    }
    public TAttendanceRecords(Context ctx)
    {
        super(ctx);
        registerInterface(ITAttendanceRecords.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F7BF7987");
    }
    private TAttendanceRecordsController getController() throws BOSException
    {
        return (TAttendanceRecordsController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TAttendanceRecordsCollection getTAttendanceRecordsCollection() throws BOSException
    {
        try {
            return getController().getTAttendanceRecordsCollection(getContext());
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
    public TAttendanceRecordsCollection getTAttendanceRecordsCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTAttendanceRecordsCollection(getContext(), view);
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
    public TAttendanceRecordsCollection getTAttendanceRecordsCollection(String oql) throws BOSException
    {
        try {
            return getController().getTAttendanceRecordsCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public TAttendanceRecordsInfo getTAttendanceRecordsInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTAttendanceRecordsInfo(getContext(), pk);
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
    public TAttendanceRecordsInfo getTAttendanceRecordsInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTAttendanceRecordsInfo(getContext(), pk, selector);
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
    public TAttendanceRecordsInfo getTAttendanceRecordsInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTAttendanceRecordsInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(TAttendanceRecordsInfo model) throws BOSException
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
    public void unaudit(TAttendanceRecordsInfo model) throws BOSException
    {
        try {
            getController().unaudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}