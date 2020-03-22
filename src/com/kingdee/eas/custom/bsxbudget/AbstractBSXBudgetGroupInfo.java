package com.kingdee.eas.custom.bsxbudget;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBSXBudgetGroupInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBSXBudgetGroupInfo()
    {
        this("id");
    }
    protected AbstractBSXBudgetGroupInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:集团预算's 审核时间property 
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
     * Object: 集团预算 's 期间 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    /**
     * Object:集团预算's 食品公司收入property 
     */
    public java.math.BigDecimal getRevenueFood()
    {
        return getBigDecimal("RevenueFood");
    }
    public void setRevenueFood(java.math.BigDecimal item)
    {
        setBigDecimal("RevenueFood", item);
    }
    /**
     * Object:集团预算's 养殖公司收入property 
     */
    public java.math.BigDecimal getRevenueFeed()
    {
        return getBigDecimal("revenueFeed");
    }
    public void setRevenueFeed(java.math.BigDecimal item)
    {
        setBigDecimal("revenueFeed", item);
    }
    /**
     * Object:集团预算's 集团总收入property 
     */
    public java.math.BigDecimal getRevenueGroup()
    {
        return getBigDecimal("revenueGroup");
    }
    public void setRevenueGroup(java.math.BigDecimal item)
    {
        setBigDecimal("revenueGroup", item);
    }
    /**
     * Object:集团预算's 食品公司成本property 
     */
    public java.math.BigDecimal getCostFood()
    {
        return getBigDecimal("costFood");
    }
    public void setCostFood(java.math.BigDecimal item)
    {
        setBigDecimal("costFood", item);
    }
    /**
     * Object:集团预算's 养殖公司成本property 
     */
    public java.math.BigDecimal getCostFeed()
    {
        return getBigDecimal("costFeed");
    }
    public void setCostFeed(java.math.BigDecimal item)
    {
        setBigDecimal("costFeed", item);
    }
    /**
     * Object:集团预算's 集团总成本property 
     */
    public java.math.BigDecimal getCostGroup()
    {
        return getBigDecimal("costGroup");
    }
    public void setCostGroup(java.math.BigDecimal item)
    {
        setBigDecimal("costGroup", item);
    }
    /**
     * Object:集团预算's 管理费用property 
     */
    public java.math.BigDecimal getManageFee()
    {
        return getBigDecimal("manageFee");
    }
    public void setManageFee(java.math.BigDecimal item)
    {
        setBigDecimal("manageFee", item);
    }
    /**
     * Object:集团预算's 财务费用property 
     */
    public java.math.BigDecimal getFIFee()
    {
        return getBigDecimal("FIFee");
    }
    public void setFIFee(java.math.BigDecimal item)
    {
        setBigDecimal("FIFee", item);
    }
    /**
     * Object:集团预算's 集团总费用property 
     */
    public java.math.BigDecimal getGroupFee()
    {
        return getBigDecimal("groupFee");
    }
    public void setGroupFee(java.math.BigDecimal item)
    {
        setBigDecimal("groupFee", item);
    }
    /**
     * Object:集团预算's 集团总利润property 
     */
    public java.math.BigDecimal getProfit()
    {
        return getBigDecimal("profit");
    }
    public void setProfit(java.math.BigDecimal item)
    {
        setBigDecimal("profit", item);
    }
    /**
     * Object:集团预算's 单据状态property 
     */
    public com.kingdee.eas.custom.bsxbudget.billStatus getBillStatus()
    {
        return com.kingdee.eas.custom.bsxbudget.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.bsxbudget.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("255B25DA");
    }
}