package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAvgWgtSectionEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractAvgWgtSectionEntryInfo()
    {
        this("id");
    }
    protected AbstractAvgWgtSectionEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.AvgWgtSectionInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.AvgWgtSectionInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.AvgWgtSectionInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 下限比较符property 
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
     * Object:分录's 起始值property 
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
     * Object:分录's 上限比较符property 
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
     * Object:分录's 终止值property 
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
     * Object:分录's 区间值property 
     */
    public String getSection()
    {
        return getString("section");
    }
    public void setSection(String item)
    {
        setString("section", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("522E9641");
    }
}