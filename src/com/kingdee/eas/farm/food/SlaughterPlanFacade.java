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
     *������׼ƻ���¼������-User defined method
     *@param fiscalPeriod ����ڼ�
     *@param ageOfDaysBeginFrom ��׼��ɱ����
     *@param ageOfDaysBeginTo ��׼��ɱ����
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
     *����Ʒ��˼ά�淶�л�ñ�׼����-User defined method
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
     *���ĳ�յ���ɱ����-User defined method
     *@param sroOrgUnitID ��ֳ��ID
     *@param henHouseID ����ID
     *@param breedBatchID ��ֳ����
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