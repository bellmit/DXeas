package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMonthWagesInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractMonthWagesInfo()
    {
        this("id");
    }
    protected AbstractMonthWagesInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.wages.MonthWagesEntryCollection());
    }
    /**
     * Object:̫���¹��ʼ��㵥's �Ƿ�����ƾ֤property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: ̫���¹��ʼ��㵥 's ��˾ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:̫���¹��ʼ��㵥's ��ֵproperty 
     */
    public java.math.BigDecimal getScore()
    {
        return getBigDecimal("score");
    }
    public void setScore(java.math.BigDecimal item)
    {
        setBigDecimal("score", item);
    }
    /**
     * Object: ̫���¹��ʼ��㵥 's ���ʼ��㵥��¼ property 
     */
    public com.kingdee.eas.custom.wages.MonthWagesEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.wages.MonthWagesEntryCollection)get("Entry");
    }
    /**
     * Object:̫���¹��ʼ��㵥's Ӧ��������property 
     */
    public int getWorkDays()
    {
        return getInt("workDays");
    }
    public void setWorkDays(int item)
    {
        setInt("workDays", item);
    }
    /**
     * Object:̫���¹��ʼ��㵥's Ӧ��������property 
     */
    public java.math.BigDecimal getWorkDay()
    {
        return getBigDecimal("workDay");
    }
    public void setWorkDay(java.math.BigDecimal item)
    {
        setBigDecimal("workDay", item);
    }
    /**
     * Object:̫���¹��ʼ��㵥's Ӧ��������property 
     */
    public java.math.BigDecimal getWorkDayss()
    {
        return getBigDecimal("workDayss");
    }
    public void setWorkDayss(java.math.BigDecimal item)
    {
        setBigDecimal("workDayss", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B43603B3");
    }
}