package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSaleFeeInputInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSaleFeeInputInfo()
    {
        this("id");
    }
    protected AbstractSaleFeeInputInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.salepayment.SaleFeeInputEntryCollection());
    }
    /**
     * Object: 销售费用录入 's 分录 property 
     */
    public com.kingdee.eas.custom.salepayment.SaleFeeInputEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.salepayment.SaleFeeInputEntryCollection)get("entrys");
    }
    /**
     * Object:销售费用录入's 是否生成凭证property 
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
     * Object:销售费用录入's 年property 
     */
    public int getYear()
    {
        return getInt("year");
    }
    public void setYear(int item)
    {
        setInt("year", item);
    }
    /**
     * Object:销售费用录入's 月property 
     */
    public int getMonth()
    {
        return getInt("month");
    }
    public void setMonth(int item)
    {
        setInt("month", item);
    }
    /**
     * Object:销售费用录入's 审核时间property 
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
     * Object: 销售费用录入 's 公司 property 
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
     * Object:销售费用录入's 状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: 销售费用录入 's 销售员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSaler()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("saler");
    }
    public void setSaler(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("saler", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B5F58E3F");
    }
}