package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCoutBillSettingMaterialEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCoutBillSettingMaterialEntryInfo()
    {
        this("id");
    }
    protected AbstractCoutBillSettingMaterialEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 基本物料 's null property 
     */
    public com.kingdee.eas.farm.food.CoutBillSettingInfo getParent()
    {
        return (com.kingdee.eas.farm.food.CoutBillSettingInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.food.CoutBillSettingInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 基本物料 's 物料编码 property 
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
     * Object:基本物料's 物料名称property 
     */
    public String getMaterlaName()
    {
        return getString("materlaName");
    }
    public void setMaterlaName(String item)
    {
        setString("materlaName", item);
    }
    /**
     * Object:基本物料's 规格型号property 
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
     * Object: 基本物料 's 计量单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("unit");
    }
    public void setUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("unit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D8DF0297");
    }
}