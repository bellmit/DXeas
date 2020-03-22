package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRewardsPolicyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractRewardsPolicyInfo()
    {
        this("id");
    }
    protected AbstractRewardsPolicyInfo(String pkField)
    {
        super(pkField);
        put("PolicyEntry", new com.kingdee.eas.farm.stocking.basedata.RewardsPolicyPolicyEntryCollection());
    }
    /**
     * Object: 奖惩政策 's 组别 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.RewardsPolicyTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.RewardsPolicyTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.RewardsPolicyTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:奖惩政策's 状态property 
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
     * Object: 奖惩政策 's 审核人 property 
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
     * Object:奖惩政策's 审核时间property 
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
     * Object:奖惩政策's 基准值property 
     */
    public java.math.BigDecimal getBaseQty()
    {
        return getBigDecimal("baseQty");
    }
    public void setBaseQty(java.math.BigDecimal item)
    {
        setBigDecimal("baseQty", item);
    }
    /**
     * Object: 奖惩政策 's 财务组织 property 
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
     * Object: 奖惩政策 's 政策分录 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.RewardsPolicyPolicyEntryCollection getPolicyEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.RewardsPolicyPolicyEntryCollection)get("PolicyEntry");
    }
    /**
     * Object:奖惩政策's 奖惩类型property 
     */
    public com.kingdee.eas.farm.stocking.basedata.AwardsTypeEnum getBizType()
    {
        return com.kingdee.eas.farm.stocking.basedata.AwardsTypeEnum.getEnum(getInt("bizType"));
    }
    public void setBizType(com.kingdee.eas.farm.stocking.basedata.AwardsTypeEnum item)
    {
		if (item != null) {
        setInt("bizType", item.getValue());
		}
    }
    /**
     * Object:奖惩政策's 计算方式property 
     */
    public com.kingdee.eas.farm.stocking.basedata.AwardsCalType getCalType()
    {
        return com.kingdee.eas.farm.stocking.basedata.AwardsCalType.getEnum(getInt("calType"));
    }
    public void setCalType(com.kingdee.eas.farm.stocking.basedata.AwardsCalType item)
    {
		if (item != null) {
        setInt("calType", item.getValue());
		}
    }
    /**
     * Object:奖惩政策's 基准价格property 
     */
    public java.math.BigDecimal getBasePrice()
    {
        return getBigDecimal("basePrice");
    }
    public void setBasePrice(java.math.BigDecimal item)
    {
        setBigDecimal("basePrice", item);
    }
    /**
     * Object:奖惩政策's 公式文本property 
     */
    public String getFormulaTxt()
    {
        return getString("formulaTxt");
    }
    public void setFormulaTxt(String item)
    {
        setString("formulaTxt", item);
    }
    /**
     * Object:奖惩政策's 生效日期property 
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
     * Object:奖惩政策's 失效日期property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4753EDC5");
    }
}