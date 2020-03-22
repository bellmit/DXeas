package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractGrossProfitInfoEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractGrossProfitInfoEntryInfo()
    {
        this("id");
    }
    protected AbstractGrossProfitInfoEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 客户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object: 分录 's 物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object: 分录 's 计量单位 property 
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
     * Object:分录's 销量property 
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
     * Object:分录's 不含税金额property 
     */
    public java.math.BigDecimal getNoTaxAmount()
    {
        return getBigDecimal("noTaxAmount");
    }
    public void setNoTaxAmount(java.math.BigDecimal item)
    {
        setBigDecimal("noTaxAmount", item);
    }
    /**
     * Object:分录's 含税金额property 
     */
    public java.math.BigDecimal getTaxAmount()
    {
        return getBigDecimal("taxAmount");
    }
    public void setTaxAmount(java.math.BigDecimal item)
    {
        setBigDecimal("taxAmount", item);
    }
    /**
     * Object:分录's 不含税单价property 
     */
    public java.math.BigDecimal getNoTaxPrice()
    {
        return getBigDecimal("noTaxPrice");
    }
    public void setNoTaxPrice(java.math.BigDecimal item)
    {
        setBigDecimal("noTaxPrice", item);
    }
    /**
     * Object:分录's 含税单价property 
     */
    public java.math.BigDecimal getTaxPrice()
    {
        return getBigDecimal("taxPrice");
    }
    public void setTaxPrice(java.math.BigDecimal item)
    {
        setBigDecimal("taxPrice", item);
    }
    /**
     * Object:分录's 单位标准成本property 
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
     * Object:分录's 总标准成本property 
     */
    public java.math.BigDecimal getAllCoat()
    {
        return getBigDecimal("allCoat");
    }
    public void setAllCoat(java.math.BigDecimal item)
    {
        setBigDecimal("allCoat", item);
    }
    /**
     * Object:分录's 毛利润property 
     */
    public java.math.BigDecimal getGrossProfit()
    {
        return getBigDecimal("grossProfit");
    }
    public void setGrossProfit(java.math.BigDecimal item)
    {
        setBigDecimal("grossProfit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5AC45C90");
    }
}