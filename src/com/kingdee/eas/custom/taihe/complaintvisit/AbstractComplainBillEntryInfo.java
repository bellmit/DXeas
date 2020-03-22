package com.kingdee.eas.custom.taihe.complaintvisit;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractComplainBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractComplainBillEntryInfo()
    {
        this("id");
    }
    protected AbstractComplainBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's null property 
     */
    public com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.util.Date getFollowDate()
    {
        return getDate("followDate");
    }
    public void setFollowDate(java.util.Date item)
    {
        setDate("followDate", item);
    }
    /**
     * Object: ��¼ 's ������ property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getFollowPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("followPerson");
    }
    public void setFollowPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("followPerson", item);
    }
    /**
     * Object: ��¼ 's ������ property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getLiabilityPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("liabilityPerson");
    }
    public void setLiabilityPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("liabilityPerson", item);
    }
    /**
     * Object: ��¼ 's ���β��� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getDepartment()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("Department");
    }
    public void setDepartment(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("Department", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public String getHandleResult()
    {
        return getString("handleResult");
    }
    public void setHandleResult(String item)
    {
        setString("handleResult", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("76743054");
    }
}