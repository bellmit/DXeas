package com.kingdee.eas.custom.applicationofsocialsecurity;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractModifySIStatusInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractModifySIStatusInfo()
    {
        this("id");
    }
    protected AbstractModifySIStatusInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusEntryCollection());
    }
    /**
     * Object: 修改sHR员工社保状态 's 分录 property 
     */
    public com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusEntryCollection)get("entrys");
    }
    /**
     * Object:修改sHR员工社保状态's 是否生成凭证property 
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
     * Object:修改sHR员工社保状态's 审核时间property 
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
     * Object:修改sHR员工社保状态's 入栏日期从property 
     */
    public java.util.Date getEnterDateFrom()
    {
        return getDate("enterDateFrom");
    }
    public void setEnterDateFrom(java.util.Date item)
    {
        setDate("enterDateFrom", item);
    }
    /**
     * Object:修改sHR员工社保状态's 入职日期到property 
     */
    public java.util.Date getEnterDateTo()
    {
        return getDate("enterDateTo");
    }
    public void setEnterDateTo(java.util.Date item)
    {
        setDate("enterDateTo", item);
    }
    /**
     * Object:修改sHR员工社保状态's 在职property 
     */
    public boolean isIsIn()
    {
        return getBoolean("isIn");
    }
    public void setIsIn(boolean item)
    {
        setBoolean("isIn", item);
    }
    /**
     * Object:修改sHR员工社保状态's 员工姓名property 
     */
    public String getPersonName()
    {
        return getString("personName");
    }
    public void setPersonName(String item)
    {
        setString("personName", item);
    }
    /**
     * Object:修改sHR员工社保状态's 员工编码property 
     */
    public String getPersonNum()
    {
        return getString("personNum");
    }
    public void setPersonNum(String item)
    {
        setString("personNum", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E6B2A5C1");
    }
}