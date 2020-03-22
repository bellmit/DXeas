package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBHatchBabyBillGoEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBHatchBabyBillGoEntryInfo()
    {
        this("id");
    }
    protected AbstractBHatchBabyBillGoEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 去向登记 's null property 
     */
    public com.kingdee.eas.farm.hatch.BHatchBabyBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.BHatchBabyBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.BHatchBabyBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:去向登记's 去向方式property 
     */
    public com.kingdee.eas.farm.hatch.GoType getGoType()
    {
        return com.kingdee.eas.farm.hatch.GoType.getEnum(getString("goType"));
    }
    public void setGoType(com.kingdee.eas.farm.hatch.GoType item)
    {
		if (item != null) {
        setString("goType", item.getValue());
		}
    }
    /**
     * Object:去向登记's 去向单号property 
     */
    public String getBillNumber()
    {
        return getString("billNumber");
    }
    public void setBillNumber(String item)
    {
        setString("billNumber", item);
    }
    /**
     * Object: 去向登记 's 免疫药品 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getDrug()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("drug");
    }
    public void setDrug(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("drug", item);
    }
    /**
     * Object:去向登记's 规格型号property 
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
     * Object: 去向登记 's 计量单位 property 
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
     * Object:去向登记's 实用量property 
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
     * Object: 去向登记 's 服务项目 property 
     */
    public com.kingdee.eas.farm.hatch.ServiceItemsInfo getServiceItems()
    {
        return (com.kingdee.eas.farm.hatch.ServiceItemsInfo)get("serviceItems");
    }
    public void setServiceItems(com.kingdee.eas.farm.hatch.ServiceItemsInfo item)
    {
        put("serviceItems", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AD6E0D81");
    }
}