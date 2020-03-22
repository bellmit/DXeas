package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchStandardInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractHatchStandardInfo()
    {
        this("id");
    }
    protected AbstractHatchStandardInfo(String pkField)
    {
        super(pkField);
        put("Entrys", new com.kingdee.eas.farm.hatch.HatchStandardEntryCollection());
    }
    /**
     * Object: 孵化规范 's 组别 property 
     */
    public com.kingdee.eas.farm.hatch.HatchStandardTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.hatch.HatchStandardTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.hatch.HatchStandardTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 孵化规范 's 标准健母率 property 
     */
    public com.kingdee.eas.farm.hatch.HatchStandardEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.hatch.HatchStandardEntryCollection)get("Entrys");
    }
    /**
     * Object: 孵化规范 's 审核人 property 
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
     * Object:孵化规范's 审核时间property 
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
     * Object: 孵化规范 's 品种 property 
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
     * Object:孵化规范's 状态property 
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
     * Object: 孵化规范 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D7269FCF");
    }
}