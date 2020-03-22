package com.kingdee.eas.spray;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSparyRecordEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSparyRecordEntryInfo()
    {
        this("id");
    }
    protected AbstractSparyRecordEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.spray.SparyRecordInfo getParent()
    {
        return (com.kingdee.eas.spray.SparyRecordInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.spray.SparyRecordInfo item)
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
     * Object:分录's 规格型号property 
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
     * Object: 分录 's 喷涂设备 property 
     */
    public com.kingdee.eas.spray.DeviceDataInfo getDevice()
    {
        return (com.kingdee.eas.spray.DeviceDataInfo)get("device");
    }
    public void setDevice(com.kingdee.eas.spray.DeviceDataInfo item)
    {
        put("device", item);
    }
    /**
     * Object:分录's 时间property 
     */
    public java.util.Date getJustTime()
    {
        return getDate("justTime");
    }
    public void setJustTime(java.util.Date item)
    {
        setDate("justTime", item);
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
     * Object:分录's 使用数量property 
     */
    public java.math.BigDecimal getUseQty()
    {
        return getBigDecimal("useQty");
    }
    public void setUseQty(java.math.BigDecimal item)
    {
        setBigDecimal("useQty", item);
    }
    /**
     * Object:分录's 使用时间property 
     */
    public java.math.BigDecimal getUseTime()
    {
        return getBigDecimal("useTime");
    }
    public void setUseTime(java.math.BigDecimal item)
    {
        setBigDecimal("useTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2CC670A9");
    }
}