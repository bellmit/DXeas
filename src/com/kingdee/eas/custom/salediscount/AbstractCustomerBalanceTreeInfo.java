package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCustomerBalanceTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractCustomerBalanceTreeInfo()
    {
        this("id");
    }
    protected AbstractCustomerBalanceTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 客户折让余额组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.salediscount.CustomerBalanceTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.salediscount.CustomerBalanceTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salediscount.CustomerBalanceTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("26BD2501");
    }
}