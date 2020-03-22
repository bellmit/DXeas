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
     * Object: ������������ 's �û� property 
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
     * Object: ������������ 's Ӧ�յ� property 
     */
    public com.kingdee.eas.custom.lhsm.SaleConditionsAREntryCollection getAREntry()
    {
        return (com.kingdee.eas.custom.lhsm.SaleConditionsAREntryCollection)get("AREntry");
    }
    /**
     * Object: ������������ 's Ԥ���� property 
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