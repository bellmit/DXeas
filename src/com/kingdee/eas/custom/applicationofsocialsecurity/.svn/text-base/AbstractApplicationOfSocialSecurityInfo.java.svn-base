package com.kingdee.eas.custom.applicationofsocialsecurity;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractApplicationOfSocialSecurityInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractApplicationOfSocialSecurityInfo()
    {
        this("id");
    }
    protected AbstractApplicationOfSocialSecurityInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityEntryCollection());
    }
    /**
     * Object: 社保申请 's 分录 property 
     */
    public com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityEntryCollection)get("entrys");
    }
    /**
     * Object:社保申请's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 社保申请 's 人员类别 property 
     */
    public com.kingdee.eas.custom.applicationofsocialsecurity.PersonTypeInfo getPersonType()
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.PersonTypeInfo)get("personType");
    }
    public void setPersonType(com.kingdee.eas.custom.applicationofsocialsecurity.PersonTypeInfo item)
    {
        put("personType", item);
    }
    /**
     * Object:社保申请's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object:社保申请's 单据状态property 
     */
    public com.kingdee.eas.custom.applicationofsocialsecurity.billStatus getBillStatus()
    {
        return com.kingdee.eas.custom.applicationofsocialsecurity.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.applicationofsocialsecurity.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object:社保申请's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("49DFE635");
    }
}