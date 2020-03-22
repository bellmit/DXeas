package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLocalPurMATPriceEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLocalPurMATPriceEntryInfo()
    {
        this("id");
    }
    protected AbstractLocalPurMATPriceEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 价格分录 's null property 
     */
    public com.kingdee.eas.farm.feedfactory.LocalPurMATPriceInfo getParent()
    {
        return (com.kingdee.eas.farm.feedfactory.LocalPurMATPriceInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feedfactory.LocalPurMATPriceInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 价格分录 's 物料编码 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:价格分录's 物料名称property 
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
     * Object: 价格分录 's 默认供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object:价格分录's 备注property 
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
     * Object:价格分录's 价格property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0BA84D05");
    }
}