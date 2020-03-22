package com.kingdee.eas.farm.food;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.bos.Context;
import java.util.LinkedHashMap;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.lang.String;
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class SlaughterPlanFacade extends AbstractBizCtrl implements ISlaughterPlanFacade
{
    public SlaughterPlanFacade()
    {
        super();
        registerInterface(ISlaughterPlanFacade.class, this);
    }
    public SlaughterPlanFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ISlaughterPlanFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CFD4080C");
    }
    private SlaughterPlanFacadeController getController() throws BOSException
    {
        return (SlaughterPlanFacadeController)getBizController();
    }
    /**
     *获得屠宰计划分录的数据-User defined method
     *@param fiscalPeriod 会计期间
     *@param ageOfDaysBeginFrom 标准宰杀日龄
     *@param ageOfDaysBeginTo 标准宰杀日龄
     *@return
     */
    public LinkedHashMap getSlaughterPlan(PeriodInfo fiscalPeriod, int ageOfDaysBeginFrom, int ageOfDaysBeginTo) throws BOSException, EASBizException
    {
        try {
            return getController().getSlaughterPlan(getContext(), fiscalPeriod, ageOfDaysBeginFrom, ageOfDaysBeginTo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *在商品鸡思维规范中获得标准死淘-User defined method
     *@return
     */
    public Map getCullAndDeathFromFeedModel() throws BOSException, EASBizException
    {
        try {
            return getController().getCullAndDeathFromFeedModel(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得某日的宰杀数量-User defined method
     *@param sroOrgUnitID 养殖场ID
     *@param henHouseID 鸡舍ID
     *@param breedBatchID 养殖批次
     *@return
     */
    public String[] getSlaughterQtyInOneDay(String sroOrgUnitID, String henHouseID, String breedBatchID) throws BOSException, EASBizException
    {
        try {
            return getController().getSlaughterQtyInOneDay(getContext(), sroOrgUnitID, henHouseID, breedBatchID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}