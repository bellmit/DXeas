package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.farm.breed.business.app.*;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import java.util.List;
import com.kingdee.eas.farm.breed.comm.BatchTowerInhouseInfo;
import java.lang.String;
import com.kingdee.eas.farm.breed.comm.CCSendFodderStandard;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class BusinessBreedFacade extends AbstractBizCtrl implements IBusinessBreedFacade
{
    public BusinessBreedFacade()
    {
        super();
        registerInterface(IBusinessBreedFacade.class, this);
    }
    public BusinessBreedFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IBusinessBreedFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3717FD40");
    }
    private BusinessBreedFacadeController getController() throws BOSException
    {
        return (BusinessBreedFacadeController)getBizController();
    }
    /**
     *getFarmBreedDailyByDate-User defined method
     *@param farmID 养殖场ID
     *@param searchDate 查询日期
     *@return
     */
    public BreedBatchInfo getFarmBreedDailyByDate(String farmID, Date searchDate) throws BOSException
    {
        try {
            return getController().getFarmBreedDailyByDate(getContext(), farmID, searchDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取批次 鸡舍转栏汇总-User defined method
     *@param batchID 批次id
     *@param rptBeans rptBean 获取到的 转栏汇总 设置到 bean对应字段
     *@return
     */
    public List getBatchHouseAllAdjustInfos(String batchID, List rptBeans) throws BOSException
    {
        try {
            return getController().getBatchHouseAllAdjustInfos(getContext(), batchID, rptBeans);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *更新 免疫分录历史数据 日龄信息-User defined method
     */
    public void updateImmDaysOldData() throws BOSException
    {
        try {
            getController().updateImmDaysOldData(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得商品鸡的当日的入栏计划-User defined method
     */
    public void getCCBreedPlan() throws BOSException
    {
        try {
            getController().getCCBreedPlan(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取商品鸡送料规范-User defined method
     *@param companyNumber companyNumber
     *@return
     */
    public CCSendFodderStandard getCCSendFodderStandard(String companyNumber) throws BOSException
    {
        try {
            return getController().getCCSendFodderStandard(getContext(), companyNumber);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取鸡舍对应的料塔信息-User defined method
     *@param henhouseID henhouseID
     *@return
     */
    public WarehouseInfo getHenhouseTowerInfo(String henhouseID) throws BOSException
    {
        try {
            return getController().getHenhouseTowerInfo(getContext(), henhouseID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得养殖计划对应的 料塔 日龄明细信息-User defined method
     *@param breedPlanInfo breedPlanInfo
     *@return
     */
    public BatchTowerInhouseInfo getBreedPlanTowerInhouseInfo(CCBreedPlanInfo breedPlanInfo) throws BOSException
    {
        try {
            return getController().getBreedPlanTowerInhouseInfo(getContext(), breedPlanInfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}