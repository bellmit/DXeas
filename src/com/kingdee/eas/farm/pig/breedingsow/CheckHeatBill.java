package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.eas.farm.pig.breedingsow.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CheckHeatBill extends CoreBillBase implements ICheckHeatBill
{
    public CheckHeatBill()
    {
        super();
        registerInterface(ICheckHeatBill.class, this);
    }
    public CheckHeatBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICheckHeatBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2E0136BE");
    }
    private CheckHeatBillController getController() throws BOSException
    {
        return (CheckHeatBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CheckHeatBillCollection getCheckHeatBillCollection() throws BOSException
    {
        try {
            return getController().getCheckHeatBillCollection(getContext());
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
    public CheckHeatBillCollection getCheckHeatBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCheckHeatBillCollection(getContext(), view);
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
    public CheckHeatBillCollection getCheckHeatBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCheckHeatBillCollection(getContext(), oql);
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
    public CheckHeatBillInfo getCheckHeatBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckHeatBillInfo(getContext(), pk);
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
    public CheckHeatBillInfo getCheckHeatBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckHeatBillInfo(getContext(), pk, selector);
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
    public CheckHeatBillInfo getCheckHeatBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckHeatBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}