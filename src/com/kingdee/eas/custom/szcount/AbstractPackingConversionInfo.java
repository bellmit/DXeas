package com.kingdee.eas.custom.szcount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPackingConversionInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractPackingConversionInfo()
    {
        this("id");
    }
    protected AbstractPackingConversionInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 包装换算关系 's 产成品物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterialProduct()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("materialProduct");
    }
    public void setMaterialProduct(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("materialProduct", item);
    }
    /**
     * Object:包装换算关系's 产成品编码property 
     */
    public String getProductNumber()
    {
        return getString("productNumber");
    }
    public void setProductNumber(String item)
    {
        setString("productNumber", item);
    }
    /**
     * Object: 包装换算关系 's 包装品物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterialPacking()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("materialPacking");
    }
    public void setMaterialPacking(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("materialPacking", item);
    }
    /**
     * Object:包装换算关系's 包装品编码property 
     */
    public String getPackingNumber()
    {
        return getString("packingNumber");
    }
    public void setPackingNumber(String item)
    {
        setString("packingNumber", item);
    }
    /**
     * Object:包装换算关系's 产成品规格型号property 
     */
    public String getProductModel()
    {
        return getString("productModel");
    }
    public void setProductModel(String item)
    {
        setString("productModel", item);
    }
    /**
     * Object:包装换算关系's 包装物规格型号property 
     */
    public String getPackingModel()
    {
        return getString("packingModel");
    }
    public void setPackingModel(String item)
    {
        setString("packingModel", item);
    }
    /**
     * Object:包装换算关系's 包装物对应产成品公斤数(KG)property 
     */
    public java.math.BigDecimal getPackingtoProduct()
    {
        return getBigDecimal("packingtoProduct");
    }
    public void setPackingtoProduct(java.math.BigDecimal item)
    {
        setBigDecimal("packingtoProduct", item);
    }
    /**
     * Object: 包装换算关系 's 包装物料2 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterialPacking2()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("materialPacking2");
    }
    public void setMaterialPacking2(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("materialPacking2", item);
    }
    /**
     * Object:包装换算关系's 包装品2编码property 
     */
    public String getMaterialPackingN()
    {
        return getString("materialPackingN");
    }
    public void setMaterialPackingN(String item)
    {
        setString("materialPackingN", item);
    }
    /**
     * Object:包装换算关系's 包装物2对应产成品公斤数property 
     */
    public java.math.BigDecimal getContpackingtoProduct2()
    {
        return getBigDecimal("contpackingtoProduct2");
    }
    public void setContpackingtoProduct2(java.math.BigDecimal item)
    {
        setBigDecimal("contpackingtoProduct2", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2640A314");
    }
}