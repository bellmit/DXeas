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

public class EggCandlingBill extends CoreBillBase implements IEggCandlingBill
{
    public EggCandlingBill()
    {
        super();
        registerInterface(IEggCandlingBill.class, this);
    }
    public EggCandlingBill(Context ctx)
    {
        super(ctx);
        registerInterface(IEggCandlingBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BF769488");
    }
    private EggCandlingBillController getController() throws BOSException
    {
        return (EggCandlingBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EggCandlingBillCollection getEggCandlingBillCollection() throws BOSException
    {
        try {
            return getController().getEggCandlingBillCollection(getContext());
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
    public EggCandlingBillCollection getEggCandlingBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEggCandlingBillCollection(getContext(), view);
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
    public EggCandlingBillCollection getEggCandlingBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getEggCandlingBillCollection(getContext(), oql);
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
    public EggCandlingBillInfo getEggCandlingBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEggCandlingBillInfo(getContext(), pk);
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
    public EggCandlingBillInfo getEggCandlingBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEggCandlingBillInfo(getContext(), pk, selector);
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
    public EggCandlingBillInfo getEggCandlingBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEggCandlingBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}