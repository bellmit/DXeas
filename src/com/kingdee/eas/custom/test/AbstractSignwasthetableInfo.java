package com.kingdee.eas.custom.test;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSignwasthetableInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSignwasthetableInfo()
    {
        this("id");
    }
    protected AbstractSignwasthetableInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.test.SignwasthetableEntryCollection());
    }
    /**
     * Object:Signwasthetable's 是否生成凭证property 
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
     * Object: Signwasthetable 's 受文者 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getAddresses()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("addresses");
    }
    public void setAddresses(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("addresses", item);
    }
    /**
     * Object: Signwasthetable 's 呈送者 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPresentedPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("presentedPerson");
    }
    public void setPresentedPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("presentedPerson", item);
    }
    /**
     * Object: Signwasthetable 's 部门 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getDepartments()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("departments");
    }
    public void setDepartments(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("departments", item);
    }
    /**
     * Object:Signwasthetable's 主旨property 
     */
    public String getKeyWord()
    {
        return getString("KeyWord");
    }
    public void setKeyWord(String item)
    {
        setString("KeyWord", item);
    }
    /**
     * Object:Signwasthetable's 说明property 
     */
    public String getReason()
    {
        return getString("reason");
    }
    public void setReason(String item)
    {
        setString("reason", item);
    }
    /**
     * Object:Signwasthetable's 审核property 
     */
    public String getAudit()
    {
        return getString("audit");
    }
    public void setAudit(String item)
    {
        setString("audit", item);
    }
    /**
     * Object:Signwasthetable's 主旨标注property 
     */
    public String getText1()
    {
        return getString("text1");
    }
    public void setText1(String item)
    {
        setString("text1", item);
    }
    /**
     * Object:Signwasthetable's 内容标注property 
     */
    public String getText2()
    {
        return getString("text2");
    }
    public void setText2(String item)
    {
        setString("text2", item);
    }
    /**
     * Object: Signwasthetable 's 审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getAuditors()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("Auditors");
    }
    public void setAuditors(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("Auditors", item);
    }
    /**
     * Object:Signwasthetable's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("AuditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("AuditTime", item);
    }
    /**
     * Object:Signwasthetable's 签呈状态property 
     */
    public com.kingdee.eas.custom.signwasthetable.billStatus getBillStatus()
    {
        return com.kingdee.eas.custom.signwasthetable.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.signwasthetable.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object: Signwasthetable 's 行政组织单元 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getAdminOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("adminOrgUnit");
    }
    public void setAdminOrgUnit(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("adminOrgUnit", item);
    }
    /**
     * Object:Signwasthetable's 当前组织property 
     */
    public String getOrgSupp()
    {
        return getString("orgSupp");
    }
    public void setOrgSupp(String item)
    {
        setString("orgSupp", item);
    }
    /**
     * Object: Signwasthetable 's 签呈类型 property 
     */
    public com.kingdee.eas.custom.signwasthetable.SignBDInfo getBillType()
    {
        return (com.kingdee.eas.custom.signwasthetable.SignBDInfo)get("billType");
    }
    public void setBillType(com.kingdee.eas.custom.signwasthetable.SignBDInfo item)
    {
        put("billType", item);
    }
    /**
     * Object: Signwasthetable 's 明细 property 
     */
    public com.kingdee.eas.custom.test.SignwasthetableEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.test.SignwasthetableEntryCollection)get("Entry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("747820B8");
    }
}