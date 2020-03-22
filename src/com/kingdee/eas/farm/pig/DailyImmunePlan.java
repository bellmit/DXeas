package com.kingdee.eas.farm.pig;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.pig.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DailyImmunePlan extends DataBase implements IDailyImmunePlan
{
    public DailyImmunePlan()
    {
        super();
        registerInterface(IDailyImmunePlan.class, this);
    }
    public DailyImmunePlan(Context ctx)
    {
        super(ctx);
        registerInterface(IDailyImmunePlan.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DBAADF05");
    }
    private DailyImmunePlanController getController() throws BOSException
    {
        return (DailyImmunePlanController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public DailyImmunePlanInfo getDailyImmunePlanInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDailyImmunePlanInfo(getContext(), pk);
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
    public DailyImmunePlanInfo getDailyImmunePlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDailyImmunePlanInfo(getContext(), pk, selector);
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
    public DailyImmunePlanInfo getDailyImmunePlanInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDailyImmunePlanInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public DailyImmunePlanCollection getDailyImmunePlanCollection() throws BOSException
    {
        try {
            return getController().getDailyImmunePlanCollection(getContext());
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
    public DailyImmunePlanCollection getDailyImmunePlanCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDailyImmunePlanCollection(getContext(), view);
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
    public DailyImmunePlanCollection getDailyImmunePlanCollection(String oql) throws BOSException
    {
        try {
            return getController().getDailyImmunePlanCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}