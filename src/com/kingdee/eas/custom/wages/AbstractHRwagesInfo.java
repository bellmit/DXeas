package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHRwagesInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractHRwagesInfo()
    {
        this("id");
    }
    protected AbstractHRwagesInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.HRwagesEntryCollection());
    }
    /**
     * Object: ���ʼ��㵥���¸��� 's ��¼ property 
     */
    public com.kingdee.eas.custom.wages.HRwagesEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.HRwagesEntryCollection)get("entrys");
    }
    /**
     * Object:���ʼ��㵥���¸���'s �Ƿ�����ƾ֤property 
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
     * Object:���ʼ��㵥���¸���'s ����״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("BillStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("BillStatus", item.getValue());
		}
    }
    /**
     * Object:���ʼ��㵥���¸���'s ��Ч����property 
     */
    public java.util.Date getStartDate()
    {
        return getDate("startDate");
    }
    public void setStartDate(java.util.Date item)
    {
        setDate("startDate", item);
    }
    /**
     * Object: ���ʼ��㵥���¸��� 's ���� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object: ���ʼ��㵥���¸��� 's ��˾ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompanyOrg()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("companyOrg");
    }
    public void setCompanyOrg(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("companyOrg", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C9BB9499");
    }
}