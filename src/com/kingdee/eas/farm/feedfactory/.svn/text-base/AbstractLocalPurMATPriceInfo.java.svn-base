package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLocalPurMATPriceInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractLocalPurMATPriceInfo()
    {
        this("id");
    }
    protected AbstractLocalPurMATPriceInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.feedfactory.LocalPurMATPriceEntryCollection());
    }
    /**
     * Object: 本地收购物料价格维护 's 公司 property 
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
     * Object: 本地收购物料价格维护 's 价格分录 property 
     */
    public com.kingdee.eas.farm.feedfactory.LocalPurMATPriceEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.feedfactory.LocalPurMATPriceEntryCollection)get("Entry");
    }
    /**
     * Object:本地收购物料价格维护's 生效日期property 
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
     * Object:本地收购物料价格维护's 失效日期property 
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
        return new BOSObjectType("E580676D");
    }
}