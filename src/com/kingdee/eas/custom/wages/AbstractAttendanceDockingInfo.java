package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAttendanceDockingInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractAttendanceDockingInfo()
    {
        this("id");
    }
    protected AbstractAttendanceDockingInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.wages.AttendanceDockingEntryCollection());
    }
    /**
     * Object:���ڶԽ�'s �Ƿ�����ƾ֤property 
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
     * Object: ���ڶԽ� 's ���ڶԽӷ�¼ property 
     */
    public com.kingdee.eas.custom.wages.AttendanceDockingEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.wages.AttendanceDockingEntryCollection)get("Entry");
    }
    /**
     * Object: ���ڶԽ� 's ��˾ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AA82E69E");
    }
}