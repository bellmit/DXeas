package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDiscountCompanyTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractDiscountCompanyTreeInfo()
    {
        this("id");
    }
    protected AbstractDiscountCompanyTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 折让公司组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.salediscount.DiscountCompanyTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.salediscount.DiscountCompanyTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salediscount.DiscountCompanyTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("435B18DF");
    }
}