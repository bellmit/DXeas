package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettlePolicyRecycleEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettlePolicyRecycleEntryInfo()
    {
        this("id");
    }
    protected AbstractSettlePolicyRecycleEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �������� 's null property 
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
     * Object: �������� 's ���ϱ��� property 
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
     * Object:��������'s ��������property 
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
     * Object:��������'s ���property 
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
     * Object:��������'s ���յ���(Ԫ/����)property 
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
     * Object: �������� 's ������Ŀ property 
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
     * Object: �������� 's ������λ property 
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
     * Object:��������'s ��������ֵproperty 
     */
    public java.math.BigDecimal getMinValue()
    {
        return getBigDecimal("minValue");
    }
    public void setMinValue(java.math.BigDecimal item)
    {
        setBigDecimal("minValue", item);
    }
    /**
     * Object:��������'s ���ޱȽϷ�property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.LessSymbol getMaxSymbol()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.LessSymbol.getEnum(getString("maxSymbol"));
    }
    public void setMaxSymbol(com.kingdee.eas.farm.carnivorous.basedata.LessSymbol item)
    {
		if (item != null) {
        setString("maxSymbol", item.getValue());
		}
    }
    /**
     * Object:��������'s ��������ֵproperty 
     */
    public java.math.BigDecimal getMaxValue()
    {
        return getBigDecimal("maxValue");
    }
    public void setMaxValue(java.math.BigDecimal item)
    {
        setBigDecimal("maxValue", item);
    }
    /**
     * Object:��������'s �����property 
     */
    public java.math.BigDecimal getFmRate()
    {
        return getBigDecimal("fmRate");
    }
    public void setFmRate(java.math.BigDecimal item)
    {
        setBigDecimal("fmRate", item);
    }
    /**
     * Object:��������'s ���ޱȽϷ�property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.highSymbol getMinSymbol()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.highSymbol.getEnum(getString("minSymbol"));
    }
    public void setMinSymbol(com.kingdee.eas.farm.carnivorous.basedata.highSymbol item)
    {
		if (item != null) {
        setString("minSymbol", item.getValue());
		}
    }
    /**
     * Object:��������'s �Ƿ񰴵���ʵ�ʼ۸����property 
     */
    public boolean isIsUseAcualPrice()
    {
        return getBoolean("isUseAcualPrice");
    }
    public void setIsUseAcualPrice(boolean item)
    {
        setBoolean("isUseAcualPrice", item);
    }
    /**
     * Object:��������'s ë����������property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.recType getRecType()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.recType.getEnum(getString("recType"));
    }
    public void setRecType(com.kingdee.eas.farm.carnivorous.basedata.recType item)
    {
		if (item != null) {
        setString("recType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5951043E");
    }
}