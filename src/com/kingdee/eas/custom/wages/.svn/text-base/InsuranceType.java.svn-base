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

public class InsuranceType extends DataBase implements IInsuranceType
{
    public InsuranceType()
    {
        super();
        registerInterface(IInsuranceType.class, this);
    }
    public InsuranceType(Context ctx)
    {
        super(ctx);
        registerInterface(IInsuranceType.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F7051E2C");
    }
    private InsuranceTypeController getController() throws BOSException
    {
        return (InsuranceTypeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public InsuranceTypeInfo getInsuranceTypeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getInsuranceTypeInfo(getContext(), pk);
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
    public InsuranceTypeInfo getInsuranceTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getInsuranceTypeInfo(getContext(), pk, selector);
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
    public InsuranceTypeInfo getInsuranceTypeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getInsuranceTypeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public InsuranceTypeCollection getInsuranceTypeCollection() throws BOSException
    {
        try {
            return getController().getInsuranceTypeCollection(getContext());
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
    public InsuranceTypeCollection getInsuranceTypeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getInsuranceTypeCollection(getContext(), view);
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
    public InsuranceTypeCollection getInsuranceTypeCollection(String oql) throws BOSException
    {
        try {
            return getController().getInsuranceTypeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}