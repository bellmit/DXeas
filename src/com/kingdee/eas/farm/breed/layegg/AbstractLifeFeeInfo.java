package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLifeFeeInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractLifeFeeInfo()
    {
        this("id");
    }
    protected AbstractLifeFeeInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.breed.layegg.LifeFeeEntryCollection());
    }
    /**
     * Object: ĸѼ����� 's ��¼ property 
     */
    public com.kingdee.eas.farm.breed.layegg.LifeFeeEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.LifeFeeEntryCollection)get("entrys");
    }
    /**
     * Object:ĸѼ�����'s �Ƿ�����ƾ֤property 
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
     * Object: ĸѼ����� 's ��˾ property 
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
     * Object: ĸѼ����� 's ����ڼ� property 
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
     * Object:ĸѼ�����'s ���ʱ��property 
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
     * Object:ĸѼ�����'s ����״̬property 
     */
    public com.kingdee.eas.farm.breed.layegg.BillStatus getBillStatus()
    {
        return com.kingdee.eas.farm.breed.layegg.BillStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.farm.breed.layegg.BillStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object: ĸѼ����� 's Ƭ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo getOutAreas()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo)get("outAreas");
    }
    public void setOutAreas(com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo item)
    {
        put("outAreas", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F41635BD");
    }
}