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
     * Object: ��¼ 's ����ͷ property 
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
     * Object:��¼'s �ڳ��ɱ�property 
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
     * Object:��¼'s ��ĩ�ɱ�property 
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
     * Object: ��¼ 's ��ϸ property 
     */
    public com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryDetailCollection getDetail()
    {
        return (com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryDetailCollection)get("Detail");
    }
    /**
     * Object:��¼'s �����ɱ�property 
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
     * Object:��¼'s ��ĩ��λ�ɱ�property 
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
     * Object:��¼'s �ڳ�����property 
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
     * Object:��¼'s ��ĩ����property 
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
     * Object:��¼'s �ڳ���λ�ɱ�property 
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
     * Object:��¼'s ��������property 
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
     * Object: ��¼ 's �ɱ���Ŀ property 
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