package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettlePolicySubsidyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettlePolicySubsidyEntryInfo()
    {
        this("id");
    }
    protected AbstractSettlePolicySubsidyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ²¹Ìù·ÖÂ¼ 's null property 
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
     * Object: ²¹Ìù·ÖÂ¼ 's ²¹ÌùÕþ²ß±àÂë property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SubsidyPolicyInfo getPolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SubsidyPolicyInfo)get("policy");
    }
    public void setPolicy(com.kingdee.eas.farm.carnivorous.basedata.SubsidyPolicyInfo item)
    {
        put("policy", item);
    }
    /**
     * Object:²¹Ìù·ÖÂ¼'s ²¹ÌùÕþ²ßÃû³Æproperty 
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
        return new BOSObjectType("2B9FEA26");
    }
}