package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSalerStimulateSetTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractSalerStimulateSetTreeInfo()
    {
        this("id");
    }
    protected AbstractSalerStimulateSetTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 销售提成设置组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.salepayment.SalerStimulateSetTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.SalerStimulateSetTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.SalerStimulateSetTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("67DBC681");
    }
}