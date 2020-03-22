package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.stocking.basedata.app.*;
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

public class FarmerInterest extends DataBase implements IFarmerInterest
{
    public FarmerInterest()
    {
        super();
        registerInterface(IFarmerInterest.class, this);
    }
    public FarmerInterest(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmerInterest.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0B2F013E");
    }
    private FarmerInterestController getController() throws BOSException
    {
        return (FarmerInterestController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public FarmerInterestInfo getFarmerInterestInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerInterestInfo(getContext(), pk);
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
    public FarmerInterestInfo getFarmerInterestInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerInterestInfo(getContext(), pk, selector);
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
    public FarmerInterestInfo getFarmerInterestInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerInterestInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public FarmerInterestCollection getFarmerInterestCollection() throws BOSException
    {
        try {
            return getController().getFarmerInterestCollection(getContext());
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
    public FarmerInterestCollection getFarmerInterestCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmerInterestCollection(getContext(), view);
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
    public FarmerInterestCollection getFarmerInterestCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmerInterestCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}