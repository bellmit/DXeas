package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggPriceDataPriceEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractEggPriceDataPriceEntryInfo()
    {
        this("id");
    }
    protected AbstractEggPriceDataPriceEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 价格分录 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.EggPriceDataInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.EggPriceDataInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.EggPriceDataInfo item)
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
     * Object:价格分录's 浮动价格property 
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
     * Object: 价格分录 's 结算项目 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo getSettleItem()
    {
        return (com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo)get("settleItem");
    }
    public void setSettleItem(com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo item)
    {
        put("settleItem", item);
    }
    /**
     * Object:价格分录's 政策价格property 
     */
    public java.math.BigDecimal getBasePrice()
    {
        return getBigDecimal("basePrice");
    }
    public void setBasePrice(java.math.BigDecimal item)
    {
        setBigDecimal("basePrice", item);
    }
    /**
     * Object:价格分录's 当前价格property 
     */
    public java.math.BigDecimal getCurrentPrice()
    {
        return getBigDecimal("currentPrice");
    }
    public void setCurrentPrice(java.math.BigDecimal item)
    {
        setBigDecimal("currentPrice", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DDE23DE8");
    }
}