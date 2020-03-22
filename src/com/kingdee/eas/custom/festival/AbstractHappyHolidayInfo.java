package com.kingdee.eas.custom.festival;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHappyHolidayInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractHappyHolidayInfo()
    {
        this("id");
    }
    protected AbstractHappyHolidayInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 假日快乐 's 组别 property 
     */
    public com.kingdee.eas.custom.festival.HappyHolidayTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.festival.HappyHolidayTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.festival.HappyHolidayTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:假日快乐's 假日名称property 
     */
    public String getFestivalName()
    {
        return getString("festivalName");
    }
    public void setFestivalName(String item)
    {
        setString("festivalName", item);
    }
    /**
     * Object:假日快乐's 日期property 
     */
    public java.util.Date getDate()
    {
        return getDate("date");
    }
    public void setDate(java.util.Date item)
    {
        setDate("date", item);
    }
    /**
     * Object:假日快乐's 是否法定节假日property 
     */
    public boolean isIsLegalHolidays()
    {
        return getBoolean("isLegalHolidays");
    }
    public void setIsLegalHolidays(boolean item)
    {
        setBoolean("isLegalHolidays", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0B99D8E3");
    }
}