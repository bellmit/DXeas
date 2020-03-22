package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeedFettleStandardEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFeedFettleStandardEntryInfo()
    {
        this("id");
    }
    protected AbstractFeedFettleStandardEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 计算标准 's null property 
     */
    public com.kingdee.eas.farm.breed.FeedFettleInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.FeedFettleInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.FeedFettleInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 计算标准 's 标准编号 property 
     */
    public com.kingdee.eas.farm.breed.EntrustSettleStandardInfo getStandardNumber()
    {
        return (com.kingdee.eas.farm.breed.EntrustSettleStandardInfo)get("standardNumber");
    }
    public void setStandardNumber(com.kingdee.eas.farm.breed.EntrustSettleStandardInfo item)
    {
        put("standardNumber", item);
    }
    /**
     * Object:计算标准's 标准名称property 
     */
    public String getStandardName()
    {
        return getString("standardName");
    }
    public void setStandardName(String item)
    {
        setString("standardName", item);
    }
    /**
     * Object:计算标准's 毛利润1property 
     */
    public java.math.BigDecimal getGrossProfit()
    {
        return getBigDecimal("grossProfit");
    }
    public void setGrossProfit(java.math.BigDecimal item)
    {
        setBigDecimal("grossProfit", item);
    }
    /**
     * Object:计算标准's 是否采用property 
     */
    public boolean isIsUse()
    {
        return getBoolean("isUse");
    }
    public void setIsUse(boolean item)
    {
        setBoolean("isUse", item);
    }
    /**
     * Object:计算标准's 毛利润2property 
     */
    public java.math.BigDecimal getGrossProfit2()
    {
        return getBigDecimal("grossProfit2");
    }
    public void setGrossProfit2(java.math.BigDecimal item)
    {
        setBigDecimal("grossProfit2", item);
    }
    /**
     * Object:计算标准's 毛利润3property 
     */
    public java.math.BigDecimal getGrossProfit3()
    {
        return getBigDecimal("grossProfit3");
    }
    public void setGrossProfit3(java.math.BigDecimal item)
    {
        setBigDecimal("grossProfit3", item);
    }
    /**
     * Object:计算标准's 采用毛利计算序号property 
     */
    public int getUseGroprofitNum()
    {
        return getInt("useGroprofitNum");
    }
    public void setUseGroprofitNum(int item)
    {
        setInt("useGroprofitNum", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2980B445");
    }
}