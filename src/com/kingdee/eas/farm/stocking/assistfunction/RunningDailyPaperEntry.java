package com.kingdee.eas.farm.stocking.assistfunction;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.stocking.assistfunction.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class RunningDailyPaperEntry extends CoreBillEntryBase implements IRunningDailyPaperEntry
{
    public RunningDailyPaperEntry()
    {
        super();
        registerInterface(IRunningDailyPaperEntry.class, this);
    }
    public RunningDailyPaperEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IRunningDailyPaperEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0BFCB64B");
    }
    private RunningDailyPaperEntryController getController() throws BOSException
    {
        return (RunningDailyPaperEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public RunningDailyPaperEntryInfo getRunningDailyPaperEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getRunningDailyPaperEntryInfo(getContext(), pk);
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
    public RunningDailyPaperEntryInfo getRunningDailyPaperEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getRunningDailyPaperEntryInfo(getContext(), pk, selector);
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
    public RunningDailyPaperEntryInfo getRunningDailyPaperEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getRunningDailyPaperEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public RunningDailyPaperEntryCollection getRunningDailyPaperEntryCollection() throws BOSException
    {
        try {
            return getController().getRunningDailyPaperEntryCollection(getContext());
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
    public RunningDailyPaperEntryCollection getRunningDailyPaperEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getRunningDailyPaperEntryCollection(getContext(), view);
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
    public RunningDailyPaperEntryCollection getRunningDailyPaperEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getRunningDailyPaperEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}