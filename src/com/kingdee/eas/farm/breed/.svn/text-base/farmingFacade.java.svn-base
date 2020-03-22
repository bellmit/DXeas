package com.kingdee.eas.farm.breed;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.util.ArrayList;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.breed.app.*;
import java.lang.String;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class farmingFacade extends AbstractBizCtrl implements IfarmingFacade
{
    public farmingFacade()
    {
        super();
        registerInterface(IfarmingFacade.class, this);
    }
    public farmingFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IfarmingFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E37AA0AC");
    }
    private farmingFacadeController getController() throws BOSException
    {
        return (farmingFacadeController)getBizController();
    }
    /**
     *看板获得计划的详细信息-User defined method
     *@param date 日期
     *@param period 会计期间
     *@param stoOrgUnit 库存组织
     *@param planType 养殖计划的类型
     *@return
     */
    public ArrayList getBreedPlan(Date date, PeriodInfo period, StorageOrgUnitInfo stoOrgUnit, String planType) throws BOSException
    {
        try {
            return getController().getBreedPlan(getContext(), date, period, stoOrgUnit, planType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getSlaughterPlan-User defined method
     *@param storageUnit 库存组织
     *@param period 期间
     *@return
     */
    public ArrayList getSlaughterPlan(StorageOrgUnitInfo storageUnit, PeriodInfo period) throws BOSException
    {
        try {
            return getController().getSlaughterPlan(getContext(), storageUnit, period);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}