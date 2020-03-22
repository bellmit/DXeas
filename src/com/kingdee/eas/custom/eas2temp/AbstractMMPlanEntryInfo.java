package com.kingdee.eas.custom.eas2temp;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMMPlanEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMMPlanEntryInfo()
    {
        this("id");
    }
    protected AbstractMMPlanEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.eas2temp.MMPlanInfo getParent()
    {
        return (com.kingdee.eas.custom.eas2temp.MMPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.eas2temp.MMPlanInfo item)
    {
        put("parent", item);
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
     * Object: 分录 's 产品编码 property 
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
     * Object:分录's 产品名称property 
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
     * Object:分录's 已执行数量property 
     */
    public java.math.BigDecimal getExedQty()
    {
        return getBigDecimal("exedQty");
    }
    public void setExedQty(java.math.BigDecimal item)
    {
        setBigDecimal("exedQty", item);
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
    /**
     * Object: 分录 's 配方名称 property 
     */
    public com.kingdee.eas.mm.basedata.BomInfo getBom()
    {
        return (com.kingdee.eas.mm.basedata.BomInfo)get("bom");
    }
    public void setBom(com.kingdee.eas.mm.basedata.BomInfo item)
    {
        put("bom", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A77AE2D5");
    }
}