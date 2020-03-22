package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTempPolicyMarketPriceEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTempPolicyMarketPriceEntryInfo()
    {
        this("id");
    }
    protected AbstractTempPolicyMarketPriceEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 市场价补贴 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:市场价补贴's 最低价property 
     */
    public java.math.BigDecimal getMinPrice()
    {
        return getBigDecimal("minPrice");
    }
    public void setMinPrice(java.math.BigDecimal item)
    {
        setBigDecimal("minPrice", item);
    }
    /**
     * Object:市场价补贴's 比较符property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.highSymbol getHighSymbol()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.highSymbol.getEnum(getString("highSymbol"));
    }
    public void setHighSymbol(com.kingdee.eas.farm.carnivorous.basedata.highSymbol item)
    {
		if (item != null) {
        setString("highSymbol", item.getValue());
		}
    }
    /**
     * Object:市场价补贴's 最高价property 
     */
    public java.math.BigDecimal getMaxPrice()
    {
        return getBigDecimal("maxPrice");
    }
    public void setMaxPrice(java.math.BigDecimal item)
    {
        setBigDecimal("maxPrice", item);
    }
    /**
     * Object:市场价补贴's 比较符property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.LessSymbol getLessSymbol()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.LessSymbol.getEnum(getString("lessSymbol"));
    }
    public void setLessSymbol(com.kingdee.eas.farm.carnivorous.basedata.LessSymbol item)
    {
		if (item != null) {
        setString("lessSymbol", item.getValue());
		}
    }
    /**
     * Object:市场价补贴's 补贴价格property 
     */
    public java.math.BigDecimal getSubsidyPrice()
    {
        return getBigDecimal("subsidyPrice");
    }
    public void setSubsidyPrice(java.math.BigDecimal item)
    {
        setBigDecimal("subsidyPrice", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EE036B6D");
    }
}