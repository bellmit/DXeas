package com.kingdee.eas.custom.settlebill;

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
     * Object: 其它资料分录 's null property 
     */
    public com.kingdee.eas.custom.settlebill.SettleBillInfo getParent()
    {
        return (com.kingdee.eas.custom.settlebill.SettleBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.settlebill.SettleBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:其它资料分录's 重量property 
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
     * Object:其它资料分录's 单价property 
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
     * Object:其它资料分录's 金额property 
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
     * Object:其它资料分录's 只数property 
     */
    public int getQuantity()
    {
        return getInt("quantity");
    }
    public void setQuantity(int item)
    {
        setInt("quantity", item);
    }
    /**
     * Object: 其它资料分录 's 生物资产 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getBiologicalAssests()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("biologicalAssests");
    }
    public void setBiologicalAssests(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("biologicalAssests", item);
    }
    /**
     * Object:其它资料分录's 称重类型property 
     */
    public com.kingdee.eas.custom.taihe.weight.CarcassType getWgtType()
    {
        return com.kingdee.eas.custom.taihe.weight.CarcassType.getEnum(getString("wgtType"));
    }
    public void setWgtType(com.kingdee.eas.custom.taihe.weight.CarcassType item)
    {
		if (item != null) {
        setString("wgtType", item.getValue());
		}
    }
    /**
     * Object:其它资料分录's 折扣系数property 
     */
    public java.math.BigDecimal getDisRate()
    {
        return getBigDecimal("disRate");
    }
    public void setDisRate(java.math.BigDecimal item)
    {
        setBigDecimal("disRate", item);
    }
    /**
     * Object:其它资料分录's 折扣后重量property 
     */
    public java.math.BigDecimal getWgtAfterDis()
    {
        return getBigDecimal("wgtAfterDis");
    }
    public void setWgtAfterDis(java.math.BigDecimal item)
    {
        setBigDecimal("wgtAfterDis", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("67DD4E45");
    }
}