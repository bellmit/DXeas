package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractYieldDataBaseInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractYieldDataBaseInfo()
    {
        this("id");
    }
    protected AbstractYieldDataBaseInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseEntryCollection());
        put("DisRateEntry", new com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseDisRateEntryCollection());
    }
    /**
     * Object: 出成率设置 's 组别 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 出成率设置 's 分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseEntryCollection)get("Entry");
    }
    /**
     * Object:出成率设置's 生效日期property 
     */
    public java.util.Date getEffectDate()
    {
        return getDate("effectDate");
    }
    public void setEffectDate(java.util.Date item)
    {
        setDate("effectDate", item);
    }
    /**
     * Object:出成率设置's 失效日期property 
     */
    public java.util.Date getUneffectDate()
    {
        return getDate("uneffectDate");
    }
    public void setUneffectDate(java.util.Date item)
    {
        setDate("uneffectDate", item);
    }
    /**
     * Object: 出成率设置 's 公司 property 
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
     * Object:出成率设置's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object: 出成率设置 's 折算系数分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseDisRateEntryCollection getDisRateEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseDisRateEntryCollection)get("DisRateEntry");
    }
    /**
     * Object: 出成率设置 's 审核人 property 
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
     * Object:出成率设置's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("393F91E6");
    }
}