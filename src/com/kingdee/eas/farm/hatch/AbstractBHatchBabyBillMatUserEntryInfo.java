package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBHatchBabyBillMatUserEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBHatchBabyBillMatUserEntryInfo()
    {
        this("id");
    }
    protected AbstractBHatchBabyBillMatUserEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 物料领用 's null property 
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
     * Object: 物料领用 's 物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMatNum()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("matNum");
    }
    public void setMatNum(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("matNum", item);
    }
    /**
     * Object:物料领用's 物料名称property 
     */
    public String getMatName()
    {
        return getString("matName");
    }
    public void setMatName(String item)
    {
        setString("matName", item);
    }
    /**
     * Object:物料领用's 规格型号property 
     */
    public String getMatModel()
    {
        return getString("matModel");
    }
    public void setMatModel(String item)
    {
        setString("matModel", item);
    }
    /**
     * Object:物料领用's 基本计量单位property 
     */
    public String getMatUnit()
    {
        return getString("matUnit");
    }
    public void setMatUnit(String item)
    {
        setString("matUnit", item);
    }
    /**
     * Object:物料领用's 领用数量property 
     */
    public java.math.BigDecimal getMatQty()
    {
        return getBigDecimal("matQty");
    }
    public void setMatQty(java.math.BigDecimal item)
    {
        setBigDecimal("matQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DB643F30");
    }
}