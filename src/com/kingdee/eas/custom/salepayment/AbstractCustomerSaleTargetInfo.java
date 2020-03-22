package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCustomerSaleTargetInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCustomerSaleTargetInfo()
    {
        this("id");
    }
    protected AbstractCustomerSaleTargetInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 客户销售指标 's 组别 property 
     */
    public com.kingdee.eas.custom.salepayment.CustomerSaleTargetTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.salepayment.CustomerSaleTargetTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.salepayment.CustomerSaleTargetTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 客户销售指标 's 客户 property 
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
     * Object:客户销售指标's 状态property 
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
     * Object:客户销售指标's 指标类型property 
     */
    public com.kingdee.eas.custom.salepayment.IndexType getIndexType()
    {
        return com.kingdee.eas.custom.salepayment.IndexType.getEnum(getString("indexType"));
    }
    public void setIndexType(com.kingdee.eas.custom.salepayment.IndexType item)
    {
		if (item != null) {
        setString("indexType", item.getValue());
		}
    }
    /**
     * Object:客户销售指标's 年property 
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
     * Object:客户销售指标's 季度property 
     */
    public com.kingdee.eas.custom.salepayment.Quarter getQuarter()
    {
        return com.kingdee.eas.custom.salepayment.Quarter.getEnum(getString("quarter"));
    }
    public void setQuarter(com.kingdee.eas.custom.salepayment.Quarter item)
    {
		if (item != null) {
        setString("quarter", item.getValue());
		}
    }
    /**
     * Object:客户销售指标's 目标不含税销售额property 
     */
    public java.math.BigDecimal getTargetAmount()
    {
        return getBigDecimal("targetAmount");
    }
    public void setTargetAmount(java.math.BigDecimal item)
    {
        setBigDecimal("targetAmount", item);
    }
    /**
     * Object: 客户销售指标 's 公司 property 
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
        return new BOSObjectType("B0B3252A");
    }
}