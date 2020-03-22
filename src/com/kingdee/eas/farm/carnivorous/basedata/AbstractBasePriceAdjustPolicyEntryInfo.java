package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBasePriceAdjustPolicyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBasePriceAdjustPolicyEntryInfo()
    {
        this("id");
    }
    protected AbstractBasePriceAdjustPolicyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 项目 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:项目's 均重(斤)比较值property 
     */
    public java.math.BigDecimal getWeightCompareValue()
    {
        return getBigDecimal("weightCompareValue");
    }
    public void setWeightCompareValue(java.math.BigDecimal item)
    {
        setBigDecimal("weightCompareValue", item);
    }
    /**
     * Object:项目's 均重差异系数property 
     */
    public java.math.BigDecimal getWeightDiffCoe()
    {
        return getBigDecimal("weightDiffCoe");
    }
    public void setWeightDiffCoe(java.math.BigDecimal item)
    {
        setBigDecimal("weightDiffCoe", item);
    }
    /**
     * Object:项目's 基础回收价格下调比例(元/斤)property 
     */
    public java.math.BigDecimal getBasePriceReduceRadio()
    {
        return getBigDecimal("basePriceReduceRadio");
    }
    public void setBasePriceReduceRadio(java.math.BigDecimal item)
    {
        setBigDecimal("basePriceReduceRadio", item);
    }
    /**
     * Object:项目's 是否按市场毛鸡价格计算property 
     */
    public boolean isIsMarketPrice()
    {
        return getBoolean("isMarketPrice");
    }
    public void setIsMarketPrice(boolean item)
    {
        setBoolean("isMarketPrice", item);
    }
    /**
     * Object:项目's 下限比较符property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.highSymbol getHighCompare()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.highSymbol.getEnum(getString("highCompare"));
    }
    public void setHighCompare(com.kingdee.eas.farm.carnivorous.basedata.highSymbol item)
    {
		if (item != null) {
        setString("highCompare", item.getValue());
		}
    }
    /**
     * Object:项目's 毛鸡均重(斤)下限值property 
     */
    public java.math.BigDecimal getChicHighValue()
    {
        return getBigDecimal("chicHighValue");
    }
    public void setChicHighValue(java.math.BigDecimal item)
    {
        setBigDecimal("chicHighValue", item);
    }
    /**
     * Object:项目's 上限比较符property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.LessSymbol getLessCompareValue()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.LessSymbol.getEnum(getString("lessCompareValue"));
    }
    public void setLessCompareValue(com.kingdee.eas.farm.carnivorous.basedata.LessSymbol item)
    {
		if (item != null) {
        setString("lessCompareValue", item.getValue());
		}
    }
    /**
     * Object:项目's 毛鸡均重(斤)上限值property 
     */
    public java.math.BigDecimal getChicLessValue()
    {
        return getBigDecimal("chicLessValue");
    }
    public void setChicLessValue(java.math.BigDecimal item)
    {
        setBigDecimal("chicLessValue", item);
    }
    /**
     * Object:项目's 市场毛鸡价格先下调(元)property 
     */
    public java.math.BigDecimal getBeginDown()
    {
        return getBigDecimal("beginDown");
    }
    public void setBeginDown(java.math.BigDecimal item)
    {
        setBigDecimal("beginDown", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3BF2385B");
    }
}