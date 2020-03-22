package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOtherPaymentTypeTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractOtherPaymentTypeTreeInfo()
    {
        this("id");
    }
    protected AbstractOtherPaymentTypeTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 代付款类型组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.OtherPaymentTypeTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.OtherPaymentTypeTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.OtherPaymentTypeTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6B02D9BF");
    }
}