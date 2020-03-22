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
     * Object: 费用分摊 's 分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillEntryCollection)get("entrys");
    }
    /**
     * Object:费用分摊's 是否生成凭证property 
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
     * Object: 费用分摊 's 财务组织 property 
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
     * Object:费用分摊's 分摊总费用property 
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
     * Object:费用分摊's 单据状态property 
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
     * Object: 费用分摊 's 期间 property 
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
     * Object:费用分摊's 审核日期property 
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
     * Object: 费用分摊 's 成本中心 property 
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
     * Object: 费用分摊 's 会计科目 property 
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