package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDiscountCustomerRelTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractDiscountCustomerRelTreeInfo()
    {
        this("id");
    }
    protected AbstractDiscountCustomerRelTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 客户关系组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.salediscount.DiscountCustomerRelTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.salediscount.DiscountCustomerRelTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salediscount.DiscountCustomerRelTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A867173D");
    }
}