package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.app.*;
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

public class EggHatchBill extends CoreBillBase implements IEggHatchBill
{
    public EggHatchBill()
    {
        super();
        registerInterface(IEggHatchBill.class, this);
    }
    public EggHatchBill(Context ctx)
    {
        super(ctx);
        registerInterface(IEggHatchBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0648D2F0");
    }
    private EggHatchBillController getController() throws BOSException
    {
        return (EggHatchBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EggHatchBillCollection getEggHatchBillCollection() throws BOSException
    {
        try {
            return getController().getEggHatchBillCollection(getContext());
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
    public EggHatchBillCollection getEggHatchBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEggHatchBillCollection(getContext(), view);
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
    public EggHatchBillCollection getEggHatchBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getEggHatchBillCollection(getContext(), oql);
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
    public EggHatchBillInfo getEggHatchBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEggHatchBillInfo(getContext(), pk);
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
    public EggHatchBillInfo getEggHatchBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEggHatchBillInfo(getContext(), pk, selector);
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
    public EggHatchBillInfo getEggHatchBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEggHatchBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}