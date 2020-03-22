package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggSettleBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractEggSettleBillEntryInfo()
    {
        this("id");
    }
    protected AbstractEggSettleBillEntryInfo(String pkField)
    {
        super(pkField);
        put("PriceEntry", new com.kingdee.eas.farm.stocking.hatch.EggSettleBillEntryPriceEntryCollection());
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo item)
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
     * Object:分录's 结算数量 property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:分录's 单价property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    /**
     * Object:分录's 金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:分录's 报送日期property 
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
     * Object:分录's 蛋品价格来源property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggPriceType getEggPriceType()
    {
        return com.kingdee.eas.farm.stocking.hatch.EggPriceType.getEnum(getInt("eggPriceType"));
    }
    public void setEggPriceType(com.kingdee.eas.farm.stocking.hatch.EggPriceType item)
    {
		if (item != null) {
        setInt("eggPriceType", item.getValue());
		}
    }
    /**
     * Object: 分录 's 价格明细 property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggSettleBillEntryPriceEntryCollection getPriceEntry()
    {
        return (com.kingdee.eas.farm.stocking.hatch.EggSettleBillEntryPriceEntryCollection)get("PriceEntry");
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
     * Object: 分录 's 结算项目 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo getSettleItem()
    {
        return (com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo)get("settleItem");
    }
    public void setSettleItem(com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo item)
    {
        put("settleItem", item);
    }
    /**
     * Object: 分录 's 内部棚舍 property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getInternalHouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("internalHouse");
    }
    public void setInternalHouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("internalHouse", item);
    }
    /**
     * Object:分录's 枚数property 
     */
    public int getNum()
    {
        return getInt("num");
    }
    public void setNum(int item)
    {
        setInt("num", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("220F1645");
    }
}