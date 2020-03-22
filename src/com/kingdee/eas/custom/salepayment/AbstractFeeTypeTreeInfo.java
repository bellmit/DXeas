package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeeTypeTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractFeeTypeTreeInfo()
    {
        this("id");
    }
    protected AbstractFeeTypeTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 费用类型组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.salepayment.FeeTypeTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.FeeTypeTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.FeeTypeTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A5E9E42A");
    }
}