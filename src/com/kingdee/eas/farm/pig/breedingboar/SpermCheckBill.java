package com.kingdee.eas.farm.pig.breedingboar;

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
import com.kingdee.eas.farm.pig.breedingboar.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SpermCheckBill extends CoreBillBase implements ISpermCheckBill
{
    public SpermCheckBill()
    {
        super();
        registerInterface(ISpermCheckBill.class, this);
    }
    public SpermCheckBill(Context ctx)
    {
        super(ctx);
        registerInterface(ISpermCheckBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EFD73B48");
    }
    private SpermCheckBillController getController() throws BOSException
    {
        return (SpermCheckBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SpermCheckBillCollection getSpermCheckBillCollection() throws BOSException
    {
        try {
            return getController().getSpermCheckBillCollection(getContext());
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
    public SpermCheckBillCollection getSpermCheckBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSpermCheckBillCollection(getContext(), view);
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
    public SpermCheckBillCollection getSpermCheckBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getSpermCheckBillCollection(getContext(), oql);
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
    public SpermCheckBillInfo getSpermCheckBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSpermCheckBillInfo(getContext(), pk);
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
    public SpermCheckBillInfo getSpermCheckBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSpermCheckBillInfo(getContext(), pk, selector);
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
    public SpermCheckBillInfo getSpermCheckBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSpermCheckBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}