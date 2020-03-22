package com.kingdee.eas.farm.rpt;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.rpt.app.CCProductPlanRptBean;
import com.kingdee.eas.farm.rpt.app.*;
import java.util.List;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.breed.HenhouseType;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public class CCProductPlanRptCommonFacade extends AbstractBizCtrl implements ICCProductPlanRptCommonFacade
{
    public CCProductPlanRptCommonFacade()
    {
        super();
        registerInterface(ICCProductPlanRptCommonFacade.class, this);
    }
    public CCProductPlanRptCommonFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICCProductPlanRptCommonFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("553402DB");
    }
    private CCProductPlanRptCommonFacadeController getController() throws BOSException
    {
        return (CCProductPlanRptCommonFacadeController)getBizController();
    }
    /**
     *获取rptbean符合条件的 养殖场-User defined method
     *@param param param
     *@return
     */
    public List getRptBeanStorageInfos(HashMap param) throws BOSException
    {
        try {
            return getController().getRptBeanStorageInfos(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得对应rptbean中的 养殖场的所有 符合条件的  计划 信息-User defined method
     *@param ccRptBean 包含养殖场信息的bean
     *@param inValidPlanIDs 无效的计划ID
     *@param filterBeginDate filterBeginDate
     *@param filterEndDate filterEndDate
     *@param breedDays breedDays
     *@return
     */
    public List getStoorgPlanInfo(CCProductPlanRptBean ccRptBean, List inValidPlanIDs, Date filterBeginDate, Date filterEndDate, int breedDays) throws BOSException
    {
        try {
            return getController().getStoorgPlanInfo(getContext(), ccRptBean, inValidPlanIDs, filterBeginDate, filterEndDate, breedDays);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取 养殖场 符合条件的批次信息-User defined method
     *@param ccRptBean ccRptBean
     *@param filterBeginDate filterBeginDate
     *@param filterEndDate filterEndDate
     *@param breedDays breedDays
     *@return
     */
    public List getStoorgBatchInfo(CCProductPlanRptBean ccRptBean, Date filterBeginDate, Date filterEndDate, int breedDays) throws BOSException
    {
        try {
            return getController().getStoorgBatchInfo(getContext(), ccRptBean, filterBeginDate, filterEndDate, breedDays);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCurrentBreedModelInfo-User defined method
     *@param houseType 鸡舍类别
     *@return
     */
    public BreedModelInfo getCurrentBreedModelInfo(HenhouseType houseType) throws BOSException
    {
        try {
            return getController().getCurrentBreedModelInfo(getContext(), houseType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *如果前一天填报了日报，则取日报对应的存栏量，如果没有则直接返回传入的理论存栏量-User defined method
     *@param stoorgID 鸡场ID
     *@param batchID 批次ID
     *@param bizdate 日期
     *@param henhouseID 鸡舍ID
     *@param henhouseIDs 组织成（'','',''）的格式的鸡舍id
     *@param theoryQty 当天理论存栏量
     *@return
     */
    public int getCCPredateHenqty(String stoorgID, String batchID, Date bizdate, String henhouseID, String henhouseIDs, int theoryQty) throws BOSException
    {
        try {
            return getController().getCCPredateHenqty(getContext(), stoorgID, batchID, bizdate, henhouseID, henhouseIDs, theoryQty);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取当天实际出栏量-User defined method
     *@param stoorgID 养殖场ID
     *@param batchID 批次ID
     *@param bizdate 业务日期
     *@param henhouseID 鸡舍ID
     *@param henhouseIDs 组织成（'','',''）的格式的鸡舍id
     *@return
     */
    public int getCCActualOutHenqty(String stoorgID, String batchID, Date bizdate, String henhouseID, String henhouseIDs) throws BOSException
    {
        try {
            return getController().getCCActualOutHenqty(getContext(), stoorgID, batchID, bizdate, henhouseID, henhouseIDs);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}