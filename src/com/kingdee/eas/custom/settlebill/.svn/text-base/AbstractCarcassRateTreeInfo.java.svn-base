package com.kingdee.eas.custom.settlebill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarcassRateTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractCarcassRateTreeInfo()
    {
        this("id");
    }
    protected AbstractCarcassRateTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 胴体出成折算标准组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.settlebill.CarcassRateTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.settlebill.CarcassRateTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.settlebill.CarcassRateTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B3F85BBF");
    }
}