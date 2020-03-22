package com.kingdee.eas.custom.taihe.contract;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAssureAmtPolicyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractAssureAmtPolicyInfo()
    {
        this("id");
    }
    protected AbstractAssureAmtPolicyInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 保证金政策 's 组别 property 
     */
    public com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 保证金政策 's 公司 property 
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
     * Object:保证金政策's 开始日期property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:保证金政策's 结束日期property 
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
     * Object:保证金政策's 保底价格property 
     */
    public java.math.BigDecimal getLowPrice()
    {
        return getBigDecimal("lowPrice");
    }
    public void setLowPrice(java.math.BigDecimal item)
    {
        setBigDecimal("lowPrice", item);
    }
    /**
     * Object:保证金政策's 单只保证金property 
     */
    public java.math.BigDecimal getAssurePrice()
    {
        return getBigDecimal("assurePrice");
    }
    public void setAssurePrice(java.math.BigDecimal item)
    {
        setBigDecimal("assurePrice", item);
    }
    /**
     * Object:保证金政策's 单据状态property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8D77C2F7");
    }
}