package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInsuranceRegistInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractInsuranceRegistInfo()
    {
        this("id");
    }
    protected AbstractInsuranceRegistInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.InsuranceRegistEntryCollection());
    }
    /**
     * Object: 保险登记单 's 分录 property 
     */
    public com.kingdee.eas.custom.wages.InsuranceRegistEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.InsuranceRegistEntryCollection)get("entrys");
    }
    /**
     * Object:保险登记单's 是否生成凭证property 
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
     * Object:保险登记单's 单据状态property 
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
     * Object: 保险登记单 's 公司 property 
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
     * Object:保险登记单's 到期日期property 
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
     * Object:保险登记单's 保费property 
     */
    public java.math.BigDecimal getPremium()
    {
        return getBigDecimal("Premium");
    }
    public void setPremium(java.math.BigDecimal item)
    {
        setBigDecimal("Premium", item);
    }
    /**
     * Object: 保险登记单 's 险种 property 
     */
    public com.kingdee.eas.custom.wages.InsuranceTypeInfo getInsurancetype()
    {
        return (com.kingdee.eas.custom.wages.InsuranceTypeInfo)get("insurancetype");
    }
    public void setInsurancetype(com.kingdee.eas.custom.wages.InsuranceTypeInfo item)
    {
        put("insurancetype", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("45AEC1E8");
    }
}