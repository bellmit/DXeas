package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBEggTrayingBillEggEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBEggTrayingBillEggEntryInfo()
    {
        this("id");
    }
    protected AbstractBEggTrayingBillEggEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 落盘记录明细 's null property 
     */
    public com.kingdee.eas.farm.hatch.BEggTrayingBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.BEggTrayingBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.BEggTrayingBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:落盘记录明细's 种蛋来源property 
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
     * Object:落盘记录明细's 种蛋批次property 
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
     * Object:落盘记录明细's 上孵数量property 
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
     * Object:落盘记录明细's 死胚property 
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
     * Object:落盘记录明细's 活胚property 
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
     * Object:落盘记录明细's 其他损耗property 
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
     * Object:落盘记录明细's 照蛋活胚数property 
     */
    public int getCandingHealthEggQty()
    {
        return getInt("candingHealthEggQty");
    }
    public void setCandingHealthEggQty(int item)
    {
        setInt("candingHealthEggQty", item);
    }
    /**
     * Object:落盘记录明细's 落盘均重（g）property 
     */
    public java.math.BigDecimal getTrayingWeight()
    {
        return getBigDecimal("trayingWeight");
    }
    public void setTrayingWeight(java.math.BigDecimal item)
    {
        setBigDecimal("trayingWeight", item);
    }
    /**
     * Object: 落盘记录明细 's 孵化箱 property 
     */
    public com.kingdee.eas.farm.hatch.IncubatorInfo getHatchBox()
    {
        return (com.kingdee.eas.farm.hatch.IncubatorInfo)get("hatchBox");
    }
    public void setHatchBox(com.kingdee.eas.farm.hatch.IncubatorInfo item)
    {
        put("hatchBox", item);
    }
    /**
     * Object: 落盘记录明细 's 出雏箱 property 
     */
    public com.kingdee.eas.farm.hatch.HatchingBoxInfo getOutBabyBox()
    {
        return (com.kingdee.eas.farm.hatch.HatchingBoxInfo)get("outBabyBox");
    }
    public void setOutBabyBox(com.kingdee.eas.farm.hatch.HatchingBoxInfo item)
    {
        put("outBabyBox", item);
    }
    /**
     * Object: 落盘记录明细 's 出雏厅 property 
     */
    public com.kingdee.eas.farm.hatch.HatchHouseInfo getOutBabyHouse()
    {
        return (com.kingdee.eas.farm.hatch.HatchHouseInfo)get("outBabyHouse");
    }
    public void setOutBabyHouse(com.kingdee.eas.farm.hatch.HatchHouseInfo item)
    {
        put("outBabyHouse", item);
    }
    /**
     * Object: 落盘记录明细 's 上孵厅 property 
     */
    public com.kingdee.eas.farm.hatch.HatchHouseInfo getInBabyHouse()
    {
        return (com.kingdee.eas.farm.hatch.HatchHouseInfo)get("inBabyHouse");
    }
    public void setInBabyHouse(com.kingdee.eas.farm.hatch.HatchHouseInfo item)
    {
        put("inBabyHouse", item);
    }
    /**
     * Object:落盘记录明细's 混合上孵property 
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
     * Object: 落盘记录明细 's 片区 property 
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
     * Object: 落盘记录明细 's 供应商 property 
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
     * Object: 落盘记录明细 's 棚舍 property 
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
     * Object:落盘记录明细's 合格蛋类型property 
     */
    public com.kingdee.eas.farm.hatch.QcEggTypeEnum getEggType()
    {
        return com.kingdee.eas.farm.hatch.QcEggTypeEnum.getEnum(getInt("eggType"));
    }
    public void setEggType(com.kingdee.eas.farm.hatch.QcEggTypeEnum item)
    {
		if (item != null) {
        setInt("eggType", item.getValue());
		}
    }
    /**
     * Object:落盘记录明细's 晾晒臭蛋property 
     */
    public int getSunBadEggQty()
    {
        return getInt("sunBadEggQty");
    }
    public void setSunBadEggQty(int item)
    {
        setInt("sunBadEggQty", item);
    }
    /**
     * Object:落盘记录明细's 落盘臭蛋property 
     */
    public int getTrayingSadEggQty()
    {
        return getInt("trayingSadEggQty");
    }
    public void setTrayingSadEggQty(int item)
    {
        setInt("trayingSadEggQty", item);
    }
    /**
     * Object:落盘记录明细's 落盘活胚property 
     */
    public int getHealthTrayingEggQty()
    {
        return getInt("healthTrayingEggQty");
    }
    public void setHealthTrayingEggQty(int item)
    {
        setInt("healthTrayingEggQty", item);
    }
    /**
     * Object:落盘记录明细's 照蛋受精率property 
     */
    public java.math.BigDecimal getCandlingFertiRate()
    {
        return getBigDecimal("candlingFertiRate");
    }
    public void setCandlingFertiRate(java.math.BigDecimal item)
    {
        setBigDecimal("candlingFertiRate", item);
    }
    /**
     * Object: 落盘记录明细 's 批次 property 
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
     * Object:落盘记录明细's 品系类别property 
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
     * Object:落盘记录明细's 是否混合property 
     */
    public boolean isIshunhe()
    {
        return getBoolean("ishunhe");
    }
    public void setIshunhe(boolean item)
    {
        setBoolean("ishunhe", item);
    }
    /**
     * Object:落盘记录明细's 落盘破损蛋property 
     */
    public int getPsEggQty()
    {
        return getInt("psEggQty");
    }
    public void setPsEggQty(int item)
    {
        setInt("psEggQty", item);
    }
    /**
     * Object:落盘记录明细's 孵化华车号property 
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
     * Object:落盘记录明细's 总受精率(%)property 
     */
    public java.math.BigDecimal getAllFertilityRate()
    {
        return getBigDecimal("allFertilityRate");
    }
    public void setAllFertilityRate(java.math.BigDecimal item)
    {
        setBigDecimal("allFertilityRate", item);
    }
    /**
     * Object: 落盘记录明细 's 成本对象 property 
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
     * Object: 落盘记录明细 's 养殖户 property 
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
     * Object: 落盘记录明细 's 养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3389888F");
    }
}