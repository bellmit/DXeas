package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDiscountGridLogEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDiscountGridLogEntryInfo()
    {
        this("id");
    }
    protected AbstractDiscountGridLogEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.salediscount.DiscountGridLogInfo getParent()
    {
        return (com.kingdee.eas.custom.salediscount.DiscountGridLogInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salediscount.DiscountGridLogInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 订单分录IDproperty 
     */
    public String getOrderEntryID()
    {
        return getString("orderEntryID");
    }
    public void setOrderEntryID(String item)
    {
        setString("orderEntryID", item);
    }
    /**
     * Object:分录's 订单分录序号property 
     */
    public int getOrderEntrySeq()
    {
        return getInt("orderEntrySeq");
    }
    public void setOrderEntrySeq(int item)
    {
        setInt("orderEntrySeq", item);
    }
    /**
     * Object:分录's 折让政策IDproperty 
     */
    public String getDiscountSetID()
    {
        return getString("discountSetID");
    }
    public void setDiscountSetID(String item)
    {
        setString("discountSetID", item);
    }
    /**
     * Object:分录's 政策分录IDproperty 
     */
    public String getDiscountSetEntryID()
    {
        return getString("discountSetEntryID");
    }
    public void setDiscountSetEntryID(String item)
    {
        setString("discountSetEntryID", item);
    }
    /**
     * Object:分录's 订单折让前数量property 
     */
    public java.math.BigDecimal getOrderEntryQty()
    {
        return getBigDecimal("orderEntryQty");
    }
    public void setOrderEntryQty(java.math.BigDecimal item)
    {
        setBigDecimal("orderEntryQty", item);
    }
    /**
     * Object:分录's 订单折让前金额property 
     */
    public java.math.BigDecimal getOrderEntryAmount()
    {
        return getBigDecimal("orderEntryAmount");
    }
    public void setOrderEntryAmount(java.math.BigDecimal item)
    {
        setBigDecimal("orderEntryAmount", item);
    }
    /**
     * Object:分录's 折让类别property 
     */
    public com.kingdee.eas.custom.salediscount.DiscountTypeEnum getDiscountType()
    {
        return com.kingdee.eas.custom.salediscount.DiscountTypeEnum.getEnum(getString("discountType"));
    }
    public void setDiscountType(com.kingdee.eas.custom.salediscount.DiscountTypeEnum item)
    {
		if (item != null) {
        setString("discountType", item.getValue());
		}
    }
    /**
     * Object:分录's 计算公式property 
     */
    public String getFomula()
    {
        return getString("fomula");
    }
    public void setFomula(String item)
    {
        setString("fomula", item);
    }
    /**
     * Object:分录's 折让数量property 
     */
    public java.math.BigDecimal getDsQuantity()
    {
        return getBigDecimal("dsQuantity");
    }
    public void setDsQuantity(java.math.BigDecimal item)
    {
        setBigDecimal("dsQuantity", item);
    }
    /**
     * Object:分录's 折让金额property 
     */
    public java.math.BigDecimal getDsAmount()
    {
        return getBigDecimal("dsAmount");
    }
    public void setDsAmount(java.math.BigDecimal item)
    {
        setBigDecimal("dsAmount", item);
    }
    /**
     * Object:分录's 订单IDproperty 
     */
    public String getOrderID()
    {
        return getString("orderID");
    }
    public void setOrderID(String item)
    {
        setString("orderID", item);
    }
    /**
     * Object:分录's 订单折让前吨数property 
     */
    public java.math.BigDecimal getOrderQtyT()
    {
        return getBigDecimal("orderQtyT");
    }
    public void setOrderQtyT(java.math.BigDecimal item)
    {
        setBigDecimal("orderQtyT", item);
    }
    /**
     * Object:分录's 折让数量（KG）property 
     */
    public java.math.BigDecimal getDsQuantityKg()
    {
        return getBigDecimal("dsQuantityKg");
    }
    public void setDsQuantityKg(java.math.BigDecimal item)
    {
        setBigDecimal("dsQuantityKg", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D1031250");
    }
}