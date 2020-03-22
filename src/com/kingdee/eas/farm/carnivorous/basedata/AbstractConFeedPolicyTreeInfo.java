package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractConFeedPolicyTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractConFeedPolicyTreeInfo()
    {
        this("id");
    }
    protected AbstractConFeedPolicyTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 连养政策组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8AEE20EE");
    }
}