package com.kingdee.eas.custom.taihe.settle;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleBillOtherEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettleBillOtherEntryInfo()
    {
        this("id");
    }
    protected AbstractSettleBillOtherEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 其他 's null property 
     */
    public com.kingdee.eas.custom.taihe.settle.SettleBillInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.settle.SettleBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.settle.SettleBillInfo item)
    {
        put("parent", item);
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
    /**
     * Object: 其他 's 项目 property 
     */
    public com.kingdee.eas.custom.taihe.settle.ThSettleItemInfo getItem()
    {
        return (com.kingdee.eas.custom.taihe.settle.ThSettleItemInfo)get("item");
    }
    public void setItem(com.kingdee.eas.custom.taihe.settle.ThSettleItemInfo item)
    {
        put("item", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6CFC4897");
    }
}