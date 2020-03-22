package com.kingdee.eas.custom.purchasebudget;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPurBudgetInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractPurBudgetInfo()
    {
        this("id");
    }
    protected AbstractPurBudgetInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.purchasebudget.PurBudgetEntryCollection());
    }
    /**
     * Object: 采购预算 's 分录 property 
     */
    public com.kingdee.eas.custom.purchasebudget.PurBudgetEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.purchasebudget.PurBudgetEntryCollection)get("entrys");
    }
    /**
     * Object:采购预算's 是否生成凭证property 
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
     * Object: 采购预算 's 公司 property 
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
     * Object: 采购预算 's 期间 property 
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
     * Object:采购预算's 审核时间property 
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
     * Object:采购预算's 单据状态property 
     */
    public com.kingdee.eas.custom.purchasebudget.billStatus getBillStatus()
    {
        return com.kingdee.eas.custom.purchasebudget.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.purchasebudget.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8E873495");
    }
}