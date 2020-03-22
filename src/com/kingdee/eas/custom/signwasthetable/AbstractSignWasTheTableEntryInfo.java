package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSignWasTheTableEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSignWasTheTableEntryInfo()
    {
        this("id");
    }
    protected AbstractSignWasTheTableEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 明细 's null property 
     */
    public com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo getParent()
    {
        return (com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:明细's 金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("Amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("Amount", item);
    }
    /**
     * Object:明细's 说明property 
     */
    public String getStatement()
    {
        return getString("Statement");
    }
    public void setStatement(String item)
    {
        setString("Statement", item);
    }
    /**
     * Object:明细's 单价property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("Price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("Price", item);
    }
    /**
     * Object:明细's 数量property 
     */
    public java.math.BigDecimal getQuantity()
    {
        return getBigDecimal("Quantity");
    }
    public void setQuantity(java.math.BigDecimal item)
    {
        setBigDecimal("Quantity", item);
    }
    /**
     * Object:明细's 单位property 
     */
    public String getUnit()
    {
        return getString("Unit");
    }
    public void setUnit(String item)
    {
        setString("Unit", item);
    }
    /**
     * Object:明细's 项目property 
     */
    public String getProject()
    {
        return getString("Project");
    }
    public void setProject(String item)
    {
        setString("Project", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AED71213");
    }
}