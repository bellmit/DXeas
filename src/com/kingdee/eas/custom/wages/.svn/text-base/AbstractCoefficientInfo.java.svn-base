package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCoefficientInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCoefficientInfo()
    {
        this("id");
    }
    protected AbstractCoefficientInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:岗位系数's 业务日期property 
     */
    public java.util.Date getBizdate()
    {
        return getDate("bizdate");
    }
    public void setBizdate(java.util.Date item)
    {
        setDate("bizdate", item);
    }
    /**
     * Object: 岗位系数 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:岗位系数's 岗位系数property 
     */
    public java.math.BigDecimal getCoefficientRate()
    {
        return getBigDecimal("CoefficientRate");
    }
    public void setCoefficientRate(java.math.BigDecimal item)
    {
        setBigDecimal("CoefficientRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D1EAF82D");
    }
}