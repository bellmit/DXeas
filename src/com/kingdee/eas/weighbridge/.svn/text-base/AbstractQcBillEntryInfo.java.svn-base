package com.kingdee.eas.weighbridge;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractQcBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractQcBillEntryInfo()
    {
        this("id");
    }
    protected AbstractQcBillEntryInfo(String pkField)
    {
        super(pkField);
        put("Detail", new com.kingdee.eas.weighbridge.QcBillEntryDetailCollection());
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.weighbridge.QcBillInfo getParent()
    {
        return (com.kingdee.eas.weighbridge.QcBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.weighbridge.QcBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 物料编码 property 
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
     * Object:分录's 物料名称property 
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
     * Object: 分录 's 计量单位 property 
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
     * Object:分录's 过磅净重property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:分录's 水分（%）property 
     */
    public java.math.BigDecimal getWater()
    {
        return getBigDecimal("water");
    }
    public void setWater(java.math.BigDecimal item)
    {
        setBigDecimal("water", item);
    }
    /**
     * Object:分录's 杂质（%）property 
     */
    public java.math.BigDecimal getImpurity()
    {
        return getBigDecimal("impurity");
    }
    public void setImpurity(java.math.BigDecimal item)
    {
        setBigDecimal("impurity", item);
    }
    /**
     * Object:分录's 质检数量property 
     */
    public java.math.BigDecimal getQcQty()
    {
        return getBigDecimal("qcQty");
    }
    public void setQcQty(java.math.BigDecimal item)
    {
        setBigDecimal("qcQty", item);
    }
    /**
     * Object: 分录 's 明细记录 property 
     */
    public com.kingdee.eas.weighbridge.QcBillEntryDetailCollection getDetail()
    {
        return (com.kingdee.eas.weighbridge.QcBillEntryDetailCollection)get("Detail");
    }
    /**
     * Object:分录's 含税单价property 
     */
    public java.math.BigDecimal getTaxPrice()
    {
        return getBigDecimal("taxPrice");
    }
    public void setTaxPrice(java.math.BigDecimal item)
    {
        setBigDecimal("taxPrice", item);
    }
    /**
     * Object:分录's 质检含税单价property 
     */
    public java.math.BigDecimal getQcTaxPrice()
    {
        return getBigDecimal("qcTaxPrice");
    }
    public void setQcTaxPrice(java.math.BigDecimal item)
    {
        setBigDecimal("qcTaxPrice", item);
    }
    /**
     * Object:分录's 含税金额property 
     */
    public java.math.BigDecimal getAllAmount()
    {
        return getBigDecimal("allAmount");
    }
    public void setAllAmount(java.math.BigDecimal item)
    {
        setBigDecimal("allAmount", item);
    }
    /**
     * Object:分录's 质检含税金额property 
     */
    public java.math.BigDecimal getQcAllAmount()
    {
        return getBigDecimal("qcAllAmount");
    }
    public void setQcAllAmount(java.math.BigDecimal item)
    {
        setBigDecimal("qcAllAmount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5E1397FE");
    }
}