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
     * Object:太合月工资计算单's 是否生成凭证property 
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
     * Object: 太合月工资计算单 's 公司 property 
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
     * Object:太合月工资计算单's 分值property 
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
     * Object: 太合月工资计算单 's 工资计算单分录 property 
     */
    public com.kingdee.eas.custom.wages.MonthWagesEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.wages.MonthWagesEntryCollection)get("Entry");
    }
    /**
     * Object:太合月工资计算单's 应出勤天数property 
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
     * Object:太合月工资计算单's 应出勤天数property 
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
     * Object:太合月工资计算单's 应出勤天数property 
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