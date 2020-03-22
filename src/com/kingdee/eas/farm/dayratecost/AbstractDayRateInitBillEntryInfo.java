package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDayRateInitBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDayRateInitBillEntryInfo()
    {
        this("id");
    }
    protected AbstractDayRateInitBillEntryInfo(String pkField)
    {
        super(pkField);
        put("EntryDetail", new com.kingdee.eas.farm.dayratecost.DayRateInitBillEntryEntryDetailCollection());
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.dayratecost.DayRateInitBillInfo getParent()
    {
        return (com.kingdee.eas.farm.dayratecost.DayRateInitBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.dayratecost.DayRateInitBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 成本项目 property 
     */
    public com.kingdee.eas.basedata.cm.CostItemInfo getCostItem()
    {
        return (com.kingdee.eas.basedata.cm.CostItemInfo)get("costItem");
    }
    public void setCostItem(com.kingdee.eas.basedata.cm.CostItemInfo item)
    {
        put("costItem", item);
    }
    /**
     * Object:分录's 期初成本property 
     */
    public java.math.BigDecimal getBeginCost()
    {
        return getBigDecimal("beginCost");
    }
    public void setBeginCost(java.math.BigDecimal item)
    {
        setBigDecimal("beginCost", item);
    }
    /**
     * Object:分录's 期初数量property 
     */
    public java.math.BigDecimal getBeginQty()
    {
        return getBigDecimal("beginQty");
    }
    public void setBeginQty(java.math.BigDecimal item)
    {
        setBigDecimal("beginQty", item);
    }
    /**
     * Object:分录's 期末成本property 
     */
    public java.math.BigDecimal getEndCost()
    {
        return getBigDecimal("endCost");
    }
    public void setEndCost(java.math.BigDecimal item)
    {
        setBigDecimal("endCost", item);
    }
    /**
     * Object:分录's 期末数量property 
     */
    public java.math.BigDecimal getEndQty()
    {
        return getBigDecimal("endQty");
    }
    public void setEndQty(java.math.BigDecimal item)
    {
        setBigDecimal("endQty", item);
    }
    /**
     * Object: 分录 's 单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("unit");
    }
    public void setUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("unit", item);
    }
    /**
     * Object:分录's 发生数量property 
     */
    public java.math.BigDecimal getOccurQty()
    {
        return getBigDecimal("occurQty");
    }
    public void setOccurQty(java.math.BigDecimal item)
    {
        setBigDecimal("occurQty", item);
    }
    /**
     * Object:分录's 发生成本property 
     */
    public java.math.BigDecimal getOccurCost()
    {
        return getBigDecimal("occurCost");
    }
    public void setOccurCost(java.math.BigDecimal item)
    {
        setBigDecimal("occurCost", item);
    }
    /**
     * Object:分录's 应收金额property 
     */
    public java.math.BigDecimal getArAmount()
    {
        return getBigDecimal("arAmount");
    }
    public void setArAmount(java.math.BigDecimal item)
    {
        setBigDecimal("arAmount", item);
    }
    /**
     * Object: 分录 's 成本明细 property 
     */
    public com.kingdee.eas.farm.dayratecost.DayRateInitBillEntryEntryDetailCollection getEntryDetail()
    {
        return (com.kingdee.eas.farm.dayratecost.DayRateInitBillEntryEntryDetailCollection)get("EntryDetail");
    }
    /**
     * Object:分录's 项目名称property 
     */
    public String getItemName()
    {
        return getString("ItemName");
    }
    public void setItemName(String item)
    {
        setString("ItemName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("56685124");
    }
}