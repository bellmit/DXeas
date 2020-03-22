package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBEggCandlingBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBEggCandlingBillInfo()
    {
        this("id");
    }
    protected AbstractBEggCandlingBillInfo(String pkField)
    {
        super(pkField);
        put("EggEntries", new com.kingdee.eas.farm.hatch.BEggCandlingBillEggEntryCollection());
        put("AreaSumEntry", new com.kingdee.eas.farm.hatch.BEggCandlingBillAreaSumEntryCollection());
        put("FarmerSumEntry", new com.kingdee.eas.farm.hatch.BEggCandlingBillFarmerSumEntryCollection());
    }
    /**
     * Object:照蛋记录单's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:照蛋记录单's 审核日期property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object:照蛋记录单's 状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: 照蛋记录单 's 孵化场 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBaseDataInfo getHatchFactory()
    {
        return (com.kingdee.eas.farm.hatch.HatchBaseDataInfo)get("hatchFactory");
    }
    public void setHatchFactory(com.kingdee.eas.farm.hatch.HatchBaseDataInfo item)
    {
        put("hatchFactory", item);
    }
    /**
     * Object:照蛋记录单's 无精蛋property 
     */
    public int getAllNoFertileEggQty()
    {
        return getInt("allNoFertileEggQty");
    }
    public void setAllNoFertileEggQty(int item)
    {
        setInt("allNoFertileEggQty", item);
    }
    /**
     * Object:照蛋记录单's 死胚property 
     */
    public int getAllAddleEggQty()
    {
        return getInt("allAddleEggQty");
    }
    public void setAllAddleEggQty(int item)
    {
        setInt("allAddleEggQty", item);
    }
    /**
     * Object:照蛋记录单's 臭蛋property 
     */
    public int getAllRottenEggQty()
    {
        return getInt("allRottenEggQty");
    }
    public void setAllRottenEggQty(int item)
    {
        setInt("allRottenEggQty", item);
    }
    /**
     * Object:照蛋记录单's 上孵总数property 
     */
    public int getAllHatchEggQty()
    {
        return getInt("allHatchEggQty");
    }
    public void setAllHatchEggQty(int item)
    {
        setInt("allHatchEggQty", item);
    }
    /**
     * Object: 照蛋记录单 's 操作员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getOperator()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("operator");
    }
    public void setOperator(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("operator", item);
    }
    /**
     * Object:照蛋记录单's 活胚property 
     */
    public int getAllHealthEggQty()
    {
        return getInt("allHealthEggQty");
    }
    public void setAllHealthEggQty(int item)
    {
        setInt("allHealthEggQty", item);
    }
    /**
     * Object: 照蛋记录单 's 入孵区域 property 
     */
    public com.kingdee.eas.farm.hatch.HatchAreaInfo getHatchArea()
    {
        return (com.kingdee.eas.farm.hatch.HatchAreaInfo)get("hatchArea");
    }
    public void setHatchArea(com.kingdee.eas.farm.hatch.HatchAreaInfo item)
    {
        put("hatchArea", item);
    }
    /**
     * Object: 照蛋记录单 's 孵化箱 property 
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
     * Object:照蛋记录单's 其他损耗property 
     */
    public int getOtherLoss()
    {
        return getInt("otherLoss");
    }
    public void setOtherLoss(int item)
    {
        setInt("otherLoss", item);
    }
    /**
     * Object: 照蛋记录单 's 照蛋明细 property 
     */
    public com.kingdee.eas.farm.hatch.BEggCandlingBillEggEntryCollection getEggEntries()
    {
        return (com.kingdee.eas.farm.hatch.BEggCandlingBillEggEntryCollection)get("EggEntries");
    }
    /**
     * Object: 照蛋记录单 's 部门 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getAdminOrg()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("adminOrg");
    }
    public void setAdminOrg(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("adminOrg", item);
    }
    /**
     * Object:照蛋记录单's 破损property 
     */
    public int getAllBrokenEggQty()
    {
        return getInt("allBrokenEggQty");
    }
    public void setAllBrokenEggQty(int item)
    {
        setInt("allBrokenEggQty", item);
    }
    /**
     * Object:照蛋记录单's 散黄property 
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
     * Object:照蛋记录单's 受精率（%）property 
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
     * Object: 照蛋记录单 's 孵化厅 property 
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
     * Object:照蛋记录单's 种蛋类型property 
     */
    public com.kingdee.eas.farm.hatch.EggType getEggType()
    {
        return com.kingdee.eas.farm.hatch.EggType.getEnum(getString("eggType"));
    }
    public void setEggType(com.kingdee.eas.farm.hatch.EggType item)
    {
		if (item != null) {
        setString("eggType", item.getValue());
		}
    }
    /**
     * Object: 照蛋记录单 's 片区汇总 property 
     */
    public com.kingdee.eas.farm.hatch.BEggCandlingBillAreaSumEntryCollection getAreaSumEntry()
    {
        return (com.kingdee.eas.farm.hatch.BEggCandlingBillAreaSumEntryCollection)get("AreaSumEntry");
    }
    /**
     * Object: 照蛋记录单 's 农户汇总 property 
     */
    public com.kingdee.eas.farm.hatch.BEggCandlingBillFarmerSumEntryCollection getFarmerSumEntry()
    {
        return (com.kingdee.eas.farm.hatch.BEggCandlingBillFarmerSumEntryCollection)get("FarmerSumEntry");
    }
    /**
     * Object:照蛋记录单's 上孵日期property 
     */
    public java.util.Date getHatchDate()
    {
        return getDate("hatchDate");
    }
    public void setHatchDate(java.util.Date item)
    {
        setDate("hatchDate", item);
    }
    /**
     * Object:照蛋记录单's 是否落盘property 
     */
    public boolean isIsTraying()
    {
        return getBoolean("isTraying");
    }
    public void setIsTraying(boolean item)
    {
        setBoolean("isTraying", item);
    }
    /**
     * Object:照蛋记录单's 落盘日期property 
     */
    public java.util.Date getTrayingDate()
    {
        return getDate("trayingDate");
    }
    public void setTrayingDate(java.util.Date item)
    {
        setDate("trayingDate", item);
    }
    /**
     * Object: 照蛋记录单 's 调整单据号 property 
     */
    public com.kingdee.eas.farm.hatch.BEggCandlingBillInfo getAdjustBill()
    {
        return (com.kingdee.eas.farm.hatch.BEggCandlingBillInfo)get("adjustBill");
    }
    public void setAdjustBill(com.kingdee.eas.farm.hatch.BEggCandlingBillInfo item)
    {
        put("adjustBill", item);
    }
    /**
     * Object:照蛋记录单's 品系property 
     */
    public com.kingdee.eas.farm.stocking.hatch.GenderType getGenderTy()
    {
        return com.kingdee.eas.farm.stocking.hatch.GenderType.getEnum(getString("genderTy"));
    }
    public void setGenderTy(com.kingdee.eas.farm.stocking.hatch.GenderType item)
    {
		if (item != null) {
        setString("genderTy", item.getValue());
		}
    }
    /**
     * Object:照蛋记录单's 是否生成出雏单property 
     */
    public boolean isIsProBabyBill()
    {
        return getBoolean("isProBabyBill");
    }
    public void setIsProBabyBill(boolean item)
    {
        setBoolean("isProBabyBill", item);
    }
    /**
     * Object:照蛋记录单's 是否生成其它入property 
     */
    public boolean isIsOtherIn()
    {
        return getBoolean("isOtherIn");
    }
    public void setIsOtherIn(boolean item)
    {
        setBoolean("isOtherIn", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D54999A2");
    }
}