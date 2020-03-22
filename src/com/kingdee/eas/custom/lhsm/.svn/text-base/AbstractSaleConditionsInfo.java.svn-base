package com.kingdee.eas.custom.lhsm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSaleConditionsInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSaleConditionsInfo()
    {
        this("id");
    }
    protected AbstractSaleConditionsInfo(String pkField)
    {
        super(pkField);
        put("AREntry", new com.kingdee.eas.custom.lhsm.SaleConditionsAREntryCollection());
        put("Entry", new com.kingdee.eas.custom.lhsm.SaleConditionsEntryCollection());
    }
    /**
     * Object: 销售条件过滤 's 用户 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getUser()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("user");
    }
    public void setUser(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("user", item);
    }
    /**
     * Object: 销售条件过滤 's 应收单 property 
     */
    public com.kingdee.eas.custom.lhsm.SaleConditionsAREntryCollection getAREntry()
    {
        return (com.kingdee.eas.custom.lhsm.SaleConditionsAREntryCollection)get("AREntry");
    }
    /**
     * Object: 销售条件过滤 's 预报单 property 
     */
    public com.kingdee.eas.custom.lhsm.SaleConditionsEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.lhsm.SaleConditionsEntryCollection)get("Entry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2D23430C");
    }
}