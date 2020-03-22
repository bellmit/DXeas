package com.kingdee.eas.bdm.bdapply;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractUserReqInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractUserReqInfo()
    {
        this("id");
    }
    protected AbstractUserReqInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 用户申请 's 职员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object: 用户申请 's 部门 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getPersonDepart()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("personDepart");
    }
    public void setPersonDepart(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("personDepart", item);
    }
    /**
     * Object:用户申请's 权限描述property 
     */
    public String getAuthDescription()
    {
        return getString("authDescription");
    }
    public void setAuthDescription(String item)
    {
        setString("authDescription", item);
    }
    /**
     * Object:用户申请's 审核时间property 
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
     * Object:用户申请's 状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object:用户申请's 账号组织范围描述property 
     */
    public String getOrgRange()
    {
        return getString("orgRange");
    }
    public void setOrgRange(String item)
    {
        setString("orgRange", item);
    }
    /**
     * Object:用户申请's 需要企业邮箱property 
     */
    public boolean isUseEmail()
    {
        return getBoolean("useEmail");
    }
    public void setUseEmail(boolean item)
    {
        setBoolean("useEmail", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B10EA07C");
    }
}