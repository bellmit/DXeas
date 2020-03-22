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
     * Object: �޸�sHRԱ���籣״̬ 's ��¼ property 
     */
    public com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusEntryCollection)get("entrys");
    }
    /**
     * Object:�޸�sHRԱ���籣״̬'s �Ƿ�����ƾ֤property 
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
     * Object:�޸�sHRԱ���籣״̬'s ���ʱ��property 
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
     * Object:�޸�sHRԱ���籣״̬'s �������ڴ�property 
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
     * Object:�޸�sHRԱ���籣״̬'s ��ְ���ڵ�property 
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
     * Object:�޸�sHRԱ���籣״̬'s ��ְproperty 
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
     * Object:�޸�sHRԱ���籣״̬'s Ա������property 
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
     * Object:�޸�sHRԱ���籣״̬'s Ա������property 
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