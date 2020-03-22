package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wages.farm.app.*;
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

public class MotorcadePayroll extends CoreBillBase implements IMotorcadePayroll
{
    public MotorcadePayroll()
    {
        super();
        registerInterface(IMotorcadePayroll.class, this);
    }
    public MotorcadePayroll(Context ctx)
    {
        super(ctx);
        registerInterface(IMotorcadePayroll.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D0B3BB5B");
    }
    private MotorcadePayrollController getController() throws BOSException
    {
        return (MotorcadePayrollController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MotorcadePayrollCollection getMotorcadePayrollCollection() throws BOSException
    {
        try {
            return getController().getMotorcadePayrollCollection(getContext());
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
    public MotorcadePayrollCollection getMotorcadePayrollCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMotorcadePayrollCollection(getContext(), view);
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
    public MotorcadePayrollCollection getMotorcadePayrollCollection(String oql) throws BOSException
    {
        try {
            return getController().getMotorcadePayrollCollection(getContext(), oql);
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
    public MotorcadePayrollInfo getMotorcadePayrollInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMotorcadePayrollInfo(getContext(), pk);
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
    public MotorcadePayrollInfo getMotorcadePayrollInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMotorcadePayrollInfo(getContext(), pk, selector);
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
    public MotorcadePayrollInfo getMotorcadePayrollInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMotorcadePayrollInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(MotorcadePayrollInfo model) throws BOSException
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
    public void unaudit(MotorcadePayrollInfo model) throws BOSException
    {
        try {
            getController().unaudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}