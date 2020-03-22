package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingPeriodPeriodEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStockingPeriodPeriodEntryInfo()
    {
        this("id");
    }
    protected AbstractStockingPeriodPeriodEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 期间分录 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingPeriodInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingPeriodInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.StockingPeriodInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 期间分录 's 期间 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    /**
     * Object:期间分录's 开始日期property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:期间分录's 结束日期property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EE943CD3");
    }
}