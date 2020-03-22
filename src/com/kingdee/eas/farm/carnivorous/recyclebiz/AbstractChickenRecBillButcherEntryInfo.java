package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractChickenRecBillButcherEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractChickenRecBillButcherEntryInfo()
    {
        this("id");
    }
    protected AbstractChickenRecBillButcherEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 屠宰信息 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:屠宰信息's 胴体只数property 
     */
    public java.math.BigDecimal getCarcassQty()
    {
        return getBigDecimal("carcassQty");
    }
    public void setCarcassQty(java.math.BigDecimal item)
    {
        setBigDecimal("carcassQty", item);
    }
    /**
     * Object:屠宰信息's 胴体重量(斤)property 
     */
    public java.math.BigDecimal getCarcassWeight()
    {
        return getBigDecimal("carcassWeight");
    }
    public void setCarcassWeight(java.math.BigDecimal item)
    {
        setBigDecimal("carcassWeight", item);
    }
    /**
     * Object:屠宰信息's 折算毛鸡重量(斤)property 
     */
    public java.math.BigDecimal getReducedWeight()
    {
        return getBigDecimal("reducedWeight");
    }
    public void setReducedWeight(java.math.BigDecimal item)
    {
        setBigDecimal("reducedWeight", item);
    }
    /**
     * Object:屠宰信息's 出成率(%)property 
     */
    public java.math.BigDecimal getAliveRate()
    {
        return getBigDecimal("aliveRate");
    }
    public void setAliveRate(java.math.BigDecimal item)
    {
        setBigDecimal("aliveRate", item);
    }
    /**
     * Object: 屠宰信息 's 销售客户 property 
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
     * Object:屠宰信息's 销售毛鸡价格(元/斤)property 
     */
    public java.math.BigDecimal getSaleChickPrice()
    {
        return getBigDecimal("saleChickPrice");
    }
    public void setSaleChickPrice(java.math.BigDecimal item)
    {
        setBigDecimal("saleChickPrice", item);
    }
    /**
     * Object:屠宰信息's 销售金额property 
     */
    public java.math.BigDecimal getSaleAmount()
    {
        return getBigDecimal("saleAmount");
    }
    public void setSaleAmount(java.math.BigDecimal item)
    {
        setBigDecimal("saleAmount", item);
    }
    /**
     * Object:屠宰信息's 销售数量(斤)property 
     */
    public java.math.BigDecimal getSaleQty()
    {
        return getBigDecimal("saleQty");
    }
    public void setSaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("saleQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("65F6FF1E");
    }
}