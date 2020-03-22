package com.kingdee.eas.weighbridge;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettingEntryMaterialEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettingEntryMaterialEntryInfo()
    {
        this("id");
    }
    protected AbstractSettingEntryMaterialEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 物料范围 's null property 
     */
    public com.kingdee.eas.weighbridge.SettingEntryInfo getParent1()
    {
        return (com.kingdee.eas.weighbridge.SettingEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.weighbridge.SettingEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object: 物料范围 's 物料编码 property 
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
     * Object:物料范围's 物料名称property 
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
     * Object:物料范围's 规格型号property 
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
        return new BOSObjectType("2E6EEF2E");
    }
}