package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBEggHatchBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBEggHatchBillInfo()
    {
        this("id");
    }
    protected AbstractBEggHatchBillInfo(String pkField)
    {
        super(pkField);
        put("HatchBoxSummaryEntry", new com.kingdee.eas.farm.hatch.BEggHatchBillHatchBoxSummaryEntryCollection());
        put("AreaSummaryEntry", new com.kingdee.eas.farm.hatch.BEggHatchBillAreaSummaryEntryCollection());
        put("EggEntry", new com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryCollection());
    }
    /**
     * Object:种蛋上孵单's 是否生成凭证property 
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
     * Object:种蛋上孵单's 审核日期property 
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
     * Object:种蛋上孵单's 状态property 
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
     * Object: 种蛋上孵单 's 孵化场 property 
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
     * Object:种蛋上孵单's 上孵总数property 
     */
    public int getAllHatchQty()
    {
        return getInt("allHatchQty");
    }
    public void setAllHatchQty(int item)
    {
        setInt("allHatchQty", item);
    }
    /**
     * Object: 种蛋上孵单 's 孵化箱 property 
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
     * Object: 种蛋上孵单 's 操作员 property 
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
     * Object:种蛋上孵单's 种蛋类型property 
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
     * Object: 种蛋上孵单 's 种蛋来源 property 
     */
    public com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryCollection getEggEntry()
    {
        return (com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryCollection)get("EggEntry");
    }
    /**
     * Object: 种蛋上孵单 's 入孵区域 property 
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
     * Object: 种蛋上孵单 's 部门 property 
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
     * Object: 种蛋上孵单 's 孵化厅 property 
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
     * Object: 种蛋上孵单 's 片区 property 
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
     * Object: 种蛋上孵单 's 片区汇总 property 
     */
    public com.kingdee.eas.farm.hatch.BEggHatchBillAreaSummaryEntryCollection getAreaSummaryEntry()
    {
        return (com.kingdee.eas.farm.hatch.BEggHatchBillAreaSummaryEntryCollection)get("AreaSummaryEntry");
    }
    /**
     * Object: 种蛋上孵单 's 孵化箱汇总 property 
     */
    public com.kingdee.eas.farm.hatch.BEggHatchBillHatchBoxSummaryEntryCollection getHatchBoxSummaryEntry()
    {
        return (com.kingdee.eas.farm.hatch.BEggHatchBillHatchBoxSummaryEntryCollection)get("HatchBoxSummaryEntry");
    }
    /**
     * Object:种蛋上孵单's 是否生成照蛋property 
     */
    public boolean isIsHasBEggCanding()
    {
        return getBoolean("isHasBEggCanding");
    }
    public void setIsHasBEggCanding(boolean item)
    {
        setBoolean("isHasBEggCanding", item);
    }
    /**
     * Object:种蛋上孵单's 照蛋日期property 
     */
    public java.util.Date getBEggCandingDate()
    {
        return getDate("BEggCandingDate");
    }
    public void setBEggCandingDate(java.util.Date item)
    {
        setDate("BEggCandingDate", item);
    }
    /**
     * Object:种蛋上孵单's 整数property 
     */
    public int getBIMUDF0083()
    {
        return getInt("BIMUDF0083");
    }
    public void setBIMUDF0083(int item)
    {
        setInt("BIMUDF0083", item);
    }
    /**
     * Object: 种蛋上孵单 's 调整单据号 property 
     */
    public com.kingdee.eas.farm.hatch.BEggHatchBillInfo getAdjustBill()
    {
        return (com.kingdee.eas.farm.hatch.BEggHatchBillInfo)get("adjustBill");
    }
    public void setAdjustBill(com.kingdee.eas.farm.hatch.BEggHatchBillInfo item)
    {
        put("adjustBill", item);
    }
    /**
     * Object:种蛋上孵单's 品系property 
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
     * Object: 种蛋上孵单 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("StorageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("StorageOrgUnit", item);
    }
    /**
     * Object:种蛋上孵单's 是否生成领料出property 
     */
    public boolean isIsMaterialOut()
    {
        return getBoolean("isMaterialOut");
    }
    public void setIsMaterialOut(boolean item)
    {
        setBoolean("isMaterialOut", item);
    }
    /**
     * Object:种蛋上孵单's 是否生成库存调拨property 
     */
    public boolean isIsInventory()
    {
        return getBoolean("isInventory");
    }
    public void setIsInventory(boolean item)
    {
        setBoolean("isInventory", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D2F77416");
    }
}