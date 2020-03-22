package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStatementsPolicySubsidyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStatementsPolicySubsidyEntryInfo()
    {
        this("id");
    }
    protected AbstractStatementsPolicySubsidyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ²¹Ìù·ÖÂ¼ 's null property 
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
     * Object: ²¹Ìù·ÖÂ¼ 's ²¹ÌùÕþ²ß±àÂë property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SubsidyInfo getPolicy()
    {
        return (com.kingdee.eas.farm.stocking.basedata.SubsidyInfo)get("policy");
    }
    public void setPolicy(com.kingdee.eas.farm.stocking.basedata.SubsidyInfo item)
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
        return new BOSObjectType("424585AE");
    }
}