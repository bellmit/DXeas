package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
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

public class FarmerType extends DataBase implements IFarmerType
{
    public FarmerType()
    {
        super();
        registerInterface(IFarmerType.class, this);
    }
    public FarmerType(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmerType.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EA2D385F");
    }
    private FarmerTypeController getController() throws BOSException
    {
        return (FarmerTypeController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public FarmerTypeInfo getFarmerTypeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerTypeInfo(getContext(), pk);
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
    public FarmerTypeInfo getFarmerTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerTypeInfo(getContext(), pk, selector);
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
    public FarmerTypeInfo getFarmerTypeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerTypeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public FarmerTypeCollection getFarmerTypeCollection() throws BOSException
    {
        try {
            return getController().getFarmerTypeCollection(getContext());
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
    public FarmerTypeCollection getFarmerTypeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmerTypeCollection(getContext(), view);
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
    public FarmerTypeCollection getFarmerTypeCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmerTypeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��׼-User defined method
     *@param model model
     */
    public void audit(FarmerTypeInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����׼-User defined method
     *@param model model
     */
    public void unAudit(FarmerTypeInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}