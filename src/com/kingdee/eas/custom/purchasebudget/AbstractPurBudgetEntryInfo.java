package com.kingdee.eas.custom.purchasebudget;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPurBudgetEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPurBudgetEntryInfo()
    {
        this("id");
    }
    protected AbstractPurBudgetEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.purchasebudget.PurBudgetInfo getParent()
    {
        return (com.kingdee.eas.custom.purchasebudget.PurBudgetInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.purchasebudget.PurBudgetInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 一级类别property 
     */
    public String getTypeLvl1()
    {
        return getString("typeLvl1");
    }
    public void setTypeLvl1(String item)
    {
        setString("typeLvl1", item);
    }
    /**
     * Object:分录's 二级类别property 
     */
    public String getTypeLvl2()
    {
        return getString("typeLvl2");
    }
    public void setTypeLvl2(String item)
    {
        setString("typeLvl2", item);
    }
    /**
     * Object:分录's 品名property 
     */
    public String getMaterial()
    {
        return getString("material");
    }
    public void setMaterial(String item)
    {
        setString("material", item);
    }
    /**
     * Object:分录's 规格property 
     */
    public String getModel()
    {
        return getString("model");
    }
    public void setModel(String item)
    {
        setString("model", item);
    }
    /**
     * Object:分录's 单位property 
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
     * Object:分录's 数量property 
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
     * Object:分录's 单价property 
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
     * Object:分录's 金额property 
     */
    public java.math.BigDecimal getAmt()
    {
        return getBigDecimal("amt");
    }
    public void setAmt(java.math.BigDecimal item)
    {
        setBigDecimal("amt", item);
    }
    /**
     * Object:分录's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2C1B78DD");
    }
}