package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSubsidyPolicyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSubsidyPolicyInfo()
    {
        this("id");
    }
    protected AbstractSubsidyPolicyInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 补贴政策 's 组别 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SubsidyPolicyTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SubsidyPolicyTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.carnivorous.basedata.SubsidyPolicyTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 补贴政策 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFICompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("FICompany");
    }
    public void setFICompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("FICompany", item);
    }
    /**
     * Object:补贴政策's 基本状态property 
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
     * Object:补贴政策's 生效日期property 
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
     * Object:补贴政策's 失效日期property 
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
     * Object:补贴政策's 补贴方式property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SubsidyTypeEnum getSubsidyType()
    {
        return com.kingdee.eas.farm.stocking.basedata.SubsidyTypeEnum.getEnum(getInt("subsidyType"));
    }
    public void setSubsidyType(com.kingdee.eas.farm.stocking.basedata.SubsidyTypeEnum item)
    {
		if (item != null) {
        setInt("subsidyType", item.getValue());
		}
    }
    /**
     * Object:补贴政策's 补贴金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8850865B");
    }
}