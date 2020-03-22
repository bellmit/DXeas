package com.kingdee.eas.custom.salaryvoucher;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSalaryVoucherInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSalaryVoucherInfo()
    {
        this("id");
    }
    protected AbstractSalaryVoucherInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryCollection());
        put("Person", new com.kingdee.eas.custom.salaryvoucher.SalaryVoucherPersonCollection());
    }
    /**
     * Object: 薪酬凭证 's 分录 property 
     */
    public com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryCollection)get("entrys");
    }
    /**
     * Object:薪酬凭证's 是否生成凭证property 
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
     * Object:薪酬凭证's 名称property 
     */
    public String getName()
    {
        return getString("name");
    }
    public void setName(String item)
    {
        setString("name", item);
    }
    /**
     * Object: 薪酬凭证 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompanyOrg()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("companyOrg");
    }
    public void setCompanyOrg(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("companyOrg", item);
    }
    /**
     * Object:薪酬凭证's 状态property 
     */
    public com.kingdee.eas.custom.salaryvoucher.voucherStatus getStatus()
    {
        return com.kingdee.eas.custom.salaryvoucher.voucherStatus.getEnum(getString("status"));
    }
    public void setStatus(com.kingdee.eas.custom.salaryvoucher.voucherStatus item)
    {
		if (item != null) {
        setString("status", item.getValue());
		}
    }
    /**
     * Object:薪酬凭证's 期间偏离值property 
     */
    public int getPeriodDeviationValue()
    {
        return getInt("PeriodDeviationValue");
    }
    public void setPeriodDeviationValue(int item)
    {
        setInt("PeriodDeviationValue", item);
    }
    /**
     * Object: 薪酬凭证 's 凭证类型 property 
     */
    public com.kingdee.eas.basedata.assistant.VoucherTypeInfo getVoucherType()
    {
        return (com.kingdee.eas.basedata.assistant.VoucherTypeInfo)get("voucherType");
    }
    public void setVoucherType(com.kingdee.eas.basedata.assistant.VoucherTypeInfo item)
    {
        put("voucherType", item);
    }
    /**
     * Object: 薪酬凭证 's 员工 property 
     */
    public com.kingdee.eas.custom.salaryvoucher.SalaryVoucherPersonCollection getPerson()
    {
        return (com.kingdee.eas.custom.salaryvoucher.SalaryVoucherPersonCollection)get("Person");
    }
    /**
     * Object:薪酬凭证's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("AuditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("AuditTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9A5BC395");
    }
}