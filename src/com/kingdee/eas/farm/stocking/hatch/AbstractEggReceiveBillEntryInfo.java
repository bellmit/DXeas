package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggReceiveBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractEggReceiveBillEntryInfo()
    {
        this("id");
    }
    protected AbstractEggReceiveBillEntryInfo(String pkField)
    {
        super(pkField);
        put("PickDetail", new com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryPickDetailCollection());
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 仓库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("warehouse");
    }
    public void setWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("warehouse", item);
    }
    /**
     * Object: 分录 's 养殖户 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: 分录 's 养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: 分录 's 批次 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getStockingBatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("stockingBatch");
    }
    public void setStockingBatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("stockingBatch", item);
    }
    /**
     * Object:分录's 破蛋property 
     */
    public java.math.BigDecimal getBrokenQty()
    {
        return getBigDecimal("brokenQty");
    }
    public void setBrokenQty(java.math.BigDecimal item)
    {
        setBigDecimal("brokenQty", item);
    }
    /**
     * Object:分录's 总蛋property 
     */
    public java.math.BigDecimal getAllQty()
    {
        return getBigDecimal("allQty");
    }
    public void setAllQty(java.math.BigDecimal item)
    {
        setBigDecimal("allQty", item);
    }
    /**
     * Object:分录's 统蛋property 
     */
    public java.math.BigDecimal getEffectAllQty()
    {
        return getBigDecimal("effectAllQty");
    }
    public void setEffectAllQty(java.math.BigDecimal item)
    {
        setBigDecimal("effectAllQty", item);
    }
    /**
     * Object:分录's 合格一1级property 
     */
    public java.math.BigDecimal getQc1lv1Qty()
    {
        return getBigDecimal("qc1lv1Qty");
    }
    public void setQc1lv1Qty(java.math.BigDecimal item)
    {
        setBigDecimal("qc1lv1Qty", item);
    }
    /**
     * Object:分录's 合格一2级property 
     */
    public java.math.BigDecimal getQc1lv2Qty()
    {
        return getBigDecimal("qc1lv2Qty");
    }
    public void setQc1lv2Qty(java.math.BigDecimal item)
    {
        setBigDecimal("qc1lv2Qty", item);
    }
    /**
     * Object:分录's 合格二2级property 
     */
    public java.math.BigDecimal getQc2lv2Qty()
    {
        return getBigDecimal("qc2lv2Qty");
    }
    public void setQc2lv2Qty(java.math.BigDecimal item)
    {
        setBigDecimal("qc2lv2Qty", item);
    }
    /**
     * Object:分录's 合格二1级property 
     */
    public java.math.BigDecimal getQc2lv1Qty()
    {
        return getBigDecimal("qc2lv1Qty");
    }
    public void setQc2lv1Qty(java.math.BigDecimal item)
    {
        setBigDecimal("qc2lv1Qty", item);
    }
    /**
     * Object:分录's 合格三1级property 
     */
    public java.math.BigDecimal getQc3lv1Qty()
    {
        return getBigDecimal("qc3lv1Qty");
    }
    public void setQc3lv1Qty(java.math.BigDecimal item)
    {
        setBigDecimal("qc3lv1Qty", item);
    }
    /**
     * Object:分录's 合格四1级property 
     */
    public java.math.BigDecimal getQc4lv1Qty()
    {
        return getBigDecimal("qc4lv1Qty");
    }
    public void setQc4lv1Qty(java.math.BigDecimal item)
    {
        setBigDecimal("qc4lv1Qty", item);
    }
    /**
     * Object:分录's 合格五2级property 
     */
    public java.math.BigDecimal getQc5lv2Qty()
    {
        return getBigDecimal("qc5lv2Qty");
    }
    public void setQc5lv2Qty(java.math.BigDecimal item)
    {
        setBigDecimal("qc5lv2Qty", item);
    }
    /**
     * Object:分录's 合格六2级property 
     */
    public java.math.BigDecimal getQc6lv2Qty()
    {
        return getBigDecimal("qc6lv2Qty");
    }
    public void setQc6lv2Qty(java.math.BigDecimal item)
    {
        setBigDecimal("qc6lv2Qty", item);
    }
    /**
     * Object:分录's 菜蛋property 
     */
    public java.math.BigDecimal getGreensQty()
    {
        return getBigDecimal("greensQty");
    }
    public void setGreensQty(java.math.BigDecimal item)
    {
        setBigDecimal("greensQty", item);
    }
    /**
     * Object:分录's 脏蛋property 
     */
    public java.math.BigDecimal getDirtyQty()
    {
        return getBigDecimal("dirtyQty");
    }
    public void setDirtyQty(java.math.BigDecimal item)
    {
        setBigDecimal("dirtyQty", item);
    }
    /**
     * Object:分录's 双黄蛋property 
     */
    public java.math.BigDecimal getDoubleQty()
    {
        return getBigDecimal("doubleQty");
    }
    public void setDoubleQty(java.math.BigDecimal item)
    {
        setBigDecimal("doubleQty", item);
    }
    /**
     * Object:分录's 畸形蛋property 
     */
    public java.math.BigDecimal getMutantQty()
    {
        return getBigDecimal("mutantQty");
    }
    public void setMutantQty(java.math.BigDecimal item)
    {
        setBigDecimal("mutantQty", item);
    }
    /**
     * Object:分录's 破单黄property 
     */
    public java.math.BigDecimal getBrokenSingeQty()
    {
        return getBigDecimal("brokenSingeQty");
    }
    public void setBrokenSingeQty(java.math.BigDecimal item)
    {
        setBigDecimal("brokenSingeQty", item);
    }
    /**
     * Object:分录's 流蛋property 
     */
    public java.math.BigDecimal getFlowQty()
    {
        return getBigDecimal("flowQty");
    }
    public void setFlowQty(java.math.BigDecimal item)
    {
        setBigDecimal("flowQty", item);
    }
    /**
     * Object:分录's 破双黄property 
     */
    public java.math.BigDecimal getBrokenDoubleQty()
    {
        return getBigDecimal("brokenDoubleQty");
    }
    public void setBrokenDoubleQty(java.math.BigDecimal item)
    {
        setBigDecimal("brokenDoubleQty", item);
    }
    /**
     * Object:分录's 合格率农户property 
     */
    public java.math.BigDecimal getQcRateFarmer()
    {
        return getBigDecimal("qcRateFarmer");
    }
    public void setQcRateFarmer(java.math.BigDecimal item)
    {
        setBigDecimal("qcRateFarmer", item);
    }
    /**
     * Object:分录's 合格率车间property 
     */
    public java.math.BigDecimal getQcRateWorkshop()
    {
        return getBigDecimal("qcRateWorkshop");
    }
    public void setQcRateWorkshop(java.math.BigDecimal item)
    {
        setBigDecimal("qcRateWorkshop", item);
    }
    /**
     * Object:分录's 隐纹率property 
     */
    public java.math.BigDecimal getHiddenRate()
    {
        return getBigDecimal("hiddenRate");
    }
    public void setHiddenRate(java.math.BigDecimal item)
    {
        setBigDecimal("hiddenRate", item);
    }
    /**
     * Object:分录's 破损率property 
     */
    public java.math.BigDecimal getBrokenRate()
    {
        return getBigDecimal("brokenRate");
    }
    public void setBrokenRate(java.math.BigDecimal item)
    {
        setBigDecimal("brokenRate", item);
    }
    /**
     * Object: 分录 's 物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object: 分录 's 成本对象 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getCostItem()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("costItem");
    }
    public void setCostItem(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("costItem", item);
    }
    /**
     * Object: 分录 's 内部养殖场 property 
     */
    public com.kingdee.eas.farm.breed.BreedStoorgSetInfo getInternalFarm()
    {
        return (com.kingdee.eas.farm.breed.BreedStoorgSetInfo)get("internalFarm");
    }
    public void setInternalFarm(com.kingdee.eas.farm.breed.BreedStoorgSetInfo item)
    {
        put("internalFarm", item);
    }
    /**
     * Object: 分录 's 内部养殖批次 property 
     */
    public com.kingdee.eas.farm.breed.ParentBreedBatchInfo getInternalBatch()
    {
        return (com.kingdee.eas.farm.breed.ParentBreedBatchInfo)get("internalBatch");
    }
    public void setInternalBatch(com.kingdee.eas.farm.breed.ParentBreedBatchInfo item)
    {
        put("internalBatch", item);
    }
    /**
     * Object: 分录 's 供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object: 分录 's 计量单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("unit");
    }
    public void setUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("unit", item);
    }
    /**
     * Object:分录's 统计类型property 
     */
    public com.kingdee.eas.farm.stocking.hatch.StatisticsType getStatisticsType()
    {
        return com.kingdee.eas.farm.stocking.hatch.StatisticsType.getEnum(getInt("statisticsType"));
    }
    public void setStatisticsType(com.kingdee.eas.farm.stocking.hatch.StatisticsType item)
    {
		if (item != null) {
        setInt("statisticsType", item.getValue());
		}
    }
    /**
     * Object: 分录 's 挑选明细 property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryPickDetailCollection getPickDetail()
    {
        return (com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryPickDetailCollection)get("PickDetail");
    }
    /**
     * Object:分录's 周龄property 
     */
    public String getWeekAge()
    {
        return getString("weekAge");
    }
    public void setWeekAge(String item)
    {
        setString("weekAge", item);
    }
    /**
     * Object:分录's 日龄property 
     */
    public int getDayAge()
    {
        return getInt("dayAge");
    }
    public void setDayAge(int item)
    {
        setInt("dayAge", item);
    }
    /**
     * Object:分录's 是否转正property 
     */
    public boolean isIsFormal()
    {
        return getBoolean("isFormal");
    }
    public void setIsFormal(boolean item)
    {
        setBoolean("isFormal", item);
    }
    /**
     * Object:分录's 交蛋日期property 
     */
    public java.util.Date getSendDate()
    {
        return getDate("sendDate");
    }
    public void setSendDate(java.util.Date item)
    {
        setDate("sendDate", item);
    }
    /**
     * Object:分录's 报送数量property 
     */
    public java.math.BigDecimal getSendAllQty()
    {
        return getBigDecimal("sendAllQty");
    }
    public void setSendAllQty(java.math.BigDecimal item)
    {
        setBigDecimal("sendAllQty", item);
    }
    /**
     * Object:分录's 差异数量property 
     */
    public java.math.BigDecimal getDiffQty()
    {
        return getBigDecimal("diffQty");
    }
    public void setDiffQty(java.math.BigDecimal item)
    {
        setBigDecimal("diffQty", item);
    }
    /**
     * Object: 分录 's 棚舍 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("house", item);
    }
    /**
     * Object:分录's 区域property 
     */
    public String getFarmerGroup()
    {
        return getString("farmerGroup");
    }
    public void setFarmerGroup(String item)
    {
        setString("farmerGroup", item);
    }
    /**
     * Object:分录's 批次property 
     */
    public String getLot()
    {
        return getString("lot");
    }
    public void setLot(String item)
    {
        setString("lot", item);
    }
    /**
     * Object:分录's 结算单IDproperty 
     */
    public String getSettleBillID()
    {
        return getString("settleBillID");
    }
    public void setSettleBillID(String item)
    {
        setString("settleBillID", item);
    }
    /**
     * Object:分录's 是否存在下游单据property 
     */
    public boolean isIsExistDownBill()
    {
        return getBoolean("isExistDownBill");
    }
    public void setIsExistDownBill(boolean item)
    {
        setBoolean("isExistDownBill", item);
    }
    /**
     * Object:分录's 品系property 
     */
    public com.kingdee.eas.farm.stocking.hatch.GenderType getGenderType()
    {
        return com.kingdee.eas.farm.stocking.hatch.GenderType.getEnum(getString("genderType"));
    }
    public void setGenderType(com.kingdee.eas.farm.stocking.hatch.GenderType item)
    {
		if (item != null) {
        setString("genderType", item.getValue());
		}
    }
    /**
     * Object:分录's 特小蛋property 
     */
    public java.math.BigDecimal getTinyEggQty()
    {
        return getBigDecimal("tinyEggQty");
    }
    public void setTinyEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("tinyEggQty", item);
    }
    /**
     * Object:分录's 畸形property 
     */
    public java.math.BigDecimal getWrongSharpEgg()
    {
        return getBigDecimal("wrongSharpEgg");
    }
    public void setWrongSharpEgg(java.math.BigDecimal item)
    {
        setBigDecimal("wrongSharpEgg", item);
    }
    /**
     * Object:分录's 蛋汤property 
     */
    public java.math.BigDecimal getEggLiquid()
    {
        return getBigDecimal("eggLiquid");
    }
    public void setEggLiquid(java.math.BigDecimal item)
    {
        setBigDecimal("eggLiquid", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E9378F03");
    }
}