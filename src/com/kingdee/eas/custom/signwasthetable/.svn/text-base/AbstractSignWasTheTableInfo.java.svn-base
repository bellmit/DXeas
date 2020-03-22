package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSignWasTheTableInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSignWasTheTableInfo()
    {
        this("id");
    }
    protected AbstractSignWasTheTableInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.signwasthetable.SignWasTheTableEntryCollection());
    }
    /**
     * Object:签呈表's 是否生成凭证property 
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
     * Object: 签呈表 's 受文者 property 
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
     * Object: 签呈表 's 呈送者 property 
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
     * Object: 签呈表 's 部门 property 
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
     * Object:签呈表's 主旨property 
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
     * Object:签呈表's 审核property 
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
     * Object:签呈表's 主旨标注property 
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
     * Object:签呈表's 内容标注property 
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
     * Object: 签呈表 's 审核人 property 
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
     * Object:签呈表's 审核时间property 
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
     * Object:签呈表's 签呈状态property 
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
     * Object: 签呈表 's 行政组织单元 property 
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
     * Object:签呈表's 当前组织property 
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
     * Object: 签呈表 's 签呈类型 property 
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
     * Object: 签呈表 's 明细 property 
     */
    public com.kingdee.eas.custom.signwasthetable.SignWasTheTableEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.signwasthetable.SignWasTheTableEntryCollection)get("Entry");
    }
    /**
     * Object:签呈表's 说明property 
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
     * Object: 签呈表 's 销售员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSalePerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("salePerson");
    }
    public void setSalePerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("salePerson", item);
    }
    /**
     * Object: 签呈表 's 职位 property 
     */
    public com.kingdee.eas.basedata.org.PositionInfo getPosition()
    {
        return (com.kingdee.eas.basedata.org.PositionInfo)get("position");
    }
    public void setPosition(com.kingdee.eas.basedata.org.PositionInfo item)
    {
        put("position", item);
    }
    /**
     * Object: 签呈表 's 直接上级职位 property 
     */
    public com.kingdee.eas.basedata.org.PositionInfo getUpperPosition()
    {
        return (com.kingdee.eas.basedata.org.PositionInfo)get("upperPosition");
    }
    public void setUpperPosition(com.kingdee.eas.basedata.org.PositionInfo item)
    {
        put("upperPosition", item);
    }
    /**
     * Object:签呈表's 预计金额property 
     */
    public java.math.BigDecimal getPredictAmt()
    {
        return getBigDecimal("predictAmt");
    }
    public void setPredictAmt(java.math.BigDecimal item)
    {
        setBigDecimal("predictAmt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F132319F");
    }
}