package com.kingdee.eas.farm.stocking.assistfunction;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRunningDailyPaperInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractRunningDailyPaperInfo()
    {
        this("id");
    }
    protected AbstractRunningDailyPaperInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.stocking.assistfunction.RunningDailyPaperEntryCollection());
    }
    /**
     * Object: ��Ӫ�ձ��ɱ� 's ��¼ property 
     */
    public com.kingdee.eas.farm.stocking.assistfunction.RunningDailyPaperEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.RunningDailyPaperEntryCollection)get("entrys");
    }
    /**
     * Object:��Ӫ�ձ��ɱ�'s �Ƿ�����ƾ֤property 
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
     * Object: ��Ӫ�ձ��ɱ� 's ����ڼ� property 
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
     * Object: ��Ӫ�ձ��ɱ� 's ��˾ property 
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
     * Object:��Ӫ�ձ��ɱ�'s ����״̬property 
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
     * Object:��Ӫ�ձ��ɱ�'s ��λ����property 
     */
    public java.math.BigDecimal getUnitFee()
    {
        return getBigDecimal("unitFee");
    }
    public void setUnitFee(java.math.BigDecimal item)
    {
        setBigDecimal("unitFee", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3B34CA67");
    }
}