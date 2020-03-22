package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInsteadSeedPriceDataPriceEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractInsteadSeedPriceDataPriceEntryInfo()
    {
        this("id");
    }
    protected AbstractInsteadSeedPriceDataPriceEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 价格分录 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 价格分录 's 物料名称 property 
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
     * Object:价格分录's 规格property 
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
     * Object: 价格分录 's 计量单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("unit");
    }
    public void setUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("unit", item);
    }
    /**
     * Object:价格分录's 执行价格property 
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
     * Object:价格分录's 物料编码property 
     */
    public String getMaterialNum()
    {
        return getString("materialNum");
    }
    public void setMaterialNum(String item)
    {
        setString("materialNum", item);
    }
    /**
     * Object:价格分录's 报价property 
     */
    public java.math.BigDecimal getOfferPrice()
    {
        return getBigDecimal("offerPrice");
    }
    public void setOfferPrice(java.math.BigDecimal item)
    {
        setBigDecimal("offerPrice", item);
    }
    /**
     * Object:价格分录's 限价property 
     */
    public java.math.BigDecimal getLimitPrice()
    {
        return getBigDecimal("limitPrice");
    }
    public void setLimitPrice(java.math.BigDecimal item)
    {
        setBigDecimal("limitPrice", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0259A15A");
    }
}