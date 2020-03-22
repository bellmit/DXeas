package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractParentBreedBatchInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractParentBreedBatchInfo()
    {
        this("id");
    }
    protected AbstractParentBreedBatchInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.breed.ParentBreedBatchEntryCollection());
        put("TransEntrys", new com.kingdee.eas.farm.breed.ParentBreedBatchTransEntryCollection());
    }
    /**
     * Object: 种禽养殖批次 's 分录 property 
     */
    public com.kingdee.eas.farm.breed.ParentBreedBatchEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.ParentBreedBatchEntryCollection)get("entrys");
    }
    /**
     * Object:种禽养殖批次's 是否生成凭证property 
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
     * Object:种禽养殖批次's 审核时间property 
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
     * Object:种禽养殖批次's 状态property 
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
     * Object: 种禽养殖批次 's 养殖计划 property 
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
     * Object: 种禽养殖批次 's 养殖场 property 
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
     * Object: 种禽养殖批次 's 育雏期成本对象 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getBabyCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("babyCostObject");
    }
    public void setBabyCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("babyCostObject", item);
    }
    /**
     * Object: 种禽养殖批次 's 育成期成本对象 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getYoungCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("youngCostObject");
    }
    public void setYoungCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("youngCostObject", item);
    }
    /**
     * Object: 种禽养殖批次 's 种蛋成本对象 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getEggCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("eggCostObject");
    }
    public void setEggCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("eggCostObject", item);
    }
    /**
     * Object:种禽养殖批次's 育成转栏日期property 
     */
    public java.util.Date getYoungDate()
    {
        return getDate("youngDate");
    }
    public void setYoungDate(java.util.Date item)
    {
        setDate("youngDate", item);
    }
    /**
     * Object:种禽养殖批次's 成熟定栏日期property 
     */
    public java.util.Date getAdultDate()
    {
        return getDate("adultDate");
    }
    public void setAdultDate(java.util.Date item)
    {
        setDate("adultDate", item);
    }
    /**
     * Object: 种禽养殖批次 's 责任人 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object: 种禽养殖批次 's 区 property 
     */
    public com.kingdee.eas.farm.breed.BreedAreaInfo getBreedArea()
    {
        return (com.kingdee.eas.farm.breed.BreedAreaInfo)get("breedArea");
    }
    public void setBreedArea(com.kingdee.eas.farm.breed.BreedAreaInfo item)
    {
        put("breedArea", item);
    }
    /**
     * Object: 种禽养殖批次 's 转栏分录 property 
     */
    public com.kingdee.eas.farm.breed.ParentBreedBatchTransEntryCollection getTransEntrys()
    {
        return (com.kingdee.eas.farm.breed.ParentBreedBatchTransEntryCollection)get("TransEntrys");
    }
    /**
     * Object: 种禽养殖批次 's 适用规范 property 
     */
    public com.kingdee.eas.farm.breed.BreedModelInfo getBreedModel()
    {
        return (com.kingdee.eas.farm.breed.BreedModelInfo)get("breedModel");
    }
    public void setBreedModel(com.kingdee.eas.farm.breed.BreedModelInfo item)
    {
        put("breedModel", item);
    }
    /**
     * Object:种禽养殖批次's 换羽批次property 
     */
    public boolean isIsMoultingBatch()
    {
        return getBoolean("isMoultingBatch");
    }
    public void setIsMoultingBatch(boolean item)
    {
        setBoolean("isMoultingBatch", item);
    }
    /**
     * Object:种禽养殖批次's 定群周龄property 
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
     * Object:种禽养殖批次's 日龄property 
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
     * Object:种禽养殖批次's 已转育成property 
     */
    public boolean isIsToBreed()
    {
        return getBoolean("isToBreed");
    }
    public void setIsToBreed(boolean item)
    {
        setBoolean("isToBreed", item);
    }
    /**
     * Object:种禽养殖批次's 已转产蛋property 
     */
    public boolean isIsToLayegg()
    {
        return getBoolean("isToLayegg");
    }
    public void setIsToLayegg(boolean item)
    {
        setBoolean("isToLayegg", item);
    }
    /**
     * Object:种禽养殖批次's 禽类别property 
     */
    public com.kingdee.eas.farm.breed.HenhouseType getHenhouseType()
    {
        return com.kingdee.eas.farm.breed.HenhouseType.getEnum(getString("henhouseType"));
    }
    public void setHenhouseType(com.kingdee.eas.farm.breed.HenhouseType item)
    {
		if (item != null) {
        setString("henhouseType", item.getValue());
		}
    }
    /**
     * Object:种禽养殖批次's 品种property 
     */
    public String getVarietie()
    {
        return getString("Varietie");
    }
    public void setVarietie(String item)
    {
        setString("Varietie", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0238F3CA");
    }
}