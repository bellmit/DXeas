package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPlatformQuotationPriceEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPlatformQuotationPriceEntryInfo()
    {
        this("id");
    }
    protected AbstractPlatformQuotationPriceEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 报价分录 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.PlatformQuotationInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.PlatformQuotationInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.PlatformQuotationInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 报价分录 's 物料编码 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterialNum()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("materialNum");
    }
    public void setMaterialNum(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("materialNum", item);
    }
    /**
     * Object:报价分录's 物料名称property 
     */
    public String getMaterialName()
    {
        return getString("materialName");
    }
    public void setMaterialName(String item)
    {
        setString("materialName", item);
    }
    /**
     * Object:报价分录's 报价property 
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
     * Object:报价分录's 是否默认property 
     */
    public boolean isIsDefault()
    {
        return getBoolean("isDefault");
    }
    public void setIsDefault(boolean item)
    {
        setBoolean("isDefault", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0DADE5F1");
    }
}