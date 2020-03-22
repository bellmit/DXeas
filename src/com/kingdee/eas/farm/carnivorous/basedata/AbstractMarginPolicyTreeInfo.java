package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMarginPolicyTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractMarginPolicyTreeInfo()
    {
        this("id");
    }
    protected AbstractMarginPolicyTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 保证金政策组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("79F4D1E0");
    }
}