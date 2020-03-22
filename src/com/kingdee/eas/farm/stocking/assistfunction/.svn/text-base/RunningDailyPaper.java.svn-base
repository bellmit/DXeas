package com.kingdee.eas.farm.stocking.assistfunction;

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
import com.kingdee.eas.farm.stocking.assistfunction.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class RunningDailyPaper extends CoreBillBase implements IRunningDailyPaper
{
    public RunningDailyPaper()
    {
        super();
        registerInterface(IRunningDailyPaper.class, this);
    }
    public RunningDailyPaper(Context ctx)
    {
        super(ctx);
        registerInterface(IRunningDailyPaper.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3B34CA67");
    }
    private RunningDailyPaperController getController() throws BOSException
    {
        return (RunningDailyPaperController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public RunningDailyPaperCollection getRunningDailyPaperCollection() throws BOSException
    {
        try {
            return getController().getRunningDailyPaperCollection(getContext());
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
    public RunningDailyPaperCollection getRunningDailyPaperCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getRunningDailyPaperCollection(getContext(), view);
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
    public RunningDailyPaperCollection getRunningDailyPaperCollection(String oql) throws BOSException
    {
        try {
            return getController().getRunningDailyPaperCollection(getContext(), oql);
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
    public RunningDailyPaperInfo getRunningDailyPaperInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getRunningDailyPaperInfo(getContext(), pk);
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
    public RunningDailyPaperInfo getRunningDailyPaperInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getRunningDailyPaperInfo(getContext(), pk, selector);
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
    public RunningDailyPaperInfo getRunningDailyPaperInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getRunningDailyPaperInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}