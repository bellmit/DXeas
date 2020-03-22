package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKCostAllocateBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCKCostAllocateBillInfo()
    {
        this("id");
    }
    protected AbstractCKCostAllocateBillInfo(String pkField)
    {
        super(pkField);
        put("PeriodEntry", new com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillPeriodEntryCollection());
        put("entrys", new com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillEntryCollection());
    }
    /**
     * Object: ���÷�̯ 's ��¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillEntryCollection)get("entrys");
    }
    /**
     * Object:���÷�̯'s �Ƿ�����ƾ֤property 
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
     * Object: ���÷�̯ 's ������֯ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFICompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("FICompany");
    }
    public void setFICompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("FICompany", item);
    }
    /**
     * Object:���÷�̯'s ��̯�ܷ���property 
     */
    public java.math.BigDecimal getAllAmount()
    {
        return getBigDecimal("allAmount");
    }
    public void setAllAmount(java.math.BigDecimal item)
    {
        setBigDecimal("allAmount", item);
    }
    /**
     * Object:���÷�̯'s ����״̬property 
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
     * Object: ���÷�̯ 's �ڼ� property 
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
     * Object:���÷�̯'s �������property 
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
     * Object: ���÷�̯ 's �ɱ����� property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostCenter()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costCenter");
    }
    public void setCostCenter(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costCenter", item);
    }
    /**
     * Object: ���÷�̯ 's ��ƿ�Ŀ property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillPeriodEntryCollection getPeriodEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillPeriodEntryCollection)get("PeriodEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EDCBFD16");
    }
}