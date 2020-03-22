package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedBatchInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBreedBatchInfo()
    {
        this("id");
    }
    protected AbstractBreedBatchInfo(String pkField)
    {
        super(pkField);
        put("EditEntrys", new com.kingdee.eas.farm.breed.BreedBatchEditEntryCollection());
        put("entrys", new com.kingdee.eas.farm.breed.BreedBatchEntryCollection());
    }
    /**
     * Object: 养殖批次 's 分录 property 
     */
    public com.kingdee.eas.farm.breed.BreedBatchEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.BreedBatchEntryCollection)get("entrys");
    }
    /**
     * Object:养殖批次's 是否生成凭证property 
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
     * Object: 养殖批次 's 批次（成本对象） property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("costObject");
    }
    public void setCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("costObject", item);
    }
    /**
     * Object:养殖批次's 定栏周龄property 
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
     * Object:养殖批次's 日龄property 
     */
    public int getWeekDay()
    {
        return getInt("weekDay");
    }
    public void setWeekDay(int item)
    {
        setInt("weekDay", item);
    }
    /**
     * Object:养殖批次's 审核时间property 
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
     * Object: 养殖批次 's 养殖场 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStoOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("stoOrg");
    }
    public void setStoOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("stoOrg", item);
    }
    /**
     * Object:养殖批次's 状态property 
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
     * Object:养殖批次's 鸡舍类别property 
     */
    public com.kingdee.eas.farm.breed.HenhouseType getHouseType()
    {
        return com.kingdee.eas.farm.breed.HenhouseType.getEnum(getString("houseType"));
    }
    public void setHouseType(com.kingdee.eas.farm.breed.HenhouseType item)
    {
		if (item != null) {
        setString("houseType", item.getValue());
		}
    }
    /**
     * Object:养殖批次's 定栏日龄property 
     */
    public int getDays()
    {
        return getInt("days");
    }
    public void setDays(int item)
    {
        setInt("days", item);
    }
    /**
     * Object: 养殖批次 's 种蛋批次 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getEggBatch()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("eggBatch");
    }
    public void setEggBatch(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("eggBatch", item);
    }
    /**
     * Object: 养殖批次 's 场部库 property 
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
     * Object: 养殖批次 's 变更情况 property 
     */
    public com.kingdee.eas.farm.breed.BreedBatchEditEntryCollection getEditEntrys()
    {
        return (com.kingdee.eas.farm.breed.BreedBatchEditEntryCollection)get("EditEntrys");
    }
    /**
     * Object: 养殖批次 's 养殖计划 property 
     */
    public com.kingdee.eas.farm.breed.business.CCBreedPlanInfo getBreedPlan()
    {
        return (com.kingdee.eas.farm.breed.business.CCBreedPlanInfo)get("breedPlan");
    }
    public void setBreedPlan(com.kingdee.eas.farm.breed.business.CCBreedPlanInfo item)
    {
        put("breedPlan", item);
    }
    /**
     * Object:养殖批次's 鸡苗调拨数量property 
     */
    public int getTransQty()
    {
        return getInt("transQty");
    }
    public void setTransQty(int item)
    {
        setInt("transQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0364E700");
    }
}