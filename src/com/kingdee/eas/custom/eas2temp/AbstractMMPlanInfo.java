package com.kingdee.eas.custom.eas2temp;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMMPlanInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractMMPlanInfo()
    {
        this("id");
    }
    protected AbstractMMPlanInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.eas2temp.MMPlanEntryCollection());
    }
    /**
     * Object: �����ƻ� 's ��¼ property 
     */
    public com.kingdee.eas.custom.eas2temp.MMPlanEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.eas2temp.MMPlanEntryCollection)get("entrys");
    }
    /**
     * Object:�����ƻ�'s �Ƿ�����ƾ֤property 
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
     * Object:�����ƻ�'s ����״̬property 
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
     * Object:�����ƻ�'s ���ʱ��property 
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
     * Object: �����ƻ� 's �����֯ property 
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
     * Object:�����ƻ�'s �ƻ����ʱ��property 
     */
    public java.util.Date getFinishDate()
    {
        return getDate("finishDate");
    }
    public void setFinishDate(java.util.Date item)
    {
        setDate("finishDate", item);
    }
    /**
     * Object:�����ƻ�'s ����property 
     */
    public com.kingdee.eas.custom.eas2temp.workShopNumEnum getWorkShop()
    {
        return com.kingdee.eas.custom.eas2temp.workShopNumEnum.getEnum(getInt("workShop"));
    }
    public void setWorkShop(com.kingdee.eas.custom.eas2temp.workShopNumEnum item)
    {
		if (item != null) {
        setInt("workShop", item.getValue());
		}
    }
    /**
     * Object: �����ƻ� 's �ڼ� property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("Period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("Period", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1F3B6F9D");
    }
}