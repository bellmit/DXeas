package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.dayratecost.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DayRateInitBill extends CoreBillBase implements IDayRateInitBill
{
    public DayRateInitBill()
    {
        super();
        registerInterface(IDayRateInitBill.class, this);
    }
    public DayRateInitBill(Context ctx)
    {
        super(ctx);
        registerInterface(IDayRateInitBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8E080BEE");
    }
    private DayRateInitBillController getController() throws BOSException
    {
        return (DayRateInitBillController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public DayRateInitBillCollection getDayRateInitBillCollection() throws BOSException
    {
        try {
            return getController().getDayRateInitBillCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public DayRateInitBillCollection getDayRateInitBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDayRateInitBillCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public DayRateInitBillCollection getDayRateInitBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getDayRateInitBillCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public DayRateInitBillInfo getDayRateInitBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDayRateInitBillInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public DayRateInitBillInfo getDayRateInitBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDayRateInitBillInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public DayRateInitBillInfo getDayRateInitBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDayRateInitBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(DayRateInitBillInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����-User defined method
     *@param model model
     */
    public void unAudit(DayRateInitBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ʼ��-User defined method
     *@param model model
     */
    public void initialize(DayRateInitBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().initialize(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����ʼ��-User defined method
     *@param model model
     */
    public void unInitialize(DayRateInitBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unInitialize(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}