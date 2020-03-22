package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.app.*;
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

public class HatchBillCoefficient extends DataBase implements IHatchBillCoefficient
{
    public HatchBillCoefficient()
    {
        super();
        registerInterface(IHatchBillCoefficient.class, this);
    }
    public HatchBillCoefficient(Context ctx)
    {
        super(ctx);
        registerInterface(IHatchBillCoefficient.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8F8EB95C");
    }
    private HatchBillCoefficientController getController() throws BOSException
    {
        return (HatchBillCoefficientController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public HatchBillCoefficientInfo getHatchBillCoefficientInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBillCoefficientInfo(getContext(), pk);
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
    public HatchBillCoefficientInfo getHatchBillCoefficientInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBillCoefficientInfo(getContext(), pk, selector);
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
    public HatchBillCoefficientInfo getHatchBillCoefficientInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBillCoefficientInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HatchBillCoefficientCollection getHatchBillCoefficientCollection() throws BOSException
    {
        try {
            return getController().getHatchBillCoefficientCollection(getContext());
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
    public HatchBillCoefficientCollection getHatchBillCoefficientCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHatchBillCoefficientCollection(getContext(), view);
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
    public HatchBillCoefficientCollection getHatchBillCoefficientCollection(String oql) throws BOSException
    {
        try {
            return getController().getHatchBillCoefficientCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}