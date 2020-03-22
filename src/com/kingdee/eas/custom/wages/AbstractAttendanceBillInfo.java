package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAttendanceBillInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractAttendanceBillInfo()
    {
        this("id");
    }
    protected AbstractAttendanceBillInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.wages.AttendanceBillEntryCollection());
    }
    /**
     * Object:���ڹ���'s �Ƿ�����ƾ֤property 
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
     * Object: ���ڹ��� 's ��˾ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:���ڹ���'s ���property 
     */
    public com.kingdee.eas.custom.wages.classesState getClasses()
    {
        return com.kingdee.eas.custom.wages.classesState.getEnum(getString("classes"));
    }
    public void setClasses(com.kingdee.eas.custom.wages.classesState item)
    {
		if (item != null) {
        setString("classes", item.getValue());
		}
    }
    /**
     * Object: ���ڹ��� 's �������� property 
     */
    public com.kingdee.eas.custom.wages.WageOrganizationInfo getTheGroup()
    {
        return (com.kingdee.eas.custom.wages.WageOrganizationInfo)get("theGroup");
    }
    public void setTheGroup(com.kingdee.eas.custom.wages.WageOrganizationInfo item)
    {
        put("theGroup", item);
    }
    /**
     * Object: ���ڹ��� 's ������ϸ property 
     */
    public com.kingdee.eas.custom.wages.AttendanceBillEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.wages.AttendanceBillEntryCollection)get("Entry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("13B28C98");
    }
}