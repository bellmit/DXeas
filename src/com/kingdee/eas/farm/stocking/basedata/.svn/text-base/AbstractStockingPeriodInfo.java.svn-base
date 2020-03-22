package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingPeriodInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractStockingPeriodInfo()
    {
        this("id");
    }
    protected AbstractStockingPeriodInfo(String pkField)
    {
        super(pkField);
        put("PeriodEntry", new com.kingdee.eas.farm.stocking.basedata.StockingPeriodPeriodEntryCollection());
    }
    /**
     * Object: 期间定义 's 财务组织 property 
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
     * Object: 期间定义 's 期间分录 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingPeriodPeriodEntryCollection getPeriodEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingPeriodPeriodEntryCollection)get("PeriodEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("264A037E");
    }
}