package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AttendanceBill extends WlhlBillBase implements IAttendanceBill
{
    public AttendanceBill()
    {
        super();
        registerInterface(IAttendanceBill.class, this);
    }
    public AttendanceBill(Context ctx)
    {
        super(ctx);
        registerInterface(IAttendanceBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("13B28C98");
    }
    private AttendanceBillController getController() throws BOSException
    {
        return (AttendanceBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AttendanceBillCollection getAttendanceBillCollection() throws BOSException
    {
        try {
            return getController().getAttendanceBillCollection(getContext());
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
    public AttendanceBillCollection getAttendanceBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAttendanceBillCollection(getContext(), view);
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
    public AttendanceBillCollection getAttendanceBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getAttendanceBillCollection(getContext(), oql);
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
    public AttendanceBillInfo getAttendanceBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAttendanceBillInfo(getContext(), pk);
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
    public AttendanceBillInfo getAttendanceBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAttendanceBillInfo(getContext(), pk, selector);
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
    public AttendanceBillInfo getAttendanceBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAttendanceBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}