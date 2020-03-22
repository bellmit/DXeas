package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRewardsPolicyTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractRewardsPolicyTreeInfo()
    {
        this("id");
    }
    protected AbstractRewardsPolicyTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 奖惩政策组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.RewardsPolicyTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.RewardsPolicyTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.RewardsPolicyTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7C956B03");
    }
}