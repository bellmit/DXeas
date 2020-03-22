package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTechnicianCustomerEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTechnicianCustomerEntryInfo()
    {
        this("id");
    }
    protected AbstractTechnicianCustomerEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 负责客户 's null property 
     */
    public com.kingdee.eas.custom.salepayment.TechnicianInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.TechnicianInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.TechnicianInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 负责客户 's 客户 property 
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
     * Object:负责客户's 客户名称property 
     */
    public String getCustomerName()
    {
        return getString("customerName");
    }
    public void setCustomerName(String item)
    {
        setString("customerName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2921BABC");
    }
}