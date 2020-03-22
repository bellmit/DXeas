package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaterialStandardCostCostDetailEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMaterialStandardCostCostDetailEntryInfo()
    {
        this("id");
    }
    protected AbstractMaterialStandardCostCostDetailEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 成本明细 's null property 
     */
    public com.kingdee.eas.custom.salepayment.MaterialStandardCostInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.MaterialStandardCostInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.MaterialStandardCostInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 成本明细 's 物料 property 
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
     * Object:成本明细's 物料名称property 
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
     * Object:成本明细's 计量单位property 
     */
    public String getBaseUnit()
    {
        return getString("baseUnit");
    }
    public void setBaseUnit(String item)
    {
        setString("baseUnit", item);
    }
    /**
     * Object:成本明细's 标准成本property 
     */
    public java.math.BigDecimal getUnitCost()
    {
        return getBigDecimal("unitCost");
    }
    public void setUnitCost(java.math.BigDecimal item)
    {
        setBigDecimal("unitCost", item);
    }
    /**
     * Object:成本明细's 规格型号property 
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
        return new BOSObjectType("F922C1EF");
    }
}