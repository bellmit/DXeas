package com.kingdee.eas.farm.breed;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.breed.app.*;
import java.util.Map;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.farm.breed.comm.BreedBatchDetailInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public class BreedFacade extends AbstractBizCtrl implements IBreedFacade
{
    public BreedFacade()
    {
        super();
        registerInterface(IBreedFacade.class, this);
    }
    public BreedFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("70039994");
    }
    private BreedFacadeController getController() throws BOSException
    {
        return (BreedFacadeController)getBizController();
    }
    /**
     *根据仓库获得鸡舍信息-User defined method
     *@param warehouseId 仓库id
     *@return
     */
    public HenhouseInfo getWarehsHenhouse(String warehouseId) throws BOSException
    {
        try {
            return getController().getWarehsHenhouse(getContext(), warehouseId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得养殖批次信息-User defined method
     *@param batchID 批次ID
     *@param costObjectID 成本对象ID
     *@param bizDate 业务日期
     *@return
     */
    public BreedBatchDetailInfo getBreedBatchDetailInfos(String batchID, String costObjectID, Date bizDate) throws BOSException
    {
        try {
            return getController().getBreedBatchDetailInfos(getContext(), batchID, costObjectID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据鸡舍类别获得养殖规范信息-User defined method
     *@param henHouseType 鸡舍类别
     *@return
     */
    public BreedModelInfo getBreedModelByHouseType(String henHouseType) throws BOSException
    {
        try {
            return getController().getBreedModelByHouseType(getContext(), henHouseType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据成本对象获得对应的批次信息-User defined method
     *@param costObjectID 成本对象ID
     *@return
     */
    public BreedBatchInfo getBreedBatchInfoByCostObjID(String costObjectID) throws BOSException
    {
        try {
            return getController().getBreedBatchInfoByCostObjID(getContext(), costObjectID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取批次到当前日期的周龄和日龄-User defined method
     *@param batchID 批次ID
     *@param bizDate 业务日期
     *@return
     */
    public HashMap getBatchWeekages(String batchID, Date bizDate) throws BOSException
    {
        try {
            return getController().getBatchWeekages(getContext(), batchID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据周龄或得对应的养殖规范设置-User defined method
     *@param modelID modelid
     *@param week week  育成和产蛋鸡用
     *@param days 日龄 商品鸡用
     *@return
     */
    public BreedModelEntryInfo getBreedModelEntryInfo(String modelID, int week, int days) throws BOSException
    {
        try {
            return getController().getBreedModelEntryInfo(getContext(), modelID, week, days);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *校验指定的批次信息是否已经生成过日报了-User defined method
     *@param batchID batchID
     *@param henHouseType 鸡舍类别
     *@return
     */
    public boolean isBatchGeneratedDailyInfos(String batchID, String henHouseType) throws BOSException
    {
        try {
            return getController().isBatchGeneratedDailyInfos(getContext(), batchID, henHouseType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *商品鸡按照分录计算日龄-User defined method
     *@param breedBatchID 批次id
     *@param henhouseID 鸡舍ID
     *@param bizDate 业务日期
     *@return
     */
    public int getCommecialBatchDayage(String breedBatchID, String henhouseID, Date bizDate) throws BOSException
    {
        try {
            return getController().getCommecialBatchDayage(getContext(), breedBatchID, henhouseID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取指定批次的当前存栏量-User defined method
     *@param batchID 批次ID
     *@param bizDate 日期
     *@return
     */
    public Map getBatchBreedingStock(String batchID, Date bizDate) throws BOSException
    {
        try {
            return getController().getBatchBreedingStock(getContext(), batchID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *排除当前ID-User defined method
     *@param breedBatchID 批次ID
     *@param bizDate 业务日期
     *@param henhouseType 鸡舍类别
     *@param dailyID 当前日报id
     *@return
     */
    public boolean checkDateDailyState(String breedBatchID, Date bizDate, String henhouseType, String dailyID) throws BOSException
    {
        try {
            return getController().checkDateDailyState(getContext(), breedBatchID, bizDate, henhouseType, dailyID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得批次指定鸡舍的变更数-User defined method
     *@param batchID 批次ID
     *@param henhouseID 鸡舍ID
     *@param bizDate 业务日期
     *@param chikenType 鸡类别
     *@return
     */
    public int getBatchEntryEditInfos(String batchID, String henhouseID, Date bizDate, String chikenType) throws BOSException
    {
        try {
            return getController().getBatchEntryEditInfos(getContext(), batchID, henhouseID, bizDate, chikenType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取指定养殖场最近的成本对象-User defined method
     *@param farmID 养殖场ID
     *@return
     */
    public CostObjectInfo getFarmLatestCostObject(String farmID) throws BOSException
    {
        try {
            return getController().getFarmLatestCostObject(getContext(), farmID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *更新批次分录出栏状态和出栏数量-User defined method
     *@param batchID 批次ID
     *@param houseID 鸡舍ID
     *@param isAllOut 是否完全出栏
     *@param outQty 出栏数量
     *@param outDate 出栏日期
     *@return
     */
    public boolean updateBatchEntryOutState(String batchID, String houseID, boolean isAllOut, int outQty, Date outDate) throws BOSException
    {
        try {
            return getController().updateBatchEntryOutState(getContext(), batchID, houseID, isAllOut, outQty, outDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *更新指定商品鸡批次的出栏情况-User defined method
     *@param batchID 批次ID
     */
    public void updateBatchOutState(String batchID) throws BOSException
    {
        try {
            getController().updateBatchOutState(getContext(), batchID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *[description]按预计出栏的先后顺序 查询制定数量的商品鸡批次信息[%description][invokedemo][%invokedemo][returndesc]返回值的key为排序，1,2,3,4,5[%returndesc]-User defined method
     *@param bizDate 查询日期
     *@param breedDays 养殖周期
     *@param count 数量
     *@return
     */
    public Map getCCBatchAgeAndQty(Date bizDate, int breedDays, int count) throws BOSException
    {
        try {
            return getController().getCCBatchAgeAndQty(getContext(), bizDate, breedDays, count);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据养殖场和出栏日期获得 养殖批次-User defined method
     *@param stoOrgID 养殖场ID
     *@param outDate 出栏日期
     *@return
     */
    public BreedBatchInfo getBreedBatchByOrgAndOutDate(String stoOrgID, Date outDate) throws BOSException
    {
        try {
            return getController().getBreedBatchByOrgAndOutDate(getContext(), stoOrgID, outDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取指定批次 指定 鸡舍的转栏统计-User defined method
     *@param batchID 批次ID
     *@param henhouseID 鸡舍ID
     *@param bizDate 业务日期
     *@return
     */
    public int getBatchEntryTransQty(String batchID, String henhouseID, Date bizDate) throws BOSException
    {
        try {
            return getController().getBatchEntryTransQty(getContext(), batchID, henhouseID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取物料药残天数-User defined method
     *@param materialID 物料ID
     *@return
     */
    public int getMaterialResidueDays(String materialID) throws BOSException
    {
        try {
            return getController().getMaterialResidueDays(getContext(), materialID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得物料残留设置-User defined method
     *@param materialID 物料ID
     *@return
     */
    public ResidueSetInfo getMaterialResidueSet(String materialID) throws BOSException
    {
        try {
            return getController().getMaterialResidueSet(getContext(), materialID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]根据用户所在的养殖场 返回英文名称[%returndesc]-User defined method
     *@param user 用户
     *@return
     */
    public String getPermission(UserInfo user) throws BOSException
    {
        try {
            return getController().getPermission(getContext(), user);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得 库存组织对应的 养殖场-User defined method
     *@param storageID storageID
     *@return
     */
    public BreedStoorgSetInfo getStorageFarmInfo(String storageID) throws BOSException
    {
        try {
            return getController().getStorageFarmInfo(getContext(), storageID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}