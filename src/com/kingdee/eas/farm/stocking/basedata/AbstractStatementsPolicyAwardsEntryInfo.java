package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStatementsPolicyAwardsEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStatementsPolicyAwardsEntryInfo()
    {
        this("id");
    }
    protected AbstractStatementsPolicyAwardsEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 奖罚政策 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 奖罚政策 's 奖罚政策编码 property 
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
     * Object:奖罚政策's 奖罚政策名称property 
     */
    public String getPolicyName()
    {
        return getString("policyName");
    }
    public void setPolicyName(String item)
    {
        setString("policyName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("21B2B155");
    }
}