package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Map;
import com.kingdee.eas.farm.feedfactory.app.*;
import java.util.List;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class TruckPlanFacade extends AbstractBizCtrl implements ITruckPlanFacade
{
    public TruckPlanFacade()
    {
        super();
        registerInterface(ITruckPlanFacade.class, this);
    }
    public TruckPlanFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ITruckPlanFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2795E4C0");
    }
    private TruckPlanFacadeController getController() throws BOSException
    {
        return (TruckPlanFacadeController)getBizController();
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]返回要料计划明细[%returndesc]-User defined method
     *@param planDate 要料日期
     *@return
     */
    public List getFodderPlandetails(Date planDate) throws BOSException
    {
        try {
            return getController().getFodderPlandetails(getContext(), planDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得当前启用状态的饲料厂设置-User defined method
     *@return
     */
    public FeedFactoryBaseDataInfo getFeedFactoryBaseData() throws BOSException
    {
        try {
            return getController().getFeedFactoryBaseData(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]mapkey为 起点终点 id组合；value为对应的时间设置[%returndesc]-User defined method
     *@return
     */
    public Map getDistanseSetinfo() throws BOSException
    {
        try {
            return getController().getDistanseSetinfo(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}