package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTAttendFarmRecordInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractTAttendFarmRecordInfo()
    {
        this("id");
    }
    protected AbstractTAttendFarmRecordInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.farm.TAttendFarmRecordEntryCollection());
    }
    /**
     * Object: ��ֳ��˾���ڼ�¼�� 's ��¼ property 
     */
    public com.kingdee.eas.custom.wages.farm.TAttendFarmRecordEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.farm.TAttendFarmRecordEntryCollection)get("entrys");
    }
    /**
     * Object:��ֳ��˾���ڼ�¼��'s �Ƿ�����ƾ֤property 
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
     * Object:��ֳ��˾���ڼ�¼��'s ����״̬property 
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
     * Object:��ֳ��˾���ڼ�¼��'s ��Ч����property 
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
     * Object: ��ֳ��˾���ڼ�¼�� 's ���� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("63ECD80B");
    }
}