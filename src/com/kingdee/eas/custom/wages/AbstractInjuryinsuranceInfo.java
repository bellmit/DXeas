package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInjuryinsuranceInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractInjuryinsuranceInfo()
    {
        this("id");
    }
    protected AbstractInjuryinsuranceInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.InjuryinsuranceEntryCollection());
    }
    /**
     * Object: 工伤保险单 's 分录 property 
     */
    public com.kingdee.eas.custom.wages.InjuryinsuranceEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.InjuryinsuranceEntryCollection)get("entrys");
    }
    /**
     * Object:工伤保险单's 是否生成凭证property 
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
     * Object:工伤保险单's 单据状态property 
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
     * Object: 工伤保险单 's 公司 property 
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
     * Object:工伤保险单's 理赔金额property 
     */
    public java.math.BigDecimal getSureAmount()
    {
        return getBigDecimal("sureAmount");
    }
    public void setSureAmount(java.math.BigDecimal item)
    {
        setBigDecimal("sureAmount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7C52483B");
    }
}