package com.kingdee.eas.custom.lhsm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSaleForecastEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSaleForecastEntryInfo()
    {
        this("id");
    }
    protected AbstractSaleForecastEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.lhsm.SaleForecastInfo getParent()
    {
        return (com.kingdee.eas.custom.lhsm.SaleForecastInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.lhsm.SaleForecastInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 物料编码 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterialNumber()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("materialNumber");
    }
    public void setMaterialNumber(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("materialNumber", item);
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
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getMeasureUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("measureUnit");
    }
    public void setMeasureUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("measureUnit", item);
    }
    /**
     * Object:分录's 基本数量property 
     */
    public java.math.BigDecimal getBaseQty()
    {
        return getBigDecimal("baseQty");
    }
    public void setBaseQty(java.math.BigDecimal item)
    {
        setBigDecimal("baseQty", item);
    }
    /**
     * Object:分录's 数量property 
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
     * Object:分录's 已分配数量property 
     */
    public java.math.BigDecimal getQtya()
    {
        return getBigDecimal("qtya");
    }
    public void setQtya(java.math.BigDecimal item)
    {
        setBigDecimal("qtya", item);
    }
    /**
     * Object:分录's 未分配数量property 
     */
    public java.math.BigDecimal getQtyb()
    {
        return getBigDecimal("qtyb");
    }
    public void setQtyb(java.math.BigDecimal item)
    {
        setBigDecimal("qtyb", item);
    }
    /**
     * Object:分录's 单价property 
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
     * Object:分录's 金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:分录's 基本单价property 
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
     * Object: 分录 's 基本单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getBaseUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("baseUnit");
    }
    public void setBaseUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("baseUnit", item);
    }
    /**
     * Object: 分录 's 意向公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:分录's 来源Idproperty 
     */
    public String getSourceEntryId()
    {
        return getString("sourceEntryId");
    }
    public void setSourceEntryId(String item)
    {
        setString("sourceEntryId", item);
    }
    /**
     * Object:分录's 溢价property 
     */
    public java.math.BigDecimal getPremium()
    {
        return getBigDecimal("premium");
    }
    public void setPremium(java.math.BigDecimal item)
    {
        setBigDecimal("premium", item);
    }
    /**
     * Object:分录's 规格property 
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
     * Object: 分录 's 辅助计量单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getAssistUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("assistUnit");
    }
    public void setAssistUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("assistUnit", item);
    }
    /**
     * Object:分录's 辅助计量单位数量property 
     */
    public java.math.BigDecimal getAssistUnitQty()
    {
        return getBigDecimal("assistUnitQty");
    }
    public void setAssistUnitQty(java.math.BigDecimal item)
    {
        setBigDecimal("assistUnitQty", item);
    }
    /**
     * Object:分录's 价内费用property 
     */
    public java.math.BigDecimal getInternalCost()
    {
        return getBigDecimal("internalCost");
    }
    public void setInternalCost(java.math.BigDecimal item)
    {
        setBigDecimal("internalCost", item);
    }
    /**
     * Object:分录's 净价property 
     */
    public java.math.BigDecimal getSuttlePrice()
    {
        return getBigDecimal("suttlePrice");
    }
    public void setSuttlePrice(java.math.BigDecimal item)
    {
        setBigDecimal("suttlePrice", item);
    }
    /**
     * Object: 分录 's 仓库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWareHouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("wareHouse");
    }
    public void setWareHouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("wareHouse", item);
    }
    /**
     * Object: 分录 's 物料组 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialGroupInfo getMaterialGroup()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialGroupInfo)get("materialGroup");
    }
    public void setMaterialGroup(com.kingdee.eas.basedata.master.material.MaterialGroupInfo item)
    {
        put("materialGroup", item);
    }
    /**
     * Object: 分录 's 物料价值分类 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialGroupInfo getMaterialGroupB()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialGroupInfo)get("materialGroupB");
    }
    public void setMaterialGroupB(com.kingdee.eas.basedata.master.material.MaterialGroupInfo item)
    {
        put("materialGroupB", item);
    }
    /**
     * Object:分录's 政策单价property 
     */
    public java.math.BigDecimal getSrcPrice()
    {
        return getBigDecimal("srcPrice");
    }
    public void setSrcPrice(java.math.BigDecimal item)
    {
        setBigDecimal("srcPrice", item);
    }
    /**
     * Object:分录's 溢价金额property 
     */
    public java.math.BigDecimal getPremiumAmount()
    {
        return getBigDecimal("premiumAmount");
    }
    public void setPremiumAmount(java.math.BigDecimal item)
    {
        setBigDecimal("premiumAmount", item);
    }
    /**
     * Object:分录's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B5CFF663");
    }
}