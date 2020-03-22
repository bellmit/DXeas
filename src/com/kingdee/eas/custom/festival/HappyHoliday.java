package com.kingdee.eas.custom.festival;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.festival.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class HappyHoliday extends DataBase implements IHappyHoliday
{
    public HappyHoliday()
    {
        super();
        registerInterface(IHappyHoliday.class, this);
    }
    public HappyHoliday(Context ctx)
    {
        super(ctx);
        registerInterface(IHappyHoliday.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0B99D8E3");
    }
    private HappyHolidayController getController() throws BOSException
    {
        return (HappyHolidayController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public HappyHolidayInfo getHappyHolidayInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHappyHolidayInfo(getContext(), pk);
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
    public HappyHolidayInfo getHappyHolidayInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHappyHolidayInfo(getContext(), pk, selector);
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
    public HappyHolidayInfo getHappyHolidayInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHappyHolidayInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public HappyHolidayCollection getHappyHolidayCollection() throws BOSException
    {
        try {
            return getController().getHappyHolidayCollection(getContext());
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
    public HappyHolidayCollection getHappyHolidayCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHappyHolidayCollection(getContext(), view);
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
    public HappyHolidayCollection getHappyHolidayCollection(String oql) throws BOSException
    {
        try {
            return getController().getHappyHolidayCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}