package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDayRateCostDetailEntryDetailInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDayRateCostDetailEntryDetailInfo()
    {
        this("id");
    }
    protected AbstractDayRateCostDetailEntryDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 明细 's null property 
     */
    public com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryInfo getParent1()
    {
        return (com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object:明细's 项目idproperty 
     */
    public String getItemID()
    {
        return getString("itemID");
    }
    public void setItemID(String item)
    {
        setString("itemID", item);
    }
    /**
     * Object:明细's 项目编码property 
     */
    public String getItemNum()
    {
        return getString("itemNum");
    }
    public void setItemNum(String item)
    {
        setString("itemNum", item);
    }
    /**
     * Object:明细's 项目名称property 
     */
    public String getItemName()
    {
        return getString("itemName");
    }
    public void setItemName(String item)
    {
        setString("itemName", item);
    }
    /**
     * Object:明细's 数量property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:明细's 成本property 
     */
    public java.math.BigDecimal getCost()
    {
        return getBigDecimal("cost");
    }
    public void setCost(java.math.BigDecimal item)
    {
        setBigDecimal("cost", item);
    }
    /**
     * Object:明细's 单位成本property 
     */
    public java.math.BigDecimal getUnitCost()
    {
        return getBigDecimal("unitCost");
    }
    public void setUnitCost(java.math.BigDecimal item)
    {
        setBigDecimal("unitCost", item);
    }
    /**
     * Object: 明细 's 成本对象 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("costObject");
    }
    public void setCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("costObject", item);
    }
    /**
     * Object:明细's 基本单位数量property 
     */
    public java.math.BigDecimal getBaseQty()
    {
        return getBigDecimal("baseQty");
    }
    public void setBaseQty(java.math.BigDecimal item)
    {
        setBigDecimal("baseQty", item);
    }
    /**
     * Object: 明细 's 计量单位 property 
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
     * Object: 明细 's 基本计量单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getBaseUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("baseUnit");
    }
    public void setBaseUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("baseUnit", item);
    }
    /**
     * Object:明细's 单据idproperty 
     */
    public String getBillID()
    {
        return getString("billID");
    }
    public void setBillID(String item)
    {
        setString("billID", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F4B2A0AE");
    }
}