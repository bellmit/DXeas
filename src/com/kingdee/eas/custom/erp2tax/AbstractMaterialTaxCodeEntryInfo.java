package com.kingdee.eas.custom.erp2tax;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaterialTaxCodeEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMaterialTaxCodeEntryInfo()
    {
        this("id");
    }
    protected AbstractMaterialTaxCodeEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 物料明细 's null property 
     */
    public com.kingdee.eas.custom.erp2tax.MaterialTaxCodeInfo getParent()
    {
        return (com.kingdee.eas.custom.erp2tax.MaterialTaxCodeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.erp2tax.MaterialTaxCodeInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 物料明细 's 物料编码 property 
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
     * Object:物料明细's 物料名称property 
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
     * Object:物料明细's 规格property 
     */
    public String getModel()
    {
        return getString("model");
    }
    public void setModel(String item)
    {
        setString("model", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C579FF38");
    }
}