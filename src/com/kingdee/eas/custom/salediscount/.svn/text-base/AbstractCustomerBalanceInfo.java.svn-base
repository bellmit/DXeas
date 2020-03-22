package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCustomerBalanceInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCustomerBalanceInfo()
    {
        this("id");
    }
    protected AbstractCustomerBalanceInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 客户折让余额 's 组别 property 
     */
    public com.kingdee.eas.custom.salediscount.CustomerBalanceTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.salediscount.CustomerBalanceTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.salediscount.CustomerBalanceTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 客户折让余额 's 客户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object:客户折让余额's 初始余额property 
     */
    public java.math.BigDecimal getInitBalance()
    {
        return getBigDecimal("initBalance");
    }
    public void setInitBalance(java.math.BigDecimal item)
    {
        setBigDecimal("initBalance", item);
    }
    /**
     * Object:客户折让余额's 当前余额property 
     */
    public java.math.BigDecimal getNowBalance()
    {
        return getBigDecimal("nowBalance");
    }
    public void setNowBalance(java.math.BigDecimal item)
    {
        setBigDecimal("nowBalance", item);
    }
    /**
     * Object: 客户折让余额 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("79F456C3");
    }
}