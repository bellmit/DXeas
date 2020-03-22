package com.kingdee.eas.custom.taihe.sale;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractComplainedTypeTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractComplainedTypeTreeInfo()
    {
        this("id");
    }
    protected AbstractComplainedTypeTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 投诉类型组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.taihe.sale.ComplainedTypeTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.sale.ComplainedTypeTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.sale.ComplainedTypeTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("84EAAC27");
    }
}