package com.kingdee.eas.custom.stockprice;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBasePriceOfOtherCompanyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBasePriceOfOtherCompanyInfo()
    {
        this("id");
    }
    protected AbstractBasePriceOfOtherCompanyInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyEntryCollection());
    }
    /**
     * Object: 基本价格维护(其他公司) 's 分录 property 
     */
    public com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyEntryCollection)get("entrys");
    }
    /**
     * Object:基本价格维护(其他公司)'s 审核时间property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("auditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("auditDate", item);
    }
    /**
     * Object:基本价格维护(其他公司)'s 公司property 
     */
    public String getCompany()
    {
        return getString("company");
    }
    public void setCompany(String item)
    {
        setString("company", item);
    }
    /**
     * Object:基本价格维护(其他公司)'s 单据状态property 
     */
    public com.kingdee.eas.custom.stockprice.billStatus getBillStatus()
    {
        return com.kingdee.eas.custom.stockprice.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.stockprice.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object:基本价格维护(其他公司)'s 生效日期property 
     */
    public java.util.Date getEffectDate()
    {
        return getDate("effectDate");
    }
    public void setEffectDate(java.util.Date item)
    {
        setDate("effectDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2AA4536C");
    }
}