package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettlePolicyPriceEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettlePolicyPriceEntryInfo()
    {
        this("id");
    }
    protected AbstractSettlePolicyPriceEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 价格分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo item)
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
     * Object:价格分录's 基础价格property 
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
     * Object: 价格分录 's 结算项目 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo getSettlementItem()
    {
        return (com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo)get("settlementItem");
    }
    public void setSettlementItem(com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo item)
    {
        put("settlementItem", item);
    }
    /**
     * Object: 价格分录 's 单位 property 
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
     * Object:价格分录's 结算项目类别property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SettleItemType getSettleItemType()
    {
        return com.kingdee.eas.farm.stocking.basedata.SettleItemType.getEnum(getInt("settleItemType"));
    }
    public void setSettleItemType(com.kingdee.eas.farm.stocking.basedata.SettleItemType item)
    {
		if (item != null) {
        setInt("settleItemType", item.getValue());
		}
    }
    /**
     * Object:价格分录's 超药比例(%)property 
     */
    public java.math.BigDecimal getOverRate()
    {
        return getBigDecimal("overRate");
    }
    public void setOverRate(java.math.BigDecimal item)
    {
        setBigDecimal("overRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("99E1A308");
    }
}