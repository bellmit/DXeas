package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettlePolicyAwardsEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettlePolicyAwardsEntryInfo()
    {
        this("id");
    }
    protected AbstractSettlePolicyAwardsEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 奖罚政策 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 奖罚政策 's 奖罚政策编码(废弃) property 
     */
    public com.kingdee.eas.farm.stocking.basedata.RewardsPolicyInfo getPolicy()
    {
        return (com.kingdee.eas.farm.stocking.basedata.RewardsPolicyInfo)get("policy");
    }
    public void setPolicy(com.kingdee.eas.farm.stocking.basedata.RewardsPolicyInfo item)
    {
        put("policy", item);
    }
    /**
     * Object:奖罚政策's 奖罚政策名称(废弃)property 
     */
    public String getPolicyName()
    {
        return getString("policyName");
    }
    public void setPolicyName(String item)
    {
        setString("policyName", item);
    }
    /**
     * Object: 奖罚政策 's 奖惩政策编码 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.RandPPolicyInfo getRandPPolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.RandPPolicyInfo)get("randPPolicy");
    }
    public void setRandPPolicy(com.kingdee.eas.farm.carnivorous.basedata.RandPPolicyInfo item)
    {
        put("randPPolicy", item);
    }
    /**
     * Object:奖罚政策's 奖惩政策名称property 
     */
    public String getRandPPolicyName()
    {
        return getString("randPPolicyName");
    }
    public void setRandPPolicyName(String item)
    {
        setString("randPPolicyName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("39BDDDDD");
    }
}