package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOutSourcingEggPriceInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractOutSourcingEggPriceInfo()
    {
        this("id");
    }
    protected AbstractOutSourcingEggPriceInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 外购蛋结算费用单价 's 财务组织 property 
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
     * Object:外购蛋结算费用单价's 结算费用单价property 
     */
    public java.math.BigDecimal getSettleCostPrice()
    {
        return getBigDecimal("settleCostPrice");
    }
    public void setSettleCostPrice(java.math.BigDecimal item)
    {
        setBigDecimal("settleCostPrice", item);
    }
    /**
     * Object:外购蛋结算费用单价's 上孵开始日期property 
     */
    public java.util.Date getHatchBeginDate()
    {
        return getDate("hatchBeginDate");
    }
    public void setHatchBeginDate(java.util.Date item)
    {
        setDate("hatchBeginDate", item);
    }
    /**
     * Object:外购蛋结算费用单价's 上孵截止日期property 
     */
    public java.util.Date getHatchEndDate()
    {
        return getDate("hatchEndDate");
    }
    public void setHatchEndDate(java.util.Date item)
    {
        setDate("hatchEndDate", item);
    }
    /**
     * Object:外购蛋结算费用单价's 基本状态property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("578FBAF9");
    }
}