package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleStandardInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSettleStandardInfo()
    {
        this("id");
    }
    protected AbstractSettleStandardInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 结算指标 's 组别 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SettleStandardTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.SettleStandardTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.SettleStandardTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 结算指标 's 财务组织 property 
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
     * Object:结算指标's 生效日期property 
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
     * Object:结算指标's 失效日期property 
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
     * Object:结算指标's 状态property 
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
     * Object:结算指标's 受精率property 
     */
    public java.math.BigDecimal getFertilizationRate()
    {
        return getBigDecimal("fertilizationRate");
    }
    public void setFertilizationRate(java.math.BigDecimal item)
    {
        setBigDecimal("fertilizationRate", item);
    }
    /**
     * Object:结算指标's 产蛋率property 
     */
    public java.math.BigDecimal getLayingRate()
    {
        return getBigDecimal("layingRate");
    }
    public void setLayingRate(java.math.BigDecimal item)
    {
        setBigDecimal("layingRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B1E872B9");
    }
}