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
     * Object: ���۷�¼ 's null property 
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
     * Object: ���۷�¼ 's ���ϱ��� property 
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
     * Object:���۷�¼'s ��������property 
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
     * Object:���۷�¼'s ����property 
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
     * Object:���۷�¼'s �Ƿ�Ĭ��property 
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