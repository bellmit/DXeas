package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggSettlePolicyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractEggSettlePolicyInfo()
    {
        this("id");
    }
    protected AbstractEggSettlePolicyInfo(String pkField)
    {
        super(pkField);
        put("RangeEntry", new com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyRangeEntryCollection());
        put("SaleEntry", new com.kingdee.eas.farm.stocking.hatch.EggSettlePolicySaleEntryCollection());
        put("PolicyEntry", new com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyPolicyEntryCollection());
    }
    /**
     * Object: 种蛋结算政策 's 组别 property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:种蛋结算政策's 状态property 
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
     * Object: 种蛋结算政策 's 审核人 property 
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
     * Object:种蛋结算政策's 审核时间property 
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
     * Object: 种蛋结算政策 's 财务组织 property 
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
     * Object: 种蛋结算政策 's 政策分录 property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyPolicyEntryCollection getPolicyEntry()
    {
        return (com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyPolicyEntryCollection)get("PolicyEntry");
    }
    /**
     * Object:种蛋结算政策's 生效日期property 
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
     * Object:种蛋结算政策's 失效日期property 
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
     * Object: 种蛋结算政策 's 作用范围 property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyRangeEntryCollection getRangeEntry()
    {
        return (com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyRangeEntryCollection)get("RangeEntry");
    }
    /**
     * Object:种蛋结算政策's 代孵费property 
     */
    public java.math.BigDecimal getInsteadPrice()
    {
        return getBigDecimal("insteadPrice");
    }
    public void setInsteadPrice(java.math.BigDecimal item)
    {
        setBigDecimal("insteadPrice", item);
    }
    /**
     * Object: 种蛋结算政策 's 销售计算分录 property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggSettlePolicySaleEntryCollection getSaleEntry()
    {
        return (com.kingdee.eas.farm.stocking.hatch.EggSettlePolicySaleEntryCollection)get("SaleEntry");
    }
    /**
     * Object:种蛋结算政策's 结算方式property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyType getEggSettleType()
    {
        return com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyType.getEnum(getInt("eggSettleType"));
    }
    public void setEggSettleType(com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyType item)
    {
		if (item != null) {
        setInt("eggSettleType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("652C65D8");
    }
}