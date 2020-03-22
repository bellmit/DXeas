package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarviousFeedComMeatEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCarviousFeedComMeatEntryInfo()
    {
        this("id");
    }
    protected AbstractCarviousFeedComMeatEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatInfo item)
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
    /**
     * Object:分录's 只药费(元/只)property 
     */
    public java.math.BigDecimal getOneDrugAmt()
    {
        return getBigDecimal("oneDrugAmt");
    }
    public void setOneDrugAmt(java.math.BigDecimal item)
    {
        setBigDecimal("oneDrugAmt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DA172FCC");
    }
}