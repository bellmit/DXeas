package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDayRateCostDetailEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDayRateCostDetailEntryInfo()
    {
        this("id");
    }
    protected AbstractDayRateCostDetailEntryInfo(String pkField)
    {
        super(pkField);
        put("Detail", new com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryDetailCollection());
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.dayratecost.DayRateCostDetailInfo getParent()
    {
        return (com.kingdee.eas.farm.dayratecost.DayRateCostDetailInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.dayratecost.DayRateCostDetailInfo item)
    {
        put("parent", item);
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
     * Object: 分录 's 明细 property 
     */
    public com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryDetailCollection getDetail()
    {
        return (com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryDetailCollection)get("Detail");
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
     * Object:分录's 期末单位成本property 
     */
    public java.math.BigDecimal getUnitEndCost()
    {
        return getBigDecimal("unitEndCost");
    }
    public void setUnitEndCost(java.math.BigDecimal item)
    {
        setBigDecimal("unitEndCost", item);
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
     * Object:分录's 期初单位成本property 
     */
    public java.math.BigDecimal getUnitBeginCost()
    {
        return getBigDecimal("unitBeginCost");
    }
    public void setUnitBeginCost(java.math.BigDecimal item)
    {
        setBigDecimal("unitBeginCost", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("63E8CDFD");
    }
}