package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBEggCandlingBillEggEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBEggCandlingBillEggEntryInfo()
    {
        this("id");
    }
    protected AbstractBEggCandlingBillEggEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 照蛋明细 's null property 
     */
    public com.kingdee.eas.farm.hatch.BEggCandlingBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.BEggCandlingBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.BEggCandlingBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:照蛋明细's 种蛋来源property 
     */
    public com.kingdee.eas.farm.hatch.EggSourceType getEggSourceType()
    {
        return com.kingdee.eas.farm.hatch.EggSourceType.getEnum(getInt("eggSourceType"));
    }
    public void setEggSourceType(com.kingdee.eas.farm.hatch.EggSourceType item)
    {
		if (item != null) {
        setInt("eggSourceType", item.getValue());
		}
    }
    /**
     * Object: 照蛋明细 's 内部养殖场 property 
     */
    public com.kingdee.eas.farm.breed.BreedStoorgSetInfo getFarm()
    {
        return (com.kingdee.eas.farm.breed.BreedStoorgSetInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.breed.BreedStoorgSetInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:照蛋明细's 种蛋批次property 
     */
    public String getEggLog()
    {
        return getString("eggLog");
    }
    public void setEggLog(String item)
    {
        setString("eggLog", item);
    }
    /**
     * Object:照蛋明细's 上孵数量property 
     */
    public int getEggQty()
    {
        return getInt("eggQty");
    }
    public void setEggQty(int item)
    {
        setInt("eggQty", item);
    }
    /**
     * Object:照蛋明细's 无精蛋property 
     */
    public int getNoFertileEggQty()
    {
        return getInt("noFertileEggQty");
    }
    public void setNoFertileEggQty(int item)
    {
        setInt("noFertileEggQty", item);
    }
    /**
     * Object:照蛋明细's 死胚property 
     */
    public int getAddleEggQty()
    {
        return getInt("addleEggQty");
    }
    public void setAddleEggQty(int item)
    {
        setInt("addleEggQty", item);
    }
    /**
     * Object:照蛋明细's 活胚property 
     */
    public int getHealthEggQty()
    {
        return getInt("healthEggQty");
    }
    public void setHealthEggQty(int item)
    {
        setInt("healthEggQty", item);
    }
    /**
     * Object:照蛋明细's 破损property 
     */
    public int getBrokenEggQty()
    {
        return getInt("brokenEggQty");
    }
    public void setBrokenEggQty(int item)
    {
        setInt("brokenEggQty", item);
    }
    /**
     * Object:照蛋明细's 臭蛋property 
     */
    public int getRottenEggQty()
    {
        return getInt("rottenEggQty");
    }
    public void setRottenEggQty(int item)
    {
        setInt("rottenEggQty", item);
    }
    /**
     * Object:照蛋明细's 其他损耗property 
     */
    public int getOtherEggQty()
    {
        return getInt("otherEggQty");
    }
    public void setOtherEggQty(int item)
    {
        setInt("otherEggQty", item);
    }
    /**
     * Object: 照蛋明细 's 养殖户 property 
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
     * Object: 照蛋明细 's 外部养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getOutFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("outFarm");
    }
    public void setOutFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("outFarm", item);
    }
    /**
     * Object: 照蛋明细 's 供应商 property 
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
     * Object: 照蛋明细 's 种蛋 property 
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
     * Object: 照蛋明细 's 放养批次 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getOutBatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("outBatch");
    }
    public void setOutBatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("outBatch", item);
    }
    /**
     * Object: 照蛋明细 's 种禽批次 property 
     */
    public com.kingdee.eas.farm.breed.ParentBreedBatchInfo getBreedBatch()
    {
        return (com.kingdee.eas.farm.breed.ParentBreedBatchInfo)get("breedBatch");
    }
    public void setBreedBatch(com.kingdee.eas.farm.breed.ParentBreedBatchInfo item)
    {
        put("breedBatch", item);
    }
    /**
     * Object:照蛋明细's 散黄property 
     */
    public int getBrokenYolkQty()
    {
        return getInt("brokenYolkQty");
    }
    public void setBrokenYolkQty(int item)
    {
        setInt("brokenYolkQty", item);
    }
    /**
     * Object:照蛋明细's 受精率(%)property 
     */
    public java.math.BigDecimal getFertilityRate()
    {
        return getBigDecimal("fertilityRate");
    }
    public void setFertilityRate(java.math.BigDecimal item)
    {
        setBigDecimal("fertilityRate", item);
    }
    /**
     * Object: 照蛋明细 's 栋舍 property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getHouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("house", item);
    }
    /**
     * Object: 照蛋明细 's 放养棚舍 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getOutHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("outHouse");
    }
    public void setOutHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("outHouse", item);
    }
    /**
     * Object: 照蛋明细 's 孵化厅 property 
     */
    public com.kingdee.eas.farm.hatch.HatchHouseInfo getHatchHouse()
    {
        return (com.kingdee.eas.farm.hatch.HatchHouseInfo)get("hatchHouse");
    }
    public void setHatchHouse(com.kingdee.eas.farm.hatch.HatchHouseInfo item)
    {
        put("hatchHouse", item);
    }
    /**
     * Object:照蛋明细's 合格一1级property 
     */
    public int getQc1lv1Qty()
    {
        return getInt("qc1lv1Qty");
    }
    public void setQc1lv1Qty(int item)
    {
        setInt("qc1lv1Qty", item);
    }
    /**
     * Object:照蛋明细's 合格一2级property 
     */
    public int getQc1lv2Qty()
    {
        return getInt("qc1lv2Qty");
    }
    public void setQc1lv2Qty(int item)
    {
        setInt("qc1lv2Qty", item);
    }
    /**
     * Object:照蛋明细's 合格二1级property 
     */
    public int getQc2lv1Qty()
    {
        return getInt("qc2lv1Qty");
    }
    public void setQc2lv1Qty(int item)
    {
        setInt("qc2lv1Qty", item);
    }
    /**
     * Object:照蛋明细's 合格二2级property 
     */
    public int getQc2lv2Qty()
    {
        return getInt("qc2lv2Qty");
    }
    public void setQc2lv2Qty(int item)
    {
        setInt("qc2lv2Qty", item);
    }
    /**
     * Object:照蛋明细's 合格三property 
     */
    public int getQc3lv1Qty()
    {
        return getInt("qc3lv1Qty");
    }
    public void setQc3lv1Qty(int item)
    {
        setInt("qc3lv1Qty", item);
    }
    /**
     * Object:照蛋明细's 合格四property 
     */
    public int getQc4lv1Qty()
    {
        return getInt("qc4lv1Qty");
    }
    public void setQc4lv1Qty(int item)
    {
        setInt("qc4lv1Qty", item);
    }
    /**
     * Object:照蛋明细's 合格五property 
     */
    public int getQc5lv1Qty()
    {
        return getInt("qc5lv1Qty");
    }
    public void setQc5lv1Qty(int item)
    {
        setInt("qc5lv1Qty", item);
    }
    /**
     * Object:照蛋明细's 合格六property 
     */
    public int getQc6lv1Qty()
    {
        return getInt("qc6lv1Qty");
    }
    public void setQc6lv1Qty(int item)
    {
        setInt("qc6lv1Qty", item);
    }
    /**
     * Object: 照蛋明细 's 孵化箱 property 
     */
    public com.kingdee.eas.farm.hatch.IncubatorInfo getIncubator()
    {
        return (com.kingdee.eas.farm.hatch.IncubatorInfo)get("incubator");
    }
    public void setIncubator(com.kingdee.eas.farm.hatch.IncubatorInfo item)
    {
        put("incubator", item);
    }
    /**
     * Object:照蛋明细's 孵化车号property 
     */
    public String getHatchCarNum()
    {
        return getString("hatchCarNum");
    }
    public void setHatchCarNum(String item)
    {
        setString("hatchCarNum", item);
    }
    /**
     * Object: 照蛋明细 's 片区 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo getOutArea()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo)get("outArea");
    }
    public void setOutArea(com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo item)
    {
        put("outArea", item);
    }
    /**
     * Object:照蛋明细's 是否混合property 
     */
    public boolean isIsMix()
    {
        return getBoolean("isMix");
    }
    public void setIsMix(boolean item)
    {
        setBoolean("isMix", item);
    }
    /**
     * Object:照蛋明细's 合格蛋类型property 
     */
    public com.kingdee.eas.farm.hatch.QcEggTypeEnum getQcEggType()
    {
        return com.kingdee.eas.farm.hatch.QcEggTypeEnum.getEnum(getInt("qcEggType"));
    }
    public void setQcEggType(com.kingdee.eas.farm.hatch.QcEggTypeEnum item)
    {
		if (item != null) {
        setInt("qcEggType", item.getValue());
		}
    }
    /**
     * Object:照蛋明细's 周龄property 
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
     * Object:照蛋明细's 日龄property 
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
     * Object:照蛋明细's 是否转正property 
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
     * Object:照蛋明细's 差异数量property 
     */
    public int getDiffEggQty()
    {
        return getInt("diffEggQty");
    }
    public void setDiffEggQty(int item)
    {
        setInt("diffEggQty", item);
    }
    /**
     * Object:照蛋明细's 死胚率(%)property 
     */
    public java.math.BigDecimal getAddleEggRate()
    {
        return getBigDecimal("addleEggRate");
    }
    public void setAddleEggRate(java.math.BigDecimal item)
    {
        setBigDecimal("addleEggRate", item);
    }
    /**
     * Object:照蛋明细's 品系property 
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
     * Object:照蛋明细's 产蛋时间property 
     */
    public java.util.Date getEggDate()
    {
        return getDate("eggDate");
    }
    public void setEggDate(java.util.Date item)
    {
        setDate("eggDate", item);
    }
    /**
     * Object:照蛋明细's 落盘活胚property 
     */
    public int getLphealthEggQty()
    {
        return getInt("lphealthEggQty");
    }
    public void setLphealthEggQty(int item)
    {
        setInt("lphealthEggQty", item);
    }
    /**
     * Object:照蛋明细's 亏损数property 
     */
    public java.math.BigDecimal getLossQty()
    {
        return getBigDecimal("lossQty");
    }
    public void setLossQty(java.math.BigDecimal item)
    {
        setBigDecimal("lossQty", item);
    }
    /**
     * Object:照蛋明细's 臭蛋率(%)property 
     */
    public java.math.BigDecimal getRottenRate()
    {
        return getBigDecimal("rottenRate");
    }
    public void setRottenRate(java.math.BigDecimal item)
    {
        setBigDecimal("rottenRate", item);
    }
    /**
     * Object:照蛋明细's 破损率(%)property 
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
     * Object: 照蛋明细 's 成本对象 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("CostObject");
    }
    public void setCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("CostObject", item);
    }
    /**
     * Object: 照蛋明细 's 出雏箱 property 
     */
    public com.kingdee.eas.farm.hatch.HatchingBoxInfo getHatchsBox()
    {
        return (com.kingdee.eas.farm.hatch.HatchingBoxInfo)get("hatchsBox");
    }
    public void setHatchsBox(com.kingdee.eas.farm.hatch.HatchingBoxInfo item)
    {
        put("hatchsBox", item);
    }
    /**
     * Object:照蛋明细's 活胚率(%)property 
     */
    public java.math.BigDecimal getLiveEggRate()
    {
        return getBigDecimal("liveEggRate");
    }
    public void setLiveEggRate(java.math.BigDecimal item)
    {
        setBigDecimal("liveEggRate", item);
    }
    /**
     * Object:照蛋明细's 无精蛋率(%)property 
     */
    public java.math.BigDecimal getNoFertileEggRate()
    {
        return getBigDecimal("noFertileEggRate");
    }
    public void setNoFertileEggRate(java.math.BigDecimal item)
    {
        setBigDecimal("noFertileEggRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3205072F");
    }
}