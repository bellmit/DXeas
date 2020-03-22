package com.kingdee.eas.spray;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCustomerSprayInvEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCustomerSprayInvEntryInfo()
    {
        this("id");
    }
    protected AbstractCustomerSprayInvEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.spray.CustomerSprayInvInfo getParent()
    {
        return (com.kingdee.eas.spray.CustomerSprayInvInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.spray.CustomerSprayInvInfo item)
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
     * Object:分录's 可以时间余量(分钟)property 
     */
    public java.math.BigDecimal getInvTime()
    {
        return getBigDecimal("invTime");
    }
    public void setInvTime(java.math.BigDecimal item)
    {
        setBigDecimal("invTime", item);
    }
    /**
     * Object:分录's 可用数量余量(Kg)property 
     */
    public java.math.BigDecimal getInvQty()
    {
        return getBigDecimal("invQty");
    }
    public void setInvQty(java.math.BigDecimal item)
    {
        setBigDecimal("invQty", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("87D2997D");
    }
}