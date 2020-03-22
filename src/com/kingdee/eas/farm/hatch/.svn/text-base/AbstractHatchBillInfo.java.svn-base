package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractHatchBillInfo()
    {
        this("id");
    }
    protected AbstractHatchBillInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:上孵单's 是否生成凭证property 
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
     * Object: 上孵单 's 来源产蛋场 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getEggStoOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("eggStoOrg");
    }
    public void setEggStoOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("eggStoOrg", item);
    }
    /**
     * Object: 上孵单 's 种蛋批次(旧) property 
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
     * Object: 上孵单 's 操作员 property 
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
     * Object: 上孵单 's 所属蛋带 property 
     */
    public com.kingdee.eas.farm.breed.layegg.EggConveyorInfo getEggConveyor()
    {
        return (com.kingdee.eas.farm.breed.layegg.EggConveyorInfo)get("eggConveyor");
    }
    public void setEggConveyor(com.kingdee.eas.farm.breed.layegg.EggConveyorInfo item)
    {
        put("eggConveyor", item);
    }
    /**
     * Object:上孵单's 审核时间property 
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
     * Object:上孵单's 状态property 
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
     * Object:上孵单's 上孵数量property 
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
     * Object: 上孵单 's 鸡苗批次(旧) property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getBabyChickBatch()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("babyChickBatch");
    }
    public void setBabyChickBatch(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("babyChickBatch", item);
    }
    /**
     * Object:上孵单's 上孵时间property 
     */
    public java.sql.Time getHatchTime()
    {
        return getTime("hatchTime");
    }
    public void setHatchTime(java.sql.Time item)
    {
        setTime("hatchTime", item);
    }
    /**
     * Object:上孵单's 备注property 
     */
    public String getHatchDescription()
    {
        return getString("hatchDescription");
    }
    public void setHatchDescription(String item)
    {
        setString("hatchDescription", item);
    }
    /**
     * Object: 上孵单 's 孵化箱 property 
     */
    public com.kingdee.eas.farm.hatch.IncubatorInfo getInvubatorBox()
    {
        return (com.kingdee.eas.farm.hatch.IncubatorInfo)get("invubatorBox");
    }
    public void setInvubatorBox(com.kingdee.eas.farm.hatch.IncubatorInfo item)
    {
        put("invubatorBox", item);
    }
    /**
     * Object: 上孵单 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrg");
    }
    public void setStorageOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrg", item);
    }
    /**
     * Object: 上孵单 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object: 上孵单 's 种蛋批次 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getBreedBatch()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("breedBatch");
    }
    public void setBreedBatch(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("breedBatch", item);
    }
    /**
     * Object:上孵单's 鸡苗批次property 
     */
    public String getChikenBatch()
    {
        return getString("chikenBatch");
    }
    public void setChikenBatch(String item)
    {
        setString("chikenBatch", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BC16FE19");
    }
}