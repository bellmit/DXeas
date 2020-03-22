package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFodderApplyBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFodderApplyBillInfo()
    {
        this("id");
    }
    protected AbstractFodderApplyBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.stocking.processbizill.FodderApplyBillEntryCollection());
    }
    /**
     * Object: Ҫ�ϼƻ� 's ��¼ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.FodderApplyBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.FodderApplyBillEntryCollection)get("entrys");
    }
    /**
     * Object:Ҫ�ϼƻ�'s �Ƿ�����ƾ֤property 
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
     * Object:Ҫ�ϼƻ�'s ����״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object: Ҫ�ϼƻ� 's ������֯ property 
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
     * Object:Ҫ�ϼƻ�'s ���ʱ��property 
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
     * Object: Ҫ�ϼƻ� 's �����֯ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrgUnit", item);
    }
    /**
     * Object: Ҫ�ϼƻ� 's ����ڼ� property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    /**
     * Object:Ҫ�ϼƻ�'s ��ʼ����property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:Ҫ�ϼƻ�'s ��������property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object: Ҫ�ϼƻ� 's ����Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getTechnician()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("technician");
    }
    public void setTechnician(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("technician", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("37E98DBA");
    }
}