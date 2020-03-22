package com.kingdee.eas.custom.festival;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFactoryCalendarEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFactoryCalendarEntryInfo()
    {
        this("id");
    }
    protected AbstractFactoryCalendarEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 基础资料分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.festival.FactoryCalendarInfo getParent()
    {
        return (com.kingdee.eas.custom.festival.FactoryCalendarInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.festival.FactoryCalendarInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:基础资料分录's 日期property 
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
     * Object: 基础资料分录 's 节日A property 
     */
    public com.kingdee.eas.custom.festival.HappyHolidayInfo getFestivalA()
    {
        return (com.kingdee.eas.custom.festival.HappyHolidayInfo)get("festivalA");
    }
    public void setFestivalA(com.kingdee.eas.custom.festival.HappyHolidayInfo item)
    {
        put("festivalA", item);
    }
    /**
     * Object: 基础资料分录 's 节日B property 
     */
    public com.kingdee.eas.custom.festival.HappyHolidayInfo getFestivalB()
    {
        return (com.kingdee.eas.custom.festival.HappyHolidayInfo)get("festivalB");
    }
    public void setFestivalB(com.kingdee.eas.custom.festival.HappyHolidayInfo item)
    {
        put("festivalB", item);
    }
    /**
     * Object:基础资料分录's 是否法定property 
     */
    public boolean isIsLegalFestivalA()
    {
        return getBoolean("isLegalFestivalA");
    }
    public void setIsLegalFestivalA(boolean item)
    {
        setBoolean("isLegalFestivalA", item);
    }
    /**
     * Object:基础资料分录's 是否法定property 
     */
    public boolean isIsLegalFestivalB()
    {
        return getBoolean("isLegalFestivalB");
    }
    public void setIsLegalFestivalB(boolean item)
    {
        setBoolean("isLegalFestivalB", item);
    }
    /**
     * Object: 基础资料分录 's 节日C property 
     */
    public com.kingdee.eas.custom.festival.HappyHolidayInfo getFestivalC()
    {
        return (com.kingdee.eas.custom.festival.HappyHolidayInfo)get("festivalC");
    }
    public void setFestivalC(com.kingdee.eas.custom.festival.HappyHolidayInfo item)
    {
        put("festivalC", item);
    }
    /**
     * Object:基础资料分录's 是否法定property 
     */
    public boolean isIsLegalFestivalC()
    {
        return getBoolean("isLegalFestivalC");
    }
    public void setIsLegalFestivalC(boolean item)
    {
        setBoolean("isLegalFestivalC", item);
    }
    /**
     * Object:基础资料分录's 节气property 
     */
    public String getSolarTerm()
    {
        return getString("solarTerm");
    }
    public void setSolarTerm(String item)
    {
        setString("solarTerm", item);
    }
    /**
     * Object:基础资料分录's 农历property 
     */
    public String getLunarCalendar()
    {
        return getString("lunarCalendar");
    }
    public void setLunarCalendar(String item)
    {
        setString("lunarCalendar", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E06E2375");
    }
}