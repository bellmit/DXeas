package com.kingdee.eas.custom.taihe.sale;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractComplainedTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractComplainedTypeInfo()
    {
        this("id");
    }
    protected AbstractComplainedTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 投诉类型 's 组别 property 
     */
    public com.kingdee.eas.custom.taihe.sale.ComplainedTypeTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.taihe.sale.ComplainedTypeTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.taihe.sale.ComplainedTypeTreeInfo item)
    {
        put("treeid", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("969F60E9");
    }
}