package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAreaTargetTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractAreaTargetTreeInfo()
    {
        this("id");
    }
    protected AbstractAreaTargetTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 大区指标组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.salepayment.AreaTargetTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.AreaTargetTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.AreaTargetTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EFA25D30");
    }
}