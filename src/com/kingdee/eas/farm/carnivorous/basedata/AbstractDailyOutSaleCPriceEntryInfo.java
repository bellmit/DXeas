package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDailyOutSaleCPriceEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDailyOutSaleCPriceEntryInfo()
    {
        this("id");
    }
    protected AbstractDailyOutSaleCPriceEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.DailyOutSaleCPriceInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.DailyOutSaleCPriceInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.DailyOutSaleCPriceInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 下限比较符property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.highSymbol getMinSymbol()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.highSymbol.getEnum(getString("minSymbol"));
    }
    public void setMinSymbol(com.kingdee.eas.farm.carnivorous.basedata.highSymbol item)
    {
		if (item != null) {
        setString("minSymbol", item.getValue());
		}
    }
    /**
     * Object:分录's 上限比较符property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.LessSymbol getMaxSymbol()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.LessSymbol.getEnum(getString("maxSymbol"));
    }
    public void setMaxSymbol(com.kingdee.eas.farm.carnivorous.basedata.LessSymbol item)
    {
		if (item != null) {
        setString("maxSymbol", item.getValue());
		}
    }
    /**
     * Object:分录's 均重下限值property 
     */
    public java.math.BigDecimal getMinValue()
    {
        return getBigDecimal("minValue");
    }
    public void setMinValue(java.math.BigDecimal item)
    {
        setBigDecimal("minValue", item);
    }
    /**
     * Object:分录's 均重上限值property 
     */
    public java.math.BigDecimal getMaxValue()
    {
        return getBigDecimal("maxValue");
    }
    public void setMaxValue(java.math.BigDecimal item)
    {
        setBigDecimal("maxValue", item);
    }
    /**
     * Object:分录's 毛鸡单价property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("67702F8E");
    }
}