package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCPigBreedModelImmuneEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCCPigBreedModelImmuneEntryInfo()
    {
        this("id");
    }
    protected AbstractCCPigBreedModelImmuneEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 免疫计划 's null property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 免疫计划 's 疫苗 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getImmuneMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("immuneMaterial");
    }
    public void setImmuneMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("immuneMaterial", item);
    }
    /**
     * Object:免疫计划's 单位property 
     */
    public String getImmuneBaseUnit()
    {
        return getString("immuneBaseUnit");
    }
    public void setImmuneBaseUnit(String item)
    {
        setString("immuneBaseUnit", item);
    }
    /**
     * Object:免疫计划's 数量(单位/头)property 
     */
    public java.math.BigDecimal getQtyPer()
    {
        return getBigDecimal("qtyPer");
    }
    public void setQtyPer(java.math.BigDecimal item)
    {
        setBigDecimal("qtyPer", item);
    }
    /**
     * Object:免疫计划's 开始日龄property 
     */
    public int getBeginDays()
    {
        return getInt("beginDays");
    }
    public void setBeginDays(int item)
    {
        setInt("beginDays", item);
    }
    /**
     * Object:免疫计划's 结束日龄property 
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
     * Object:免疫计划's 备注property 
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
     * Object:免疫计划's 免疫方式property 
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
     * Object:免疫计划's 提前预警天数property 
     */
    public int getWarnAheadDays()
    {
        return getInt("warnAheadDays");
    }
    public void setWarnAheadDays(int item)
    {
        setInt("warnAheadDays", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7879BC8C");
    }
}