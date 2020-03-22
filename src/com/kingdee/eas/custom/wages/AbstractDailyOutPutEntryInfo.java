package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDailyOutPutEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDailyOutPutEntryInfo()
    {
        this("id");
    }
    protected AbstractDailyOutPutEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.wages.DailyOutPutInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.DailyOutPutInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.DailyOutPutInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 员工编号 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object:分录's 员工名称property 
     */
    public String getPersonnumber()
    {
        return getString("personnumber");
    }
    public void setPersonnumber(String item)
    {
        setString("personnumber", item);
    }
    /**
     * Object: 分录 's 所属岗位 property 
     */
    public com.kingdee.eas.custom.wages.BasicPostInfo getFrompost()
    {
        return (com.kingdee.eas.custom.wages.BasicPostInfo)get("frompost");
    }
    public void setFrompost(com.kingdee.eas.custom.wages.BasicPostInfo item)
    {
        put("frompost", item);
    }
    /**
     * Object:分录's 产品系数property 
     */
    public java.math.BigDecimal getProductratio()
    {
        return getBigDecimal("productratio");
    }
    public void setProductratio(java.math.BigDecimal item)
    {
        setBigDecimal("productratio", item);
    }
    /**
     * Object:分录's 产量/数量property 
     */
    public com.kingdee.eas.custom.wages.UnitOfMetering getMeteunit()
    {
        return com.kingdee.eas.custom.wages.UnitOfMetering.getEnum(getString("meteunit"));
    }
    public void setMeteunit(com.kingdee.eas.custom.wages.UnitOfMetering item)
    {
		if (item != null) {
        setString("meteunit", item.getValue());
		}
    }
    /**
     * Object:分录's 加班时长property 
     */
    public java.math.BigDecimal getOvertime()
    {
        return getBigDecimal("overtime");
    }
    public void setOvertime(java.math.BigDecimal item)
    {
        setBigDecimal("overtime", item);
    }
    /**
     * Object:分录's 加班天数property 
     */
    public java.math.BigDecimal getOverday()
    {
        return getBigDecimal("overday");
    }
    public void setOverday(java.math.BigDecimal item)
    {
        setBigDecimal("overday", item);
    }
    /**
     * Object:分录's 日工资property 
     */
    public java.math.BigDecimal getDaywages()
    {
        return getBigDecimal("daywages");
    }
    public void setDaywages(java.math.BigDecimal item)
    {
        setBigDecimal("daywages", item);
    }
    /**
     * Object:分录's 是否旷工property 
     */
    public boolean isIsAbsenteeism()
    {
        return getBoolean("isAbsenteeism");
    }
    public void setIsAbsenteeism(boolean item)
    {
        setBoolean("isAbsenteeism", item);
    }
    /**
     * Object:分录's 是否事假property 
     */
    public boolean isIsLeave()
    {
        return getBoolean("isLeave");
    }
    public void setIsLeave(boolean item)
    {
        setBoolean("isLeave", item);
    }
    /**
     * Object:分录's 是否有温差补贴property 
     */
    public boolean isIsTemp()
    {
        return getBoolean("isTemp");
    }
    public void setIsTemp(boolean item)
    {
        setBoolean("isTemp", item);
    }
    /**
     * Object:分录's 是否是夜班property 
     */
    public boolean isIsNight()
    {
        return getBoolean("isNight");
    }
    public void setIsNight(boolean item)
    {
        setBoolean("isNight", item);
    }
    /**
     * Object:分录's 工作量property 
     */
    public java.math.BigDecimal getMnumber()
    {
        return getBigDecimal("mnumber");
    }
    public void setMnumber(java.math.BigDecimal item)
    {
        setBigDecimal("mnumber", item);
    }
    /**
     * Object:分录's 是否半天property 
     */
    public boolean isIsHelfday()
    {
        return getBoolean("isHelfday");
    }
    public void setIsHelfday(boolean item)
    {
        setBoolean("isHelfday", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("54F85840");
    }
}