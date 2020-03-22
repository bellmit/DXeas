package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMarginPolicyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractMarginPolicyInfo()
    {
        this("id");
    }
    protected AbstractMarginPolicyInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 保证金政策 's 组别 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 保证金政策 's 财务组织 property 
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
     * Object:保证金政策's 开始日期property 
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
     * Object:保证金政策's 结束日期property 
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
     * Object:保证金政策's 基本状态property 
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
     * Object: 保证金政策 's 品种 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreed()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breed");
    }
    public void setBreed(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breed", item);
    }
    /**
     * Object:保证金政策's 标准单只保证金property 
     */
    public java.math.BigDecimal getSingleMargin()
    {
        return getBigDecimal("singleMargin");
    }
    public void setSingleMargin(java.math.BigDecimal item)
    {
        setBigDecimal("singleMargin", item);
    }
    /**
     * Object:保证金政策's 最低单只保证金property 
     */
    public java.math.BigDecimal getMinMargin()
    {
        return getBigDecimal("minMargin");
    }
    public void setMinMargin(java.math.BigDecimal item)
    {
        setBigDecimal("minMargin", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("948B4B22");
    }
}