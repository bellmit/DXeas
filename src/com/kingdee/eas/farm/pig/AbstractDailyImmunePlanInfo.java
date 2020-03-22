package com.kingdee.eas.farm.pig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDailyImmunePlanInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDailyImmunePlanInfo()
    {
        this("id");
    }
    protected AbstractDailyImmunePlanInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 日常免疫计划 's 组别 property 
     */
    public com.kingdee.eas.farm.pig.DailyImmunePlanTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.pig.DailyImmunePlanTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.pig.DailyImmunePlanTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:日常免疫计划's 猪类别property 
     */
    public com.kingdee.eas.farm.pig.PigFarmType getPigFarmType()
    {
        return com.kingdee.eas.farm.pig.PigFarmType.getEnum(getString("pigFarmType"));
    }
    public void setPigFarmType(com.kingdee.eas.farm.pig.PigFarmType item)
    {
		if (item != null) {
        setString("pigFarmType", item.getValue());
		}
    }
    /**
     * Object:日常免疫计划's 区分类别property 
     */
    public boolean isByPigFarmType()
    {
        return getBoolean("byPigFarmType");
    }
    public void setByPigFarmType(boolean item)
    {
        setBoolean("byPigFarmType", item);
    }
    /**
     * Object:日常免疫计划's 生效日期property 
     */
    public java.util.Date getActiveDate()
    {
        return getDate("activeDate");
    }
    public void setActiveDate(java.util.Date item)
    {
        setDate("activeDate", item);
    }
    /**
     * Object:日常免疫计划's 失效日期property 
     */
    public java.util.Date getDisableDate()
    {
        return getDate("disableDate");
    }
    public void setDisableDate(java.util.Date item)
    {
        setDate("disableDate", item);
    }
    /**
     * Object:日常免疫计划's 免疫开始日期property 
     */
    public java.util.Date getImmuneBeginDate()
    {
        return getDate("immuneBeginDate");
    }
    public void setImmuneBeginDate(java.util.Date item)
    {
        setDate("immuneBeginDate", item);
    }
    /**
     * Object:日常免疫计划's 免疫结束日期property 
     */
    public java.util.Date getImmuneEndDate()
    {
        return getDate("immuneEndDate");
    }
    public void setImmuneEndDate(java.util.Date item)
    {
        setDate("immuneEndDate", item);
    }
    /**
     * Object: 日常免疫计划 's 疫苗 property 
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
     * Object:日常免疫计划's 免疫方式property 
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
     * Object: 日常免疫计划 's 计量单位 property 
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
     * Object:日常免疫计划's 数量(单位/头)property 
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
     * Object:日常免疫计划's 状态property 
     */
    public com.kingdee.eas.farm.pig.DisableState getDeletedStatus()
    {
        return com.kingdee.eas.farm.pig.DisableState.getEnum(getInt("deletedStatus"));
    }
    public void setDeletedStatus(com.kingdee.eas.farm.pig.DisableState item)
    {
		if (item != null) {
        setInt("deletedStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DBAADF05");
    }
}