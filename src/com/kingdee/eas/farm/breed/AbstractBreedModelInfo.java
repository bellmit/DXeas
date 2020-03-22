package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedModelInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBreedModelInfo()
    {
        this("id");
    }
    protected AbstractBreedModelInfo(String pkField)
    {
        super(pkField);
        put("ImmuneEntrys", new com.kingdee.eas.farm.breed.BreedModelImmuneEntryCollection());
        put("LayEggEntrys", new com.kingdee.eas.farm.breed.BreedModelLayEggEntryCollection());
        put("Entrys", new com.kingdee.eas.farm.breed.BreedModelEntryCollection());
    }
    /**
     * Object: 饲喂规范 's 组别 property 
     */
    public com.kingdee.eas.farm.breed.BreedModelTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.breed.BreedModelTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.breed.BreedModelTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 饲喂规范 's 饲喂计划 property 
     */
    public com.kingdee.eas.farm.breed.BreedModelEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.BreedModelEntryCollection)get("Entrys");
    }
    /**
     * Object:饲喂规范's 启用日期property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:饲喂规范's 禁用日期property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object: 饲喂规范 's 审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("auditor");
    }
    public void setAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("auditor", item);
    }
    /**
     * Object:饲喂规范's 审核时间property 
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
     * Object:饲喂规范's 禽舍类别property 
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
     * Object:饲喂规范's 状态property 
     */
    public com.kingdee.eas.farm.breed.DisableState getDeletedStatus()
    {
        return com.kingdee.eas.farm.breed.DisableState.getEnum(getInt("deletedStatus"));
    }
    public void setDeletedStatus(com.kingdee.eas.farm.breed.DisableState item)
    {
		if (item != null) {
        setInt("deletedStatus", item.getValue());
		}
    }
    /**
     * Object:饲喂规范's 标准饲喂周期（天）property 
     */
    public int getBreedDays()
    {
        return getInt("breedDays");
    }
    public void setBreedDays(int item)
    {
        setInt("breedDays", item);
    }
    /**
     * Object:饲喂规范's 最短饲喂周期(天)property 
     */
    public int getLimitBreedDays()
    {
        return getInt("limitBreedDays");
    }
    public void setLimitBreedDays(int item)
    {
        setInt("limitBreedDays", item);
    }
    /**
     * Object: 饲喂规范 's 产蛋规范 property 
     */
    public com.kingdee.eas.farm.breed.BreedModelLayEggEntryCollection getLayEggEntrys()
    {
        return (com.kingdee.eas.farm.breed.BreedModelLayEggEntryCollection)get("LayEggEntrys");
    }
    /**
     * Object: 饲喂规范 's 免疫计划 property 
     */
    public com.kingdee.eas.farm.breed.BreedModelImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.breed.BreedModelImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object:饲喂规范's 默认规范property 
     */
    public boolean isIsDefault()
    {
        return getBoolean("isDefault");
    }
    public void setIsDefault(boolean item)
    {
        setBoolean("isDefault", item);
    }
    /**
     * Object:饲喂规范's 换羽规范property 
     */
    public boolean isIsMoulting()
    {
        return getBoolean("isMoulting");
    }
    public void setIsMoulting(boolean item)
    {
        setBoolean("isMoulting", item);
    }
    /**
     * Object: 饲喂规范 's 公司 property 
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
     * Object: 饲喂规范 's 品种 property 
     */
    public com.kingdee.eas.farm.breed.VarietieInfo getVarietie()
    {
        return (com.kingdee.eas.farm.breed.VarietieInfo)get("Varietie");
    }
    public void setVarietie(com.kingdee.eas.farm.breed.VarietieInfo item)
    {
        put("Varietie", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("04060AEF");
    }
}