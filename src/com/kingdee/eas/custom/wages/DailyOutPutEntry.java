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
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DailyOutPutEntry extends CoreBillEntryBase implements IDailyOutPutEntry
{
    public DailyOutPutEntry()
    {
        super();
        registerInterface(IDailyOutPutEntry.class, this);
    }
    public DailyOutPutEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IDailyOutPutEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("54F85840");
    }
    private DailyOutPutEntryController getController() throws BOSException
    {
        return (DailyOutPutEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public DailyOutPutEntryInfo getDailyOutPutEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDailyOutPutEntryInfo(getContext(), pk);
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
    public DailyOutPutEntryInfo getDailyOutPutEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDailyOutPutEntryInfo(getContext(), pk, selector);
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
    public DailyOutPutEntryInfo getDailyOutPutEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDailyOutPutEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public DailyOutPutEntryCollection getDailyOutPutEntryCollection() throws BOSException
    {
        try {
            return getController().getDailyOutPutEntryCollection(getContext());
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
    public DailyOutPutEntryCollection getDailyOutPutEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDailyOutPutEntryCollection(getContext(), view);
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
    public DailyOutPutEntryCollection getDailyOutPutEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getDailyOutPutEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}