package com.kingdee.eas.farm.rpt;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.rpt.app.*;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public class CapitalDailyRptFacade extends AbstractBizCtrl implements ICapitalDailyRptFacade
{
    public CapitalDailyRptFacade()
    {
        super();
        registerInterface(ICapitalDailyRptFacade.class, this);
    }
    public CapitalDailyRptFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICapitalDailyRptFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D7FC0FC7");
    }
    private CapitalDailyRptFacadeController getController() throws BOSException
    {
        return (CapitalDailyRptFacadeController)getBizController();
    }
    /**
     *getCapitalDailyInfos-User defined method
     *@param beginDate 开始日期
     *@param endDate endDate
     *@param companyId 公司id
     *@return
     */
    public HashMap getCapitalDailyInfos(Date beginDate, Date endDate, String companyId) throws BOSException
    {
        try {
            return getController().getCapitalDailyInfos(getContext(), beginDate, endDate, companyId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *清空临时表-User defined method
     *@param temptableName 临时表名
     */
    public void releaseTempTable(String temptableName) throws BOSException
    {
        try {
            getController().releaseTempTable(getContext(), temptableName);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取北三峡所有公司 经营日报-User defined method
     *@param beginDate beginDate
     *@param endDate endDate
     *@param isGather 是否汇总
     *@param capitalType 1代表余额   2 代表发生额
     *@return
     */
    public HashMap getAllCompanysCapitalDailyInfos(Date beginDate, Date endDate, int isGather, String capitalType) throws BOSException
    {
        try {
            return getController().getAllCompanysCapitalDailyInfos(getContext(), beginDate, endDate, isGather, capitalType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}