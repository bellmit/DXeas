package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBHatchBabyBillSaleEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBHatchBabyBillSaleEntryInfo()
    {
        this("id");
    }
    protected AbstractBHatchBabyBillSaleEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 外销分录 's null property 
     */
    public com.kingdee.eas.farm.hatch.BHatchBabyBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.BHatchBabyBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.BHatchBabyBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 外销分录 's 客户 property 
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
     * Object:外销分录's 数量property 
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
     * Object:外销分录's 单价property 
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
     * Object: 外销分录 's 种苗 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4C24B3C2");
    }
}