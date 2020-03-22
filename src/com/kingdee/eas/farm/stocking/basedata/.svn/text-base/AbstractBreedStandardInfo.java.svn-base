package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedStandardInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBreedStandardInfo()
    {
        this("id");
    }
    protected AbstractBreedStandardInfo(String pkField)
    {
        super(pkField);
        put("LayEggEntrys", new com.kingdee.eas.farm.stocking.basedata.BreedStandardLayEggEntryCollection());
        put("DepcEntry", new com.kingdee.eas.farm.stocking.basedata.BreedStandardDepcEntryCollection());
        put("Entrys", new com.kingdee.eas.farm.stocking.basedata.BreedStandardEntryCollection());
        put("DrugEntry", new com.kingdee.eas.farm.stocking.basedata.BreedStandardDrugEntryCollection());
    }
    /**
     * Object: 养殖规范 's 组别 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedStandardTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedStandardTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.BreedStandardTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 养殖规范 's 饲喂计划 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedStandardEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedStandardEntryCollection)get("Entrys");
    }
    /**
     * Object: 养殖规范 's 审核人 property 
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
     * Object:养殖规范's 审核时间property 
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
     * Object:养殖规范's 最短饲喂周期(天)property 
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
     * Object: 养殖规范 's 产蛋规范 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedStandardLayEggEntryCollection getLayEggEntrys()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedStandardLayEggEntryCollection)get("LayEggEntrys");
    }
    /**
     * Object: 养殖规范 's 品种 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreedData()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breedData");
    }
    public void setBreedData(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breedData", item);
    }
    /**
     * Object:养殖规范's 状态property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: 养殖规范 's 财务组织 property 
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
     * Object: 养殖规范 's 免疫规范 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedStandardDrugEntryCollection getDrugEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedStandardDrugEntryCollection)get("DrugEntry");
    }
    /**
     * Object: 养殖规范 's 折旧标准 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedStandardDepcEntryCollection getDepcEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedStandardDepcEntryCollection)get("DepcEntry");
    }
    /**
     * Object:养殖规范's 换羽property 
     */
    public boolean isMolting()
    {
        return getBoolean("molting");
    }
    public void setMolting(boolean item)
    {
        setBoolean("molting", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6C5ED8A0");
    }
}