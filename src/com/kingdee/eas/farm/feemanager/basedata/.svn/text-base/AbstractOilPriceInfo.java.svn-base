package com.kingdee.eas.farm.feemanager.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOilPriceInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractOilPriceInfo()
    {
        this("id");
    }
    protected AbstractOilPriceInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 柴油价格维护 's 组别 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.OilPriceTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.OilPriceTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.feemanager.basedata.OilPriceTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:柴油价格维护's 油品名称property 
     */
    public String getOilname()
    {
        return getString("oilname");
    }
    public void setOilname(String item)
    {
        setString("oilname", item);
    }
    /**
     * Object:柴油价格维护's 生效日期property 
     */
    public java.util.Date getStartdate()
    {
        return getDate("startdate");
    }
    public void setStartdate(java.util.Date item)
    {
        setDate("startdate", item);
    }
    /**
     * Object:柴油价格维护's 油品今日价格property 
     */
    public java.math.BigDecimal getDailyprice()
    {
        return getBigDecimal("dailyprice");
    }
    public void setDailyprice(java.math.BigDecimal item)
    {
        setBigDecimal("dailyprice", item);
    }
    /**
     * Object:柴油价格维护's 资料状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getState()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("state"));
    }
    public void setState(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("state", item.getValue());
		}
    }
    /**
     * Object:柴油价格维护's 标准价格property 
     */
    public java.math.BigDecimal getStandardprice()
    {
        return getBigDecimal("standardprice");
    }
    public void setStandardprice(java.math.BigDecimal item)
    {
        setBigDecimal("standardprice", item);
    }
    /**
     * Object: 柴油价格维护 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompanyorgunit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("companyorgunit");
    }
    public void setCompanyorgunit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("companyorgunit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("74075243");
    }
}