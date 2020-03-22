package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchContractDetailEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBatchContractDetailEntryInfo()
    {
        this("id");
    }
    protected AbstractBatchContractDetailEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 明细分录 's null property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 明细分录 's 饲料编码 property 
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
     * Object:明细分录's 饲料名称property 
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
     * Object:明细分录's 规格property 
     */
    public String getModel()
    {
        return getString("model");
    }
    public void setModel(String item)
    {
        setString("model", item);
    }
    /**
     * Object:明细分录's 基础价格property 
     */
    public java.math.BigDecimal getBasePrice()
    {
        return getBigDecimal("basePrice");
    }
    public void setBasePrice(java.math.BigDecimal item)
    {
        setBigDecimal("basePrice", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("21DEE0FA");
    }
}