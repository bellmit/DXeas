package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTechBatchRangeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractTechBatchRangeInfo()
    {
        this("id");
    }
    protected AbstractTechBatchRangeInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.stocking.basedata.TechBatchRangeEntryCollection());
    }
    /**
     * Object: 技术员批次范围 's 批次分录 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.TechBatchRangeEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.TechBatchRangeEntryCollection)get("Entry");
    }
    /**
     * Object: 技术员批次范围 's 公司 property 
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
     * Object: 技术员批次范围 's 技术员 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getUser()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("user");
    }
    public void setUser(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("user", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9C469AEA");
    }
}