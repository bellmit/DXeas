package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeeTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFeeTypeInfo()
    {
        this("id");
    }
    protected AbstractFeeTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 费用类型 's 组别 property 
     */
    public com.kingdee.eas.custom.salepayment.FeeTypeTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.salepayment.FeeTypeTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.salepayment.FeeTypeTreeInfo item)
    {
        put("treeid", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1EA9126C");
    }
}