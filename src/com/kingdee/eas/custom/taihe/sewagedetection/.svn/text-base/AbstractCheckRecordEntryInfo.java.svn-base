package com.kingdee.eas.custom.taihe.sewagedetection;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCheckRecordEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCheckRecordEntryInfo()
    {
        this("id");
    }
    protected AbstractCheckRecordEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 明细 's null property 
     */
    public com.kingdee.eas.custom.taihe.sewagedetection.CheckRecordInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.CheckRecordInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.sewagedetection.CheckRecordInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:明细's 记录时间property 
     */
    public java.util.Date getRecordTime()
    {
        return getDate("recordTime");
    }
    public void setRecordTime(java.util.Date item)
    {
        setDate("recordTime", item);
    }
    /**
     * Object: 明细 's 检测项目 property 
     */
    public com.kingdee.eas.custom.taihe.sewagedetection.CheckItemInfo getCheckItem()
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.CheckItemInfo)get("checkItem");
    }
    public void setCheckItem(com.kingdee.eas.custom.taihe.sewagedetection.CheckItemInfo item)
    {
        put("checkItem", item);
    }
    /**
     * Object:明细's 检测值property 
     */
    public java.math.BigDecimal getCheckValue()
    {
        return getBigDecimal("checkValue");
    }
    public void setCheckValue(java.math.BigDecimal item)
    {
        setBigDecimal("checkValue", item);
    }
    /**
     * Object:明细's 指标上限property 
     */
    public java.math.BigDecimal getUpperLimit()
    {
        return getBigDecimal("upperLimit");
    }
    public void setUpperLimit(java.math.BigDecimal item)
    {
        setBigDecimal("upperLimit", item);
    }
    /**
     * Object:明细's 是否超标property 
     */
    public boolean isIsOverproof()
    {
        return getBoolean("isOverproof");
    }
    public void setIsOverproof(boolean item)
    {
        setBoolean("isOverproof", item);
    }
    /**
     * Object:明细's 单位property 
     */
    public String getUnit()
    {
        return getString("unit");
    }
    public void setUnit(String item)
    {
        setString("unit", item);
    }
    /**
     * Object:明细's 内部指标property 
     */
    public java.math.BigDecimal getInIndex()
    {
        return getBigDecimal("inIndex");
    }
    public void setInIndex(java.math.BigDecimal item)
    {
        setBigDecimal("inIndex", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("351C2EB6");
    }
}