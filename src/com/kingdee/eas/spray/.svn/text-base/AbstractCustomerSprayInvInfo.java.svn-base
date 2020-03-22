package com.kingdee.eas.spray;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCustomerSprayInvInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCustomerSprayInvInfo()
    {
        this("id");
    }
    protected AbstractCustomerSprayInvInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.spray.CustomerSprayInvEntryCollection());
    }
    /**
     * Object: 客户喷涂余量 's 分录 property 
     */
    public com.kingdee.eas.spray.CustomerSprayInvEntryCollection getEntrys()
    {
        return (com.kingdee.eas.spray.CustomerSprayInvEntryCollection)get("entrys");
    }
    /**
     * Object:客户喷涂余量's 是否生成凭证property 
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
     * Object: 客户喷涂余量 's 客户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object:客户喷涂余量's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object: 客户喷涂余量 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompanyOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("companyOrgUnit");
    }
    public void setCompanyOrgUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("companyOrgUnit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FDC62FF5");
    }
}