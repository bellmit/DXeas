package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStatementsBillOtherEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStatementsBillOtherEntryInfo()
    {
        this("id");
    }
    protected AbstractStatementsBillOtherEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 其他 's null property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:其他's 项目名称property 
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
     * Object:其他's 金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:其他's 数量property 
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
     * Object:其他's 备注property 
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
        return new BOSObjectType("3FFC7512");
    }
}