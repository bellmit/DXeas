package com.kingdee.eas.custom.festival;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFactoryCalendarInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFactoryCalendarInfo()
    {
        this("id");
    }
    protected AbstractFactoryCalendarInfo(String pkField)
    {
        super(pkField);
        put("AssEntrys", new com.kingdee.eas.custom.festival.FactoryCalendarAssEntryCollection());
        put("entrys", new com.kingdee.eas.custom.festival.FactoryCalendarEntryCollection());
        put("OtherEntrys", new com.kingdee.eas.custom.festival.FactoryCalendarOtherEntryCollection());
    }
    /**
     * Object: 厂历 's 基础资料分录 property 
     */
    public com.kingdee.eas.custom.festival.FactoryCalendarEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.festival.FactoryCalendarEntryCollection)get("entrys");
    }
    /**
     * Object: 厂历 's 辅助资料分录 property 
     */
    public com.kingdee.eas.custom.festival.FactoryCalendarAssEntryCollection getAssEntrys()
    {
        return (com.kingdee.eas.custom.festival.FactoryCalendarAssEntryCollection)get("AssEntrys");
    }
    /**
     * Object: 厂历 's 其它资料分录 property 
     */
    public com.kingdee.eas.custom.festival.FactoryCalendarOtherEntryCollection getOtherEntrys()
    {
        return (com.kingdee.eas.custom.festival.FactoryCalendarOtherEntryCollection)get("OtherEntrys");
    }
    /**
     * Object:厂历's 年份property 
     */
    public int getYear()
    {
        return getInt("year");
    }
    public void setYear(int item)
    {
        setInt("year", item);
    }
    /**
     * Object:厂历's 状态property 
     */
    public com.kingdee.eas.custom.festival.status getStatus()
    {
        return com.kingdee.eas.custom.festival.status.getEnum(getString("status"));
    }
    public void setStatus(com.kingdee.eas.custom.festival.status item)
    {
		if (item != null) {
        setString("status", item.getValue());
		}
    }
    /**
     * Object:厂历's 审核日期property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("auditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("auditDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("242A4AFD");
    }
}