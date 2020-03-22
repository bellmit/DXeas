package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSellSeedlingSettlePolicyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSellSeedlingSettlePolicyInfo()
    {
        this("id");
    }
    protected AbstractSellSeedlingSettlePolicyInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:代卖苗结算政策's 开始日期property 
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
     * Object:代卖苗结算政策's 结束日期property 
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
     * Object:代卖苗结算政策's 一级苗结算系数property 
     */
    public java.math.BigDecimal getSeedA1Coefficientt()
    {
        return getBigDecimal("seedA1Coefficientt");
    }
    public void setSeedA1Coefficientt(java.math.BigDecimal item)
    {
        setBigDecimal("seedA1Coefficientt", item);
    }
    /**
     * Object:代卖苗结算政策's 其他等级苗结算系数property 
     */
    public java.math.BigDecimal getSeedOtherCoefficient()
    {
        return getBigDecimal("seedOtherCoefficient");
    }
    public void setSeedOtherCoefficient(java.math.BigDecimal item)
    {
        setBigDecimal("seedOtherCoefficient", item);
    }
    /**
     * Object:代卖苗结算政策's 基本状态property 
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
        return new BOSObjectType("91B14CA7");
    }
}