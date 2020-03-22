package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStatementsPolicyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractStatementsPolicyInfo()
    {
        this("id");
    }
    protected AbstractStatementsPolicyInfo(String pkField)
    {
        super(pkField);
        put("RecycleEntry", new com.kingdee.eas.farm.stocking.basedata.StatementsPolicyRecycleEntryCollection());
        put("AwardsEntry", new com.kingdee.eas.farm.stocking.basedata.StatementsPolicyAwardsEntryCollection());
        put("SubsidyEntry", new com.kingdee.eas.farm.stocking.basedata.StatementsPolicySubsidyEntryCollection());
        put("PriceEntry", new com.kingdee.eas.farm.stocking.basedata.StatementsPolicyPriceEntryCollection());
    }
    /**
     * Object: 结算政策 's 组别 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StatementsPolicyTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StatementsPolicyTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.StatementsPolicyTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:结算政策's 状态property 
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
     * Object: 结算政策 's 审核人 property 
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
     * Object:结算政策's 审核时间property 
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
     * Object: 结算政策 's 财务组织 property 
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
     * Object: 结算政策 's 价格分录 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StatementsPolicyPriceEntryCollection getPriceEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StatementsPolicyPriceEntryCollection)get("PriceEntry");
    }
    /**
     * Object:结算政策's 是否模板property 
     */
    public boolean isIsTemplate()
    {
        return getBoolean("isTemplate");
    }
    public void setIsTemplate(boolean item)
    {
        setBoolean("isTemplate", item);
    }
    /**
     * Object: 结算政策 's 品种 property 
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
     * Object: 结算政策 's 回收政策 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StatementsPolicyRecycleEntryCollection getRecycleEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StatementsPolicyRecycleEntryCollection)get("RecycleEntry");
    }
    /**
     * Object: 结算政策 's 奖罚政策 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StatementsPolicyAwardsEntryCollection getAwardsEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StatementsPolicyAwardsEntryCollection)get("AwardsEntry");
    }
    /**
     * Object: 结算政策 's 补贴分录 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StatementsPolicySubsidyEntryCollection getSubsidyEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StatementsPolicySubsidyEntryCollection)get("SubsidyEntry");
    }
    /**
     * Object:结算政策's 生效日期property 
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
     * Object:结算政策's 失效日期property 
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
     * Object:结算政策's 母鸭生活费(只)property 
     */
    public java.math.BigDecimal getAvgFemaleFee()
    {
        return getBigDecimal("avgFemaleFee");
    }
    public void setAvgFemaleFee(java.math.BigDecimal item)
    {
        setBigDecimal("avgFemaleFee", item);
    }
    /**
     * Object:结算政策's 存款利率property 
     */
    public java.math.BigDecimal getDepositRate()
    {
        return getBigDecimal("depositRate");
    }
    public void setDepositRate(java.math.BigDecimal item)
    {
        setBigDecimal("depositRate", item);
    }
    /**
     * Object:结算政策's 计提方式property 
     */
    public com.kingdee.eas.farm.stocking.basedata.ProvisionTypeEnum getProvisionType()
    {
        return com.kingdee.eas.farm.stocking.basedata.ProvisionTypeEnum.getEnum(getInt("provisionType"));
    }
    public void setProvisionType(com.kingdee.eas.farm.stocking.basedata.ProvisionTypeEnum item)
    {
		if (item != null) {
        setInt("provisionType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1BAC9487");
    }
}