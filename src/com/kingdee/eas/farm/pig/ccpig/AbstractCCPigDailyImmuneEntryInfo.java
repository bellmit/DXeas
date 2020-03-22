package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCPigDailyImmuneEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCCPigDailyImmuneEntryInfo()
    {
        this("id");
    }
    protected AbstractCCPigDailyImmuneEntryInfo(String pkField)
    {
        super(pkField);
        put("ImmuneDetailEntry", new com.kingdee.eas.farm.pig.ccpig.CCPigDailyImmuneEntryImmuneDetailEntryCollection());
    }
    /**
     * Object: √‚“ﬂ∑÷¬º 's null property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.ccpig.CCPigDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: √‚“ﬂ∑÷¬º 's “ﬂ√Á property 
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
     * Object:√‚“ﬂ∑÷¬º's  π”√ ˝¡øproperty 
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
     * Object:√‚“ﬂ∑÷¬º's º∆¡øµ•Œªproperty 
     */
    public String getUnit()
    {
        return getString("unit");
    }
    public void setUnit(String item)
    {
        setString("unit", item);
    }
    /**
     * Object:√‚“ﬂ∑÷¬º's ±∏◊¢property 
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
     * Object:√‚“ﬂ∑÷¬º's “ﬂ√Á√˚≥∆property 
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
     * Object:√‚“ﬂ∑÷¬º's √‚“ﬂ∑Ω Ωproperty 
     */
    public com.kingdee.eas.farm.pig.ImmuneMode getImmuneMode()
    {
        return com.kingdee.eas.farm.pig.ImmuneMode.getEnum(getString("immuneMode"));
    }
    public void setImmuneMode(com.kingdee.eas.farm.pig.ImmuneMode item)
    {
		if (item != null) {
        setString("immuneMode", item.getValue());
		}
    }
    /**
     * Object: √‚“ﬂ∑÷¬º 's ÷Ì…· property 
     */
    public com.kingdee.eas.farm.pig.PigHouseInfo getPigHouse()
    {
        return (com.kingdee.eas.farm.pig.PigHouseInfo)get("pigHouse");
    }
    public void setPigHouse(com.kingdee.eas.farm.pig.PigHouseInfo item)
    {
        put("pigHouse", item);
    }
    /**
     * Object:√‚“ﬂ∑÷¬º's √‚“ﬂ“¿æ›property 
     */
    public com.kingdee.eas.farm.pig.immuneSourceType getImmuneSourceType()
    {
        return com.kingdee.eas.farm.pig.immuneSourceType.getEnum(getString("immuneSourceType"));
    }
    public void setImmuneSourceType(com.kingdee.eas.farm.pig.immuneSourceType item)
    {
		if (item != null) {
        setString("immuneSourceType", item.getValue());
		}
    }
    /**
     * Object: √‚“ﬂ∑÷¬º 's √‚“ﬂ√˜œ∏ property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigDailyImmuneEntryImmuneDetailEntryCollection getImmuneDetailEntry()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigDailyImmuneEntryImmuneDetailEntryCollection)get("ImmuneDetailEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7731A664");
    }
}