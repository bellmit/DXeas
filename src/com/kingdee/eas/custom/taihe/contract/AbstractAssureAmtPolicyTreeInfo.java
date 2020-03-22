package com.kingdee.eas.custom.taihe.contract;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAssureAmtPolicyTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractAssureAmtPolicyTreeInfo()
    {
        this("id");
    }
    protected AbstractAssureAmtPolicyTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 保证金政策组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B5875735");
    }
}