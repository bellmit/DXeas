package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedStandardDrugEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedStandardDrugEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedStandardDrugEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: √‚“ﬂπÊ∑∂ 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:√‚“ﬂπÊ∑∂'s ÷‹¡‰property 
     */
    public int getWeek()
    {
        return getInt("week");
    }
    public void setWeek(int item)
    {
        setInt("week", item);
    }
    /**
     * Object:√‚“ﬂπÊ∑∂'s »’¡‰property 
     */
    public int getDays()
    {
        return getInt("days");
    }
    public void setDays(int item)
    {
        setInt("days", item);
    }
    /**
     * Object: √‚“ﬂπÊ∑∂ 's “©∆∑±‡¬Î property 
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
     * Object:√‚“ﬂπÊ∑∂'s “©∆∑√˚≥∆property 
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
     * Object:√‚“ﬂπÊ∑∂'s πÊ∏Òproperty 
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
     * Object: √‚“ﬂπÊ∑∂ 's µ•Œª property 
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
     * Object:√‚“ﬂπÊ∑∂'s ”√¡øproperty 
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
     * Object:√‚“ﬂπÊ∑∂'s Ω· ¯÷‹¡‰property 
     */
    public int getEndWeek()
    {
        return getInt("endWeek");
    }
    public void setEndWeek(int item)
    {
        setInt("endWeek", item);
    }
    /**
     * Object:√‚“ﬂπÊ∑∂'s Ω· ¯»’¡‰property 
     */
    public int getEndDays()
    {
        return getInt("endDays");
    }
    public void setEndDays(int item)
    {
        setInt("endDays", item);
    }
    /**
     * Object:√‚“ﬂπÊ∑∂'s ±∏◊¢property 
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
     * Object:√‚“ﬂπÊ∑∂'s ∂æ÷Íproperty 
     */
    public String getStrain()
    {
        return getString("strain");
    }
    public void setStrain(String item)
    {
        setString("strain", item);
    }
    /**
     * Object: √‚“ﬂπÊ∑∂ 's √‚“ﬂÕææ∂ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.ImmuneWayInfo getVaccineWay()
    {
        return (com.kingdee.eas.farm.stocking.basedata.ImmuneWayInfo)get("vaccineWay");
    }
    public void setVaccineWay(com.kingdee.eas.farm.stocking.basedata.ImmuneWayInfo item)
    {
        put("vaccineWay", item);
    }
    /**
     * Object:√‚“ﬂπÊ∑∂'s “ﬂ√Á≥ßº“property 
     */
    public String getManufacturer()
    {
        return getString("manufacturer");
    }
    public void setManufacturer(String item)
    {
        setString("manufacturer", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C82AA7F2");
    }
}