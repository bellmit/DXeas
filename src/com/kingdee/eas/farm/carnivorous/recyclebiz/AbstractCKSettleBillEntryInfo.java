package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKSettleBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCKSettleBillEntryInfo()
    {
        this("id");
    }
    protected AbstractCKSettleBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 毛鸡回收 's 单据头 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:毛鸡回收's 回收类别property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.RecType getRecType()
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.RecType.getEnum(getString("recType"));
    }
    public void setRecType(com.kingdee.eas.farm.carnivorous.recyclebiz.RecType item)
    {
		if (item != null) {
        setString("recType", item.getValue());
		}
    }
    /**
     * Object:毛鸡回收's 只数property 
     */
    public int getQty()
    {
        return getInt("qty");
    }
    public void setQty(int item)
    {
        setInt("qty", item);
    }
    /**
     * Object:毛鸡回收's 重量property 
     */
    public java.math.BigDecimal getWeight()
    {
        return getBigDecimal("weight");
    }
    public void setWeight(java.math.BigDecimal item)
    {
        setBigDecimal("weight", item);
    }
    /**
     * Object:毛鸡回收's 单价property 
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
     * Object:毛鸡回收's 金额property 
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
     * Object:毛鸡回收's 均重property 
     */
    public java.math.BigDecimal getAverageWgt()
    {
        return getBigDecimal("averageWgt");
    }
    public void setAverageWgt(java.math.BigDecimal item)
    {
        setBigDecimal("averageWgt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C38F233B");
    }
}