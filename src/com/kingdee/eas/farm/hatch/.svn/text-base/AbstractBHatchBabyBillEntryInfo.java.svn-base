package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBHatchBabyBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBHatchBabyBillEntryInfo()
    {
        this("id");
    }
    protected AbstractBHatchBabyBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 出雏明细 's 单据头 property 
     */
    public com.kingdee.eas.farm.hatch.BHatchBabyBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.BHatchBabyBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.BHatchBabyBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 出雏明细 's 出雏箱 property 
     */
    public com.kingdee.eas.farm.hatch.HatchingBoxInfo getHatchingBox()
    {
        return (com.kingdee.eas.farm.hatch.HatchingBoxInfo)get("hatchingBox");
    }
    public void setHatchingBox(com.kingdee.eas.farm.hatch.HatchingBoxInfo item)
    {
        put("hatchingBox", item);
    }
    /**
     * Object:出雏明细's 备注property 
     */
    public String getDescription()
    {
        return getString("description");
    }
    public void setDescription(String item)
    {
        setString("description", item);
    }
    /**
     * Object: 出雏明细 's 孵化箱 property 
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
     * Object: 出雏明细 's 上孵厅 property 
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
     * Object:出雏明细's 上孵数量property 
     */
    public int getHatchQty()
    {
        return getInt("hatchQty");
    }
    public void setHatchQty(int item)
    {
        setInt("hatchQty", item);
    }
    /**
     * Object:出雏明细's 合格蛋类型property 
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
     * Object:出雏明细's 毛蛋property 
     */
    public int getMaoEggQty()
    {
        return getInt("maoEggQty");
    }
    public void setMaoEggQty(int item)
    {
        setInt("maoEggQty", item);
    }
    /**
     * Object:出雏明细's 种蛋来源类型property 
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
     * Object: 出雏明细 's 出雏厅 property 
     */
    public com.kingdee.eas.farm.hatch.HatchHouseInfo getOutHouse()
    {
        return (com.kingdee.eas.farm.hatch.HatchHouseInfo)get("outHouse");
    }
    public void setOutHouse(com.kingdee.eas.farm.hatch.HatchHouseInfo item)
    {
        put("outHouse", item);
    }
    /**
     * Object: 出雏明细 's 供应商 property 
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
     * Object: 出雏明细 's 片区 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo getOutAreaPP()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo)get("outAreaPP");
    }
    public void setOutAreaPP(com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo item)
    {
        put("outAreaPP", item);
    }
    /**
     * Object:出雏明细's 品系property 
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
     * Object:出雏明细's 照蛋活胚数property 
     */
    public int getZdhps()
    {
        return getInt("zdhps");
    }
    public void setZdhps(int item)
    {
        setInt("zdhps", item);
    }
    /**
     * Object:出雏明细's 落盘活胚数property 
     */
    public int getLphps()
    {
        return getInt("lphps");
    }
    public void setLphps(int item)
    {
        setInt("lphps", item);
    }
    /**
     * Object: 出雏明细 's 养殖户 property 
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
     * Object: 出雏明细 's 养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFerm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("ferm");
    }
    public void setFerm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("ferm", item);
    }
    /**
     * Object: 出雏明细 's 成本对象 property 
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
     * Object:出雏明细's 健母雏property 
     */
    public int getHealthQty()
    {
        return getInt("healthQty");
    }
    public void setHealthQty(int item)
    {
        setInt("healthQty", item);
    }
    /**
     * Object:出雏明细's 二母雏property 
     */
    public int getHealthQty2()
    {
        return getInt("healthQty2");
    }
    public void setHealthQty2(int item)
    {
        setInt("healthQty2", item);
    }
    /**
     * Object:出雏明细's 死雏property 
     */
    public int getDeadGermQty()
    {
        return getInt("deadGermQty");
    }
    public void setDeadGermQty(int item)
    {
        setInt("deadGermQty", item);
    }
    /**
     * Object:出雏明细's 弱母雏property 
     */
    public int getGermQty()
    {
        return getInt("germQty");
    }
    public void setGermQty(int item)
    {
        setInt("germQty", item);
    }
    /**
     * Object:出雏明细's 累计出雏property 
     */
    public int getAllOutQty()
    {
        return getInt("allOutQty");
    }
    public void setAllOutQty(int item)
    {
        setInt("allOutQty", item);
    }
    /**
     * Object: 出雏明细 's 种禽批次 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getStrockbatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("strockbatch");
    }
    public void setStrockbatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("strockbatch", item);
    }
    /**
     * Object:出雏明细's 全蛋健母率property 
     */
    public java.math.BigDecimal getHealthRate()
    {
        return getBigDecimal("healthRate");
    }
    public void setHealthRate(java.math.BigDecimal item)
    {
        setBigDecimal("healthRate", item);
    }
    /**
     * Object:出雏明细's 落盘健雏率property 
     */
    public java.math.BigDecimal getLphralthRate()
    {
        return getBigDecimal("lphralthRate");
    }
    public void setLphralthRate(java.math.BigDecimal item)
    {
        setBigDecimal("lphralthRate", item);
    }
    /**
     * Object:出雏明细's 公雏property 
     */
    public int getMaleQty()
    {
        return getInt("maleQty");
    }
    public void setMaleQty(int item)
    {
        setInt("maleQty", item);
    }
    /**
     * Object:出雏明细's 母雏property 
     */
    public int getFemaleQty()
    {
        return getInt("femaleQty");
    }
    public void setFemaleQty(int item)
    {
        setInt("femaleQty", item);
    }
    /**
     * Object:出雏明细's 毛蛋率property 
     */
    public java.math.BigDecimal getMaoEggRate()
    {
        return getBigDecimal("maoEggRate");
    }
    public void setMaoEggRate(java.math.BigDecimal item)
    {
        setBigDecimal("maoEggRate", item);
    }
    /**
     * Object:出雏明细's 弱母率property 
     */
    public java.math.BigDecimal getGermRate()
    {
        return getBigDecimal("germRate");
    }
    public void setGermRate(java.math.BigDecimal item)
    {
        setBigDecimal("germRate", item);
    }
    /**
     * Object:出雏明细's 蛋雏比property 
     */
    public java.math.BigDecimal getEggBabyRate()
    {
        return getBigDecimal("eggBabyRate");
    }
    public void setEggBabyRate(java.math.BigDecimal item)
    {
        setBigDecimal("eggBabyRate", item);
    }
    /**
     * Object:出雏明细's 公母比property 
     */
    public java.math.BigDecimal getMaleFemaleRate()
    {
        return getBigDecimal("maleFemaleRate");
    }
    public void setMaleFemaleRate(java.math.BigDecimal item)
    {
        setBigDecimal("maleFemaleRate", item);
    }
    /**
     * Object:出雏明细's 可售公雏property 
     */
    public int getKsMaleQty()
    {
        return getInt("ksMaleQty");
    }
    public void setKsMaleQty(int item)
    {
        setInt("ksMaleQty", item);
    }
    /**
     * Object:出雏明细's 公鸡公雏property 
     */
    public int getGjMaleQty()
    {
        return getInt("gjMaleQty");
    }
    public void setGjMaleQty(int item)
    {
        setInt("gjMaleQty", item);
    }
    /**
     * Object:出雏明细's 损耗差异property 
     */
    public java.math.BigDecimal getLossDiff()
    {
        return getBigDecimal("lossDiff");
    }
    public void setLossDiff(java.math.BigDecimal item)
    {
        setBigDecimal("lossDiff", item);
    }
    /**
     * Object:出雏明细's 赠品property 
     */
    public java.math.BigDecimal getGifts()
    {
        return getBigDecimal("gifts");
    }
    public void setGifts(java.math.BigDecimal item)
    {
        setBigDecimal("gifts", item);
    }
    /**
     * Object:出雏明细's 周龄property 
     */
    public int getWeek()
    {
        return getInt("week");
    }
    public void setWeek(int item)
    {
        setInt("week", item);
    }
    /**
     * Object:出雏明细's 日龄property 
     */
    public int getDay()
    {
        return getInt("day");
    }
    public void setDay(int item)
    {
        setInt("day", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("295C9349");
    }
}