package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDiscountCustomerRelInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDiscountCustomerRelInfo()
    {
        this("id");
    }
    protected AbstractDiscountCustomerRelInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 客户关系 's 组别 property 
     */
    public com.kingdee.eas.custom.salediscount.DiscountCustomerRelTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.salediscount.DiscountCustomerRelTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.salediscount.DiscountCustomerRelTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 客户关系 's 客户 property 
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
     * Object: 客户关系 's 上级客户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getParentCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("parentCustomer");
    }
    public void setParentCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("parentCustomer", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F808C6FF");
    }
}