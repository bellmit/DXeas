package com.kingdee.eas.custom.taihe.weight;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWgtDisRateInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractWgtDisRateInfo()
    {
        this("id");
    }
    protected AbstractWgtDisRateInfo(String pkField)
    {
        super(pkField);
        put("Entrys", new com.kingdee.eas.custom.taihe.weight.WgtDisRateEntryCollection());
    }
    /**
     * Object: 称重结算系数 's 公司 property 
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
     * Object:称重结算系数's 单据状态property 
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
     * Object:称重结算系数's 生效日期property 
     */
    public java.util.Date getEffectDate()
    {
        return getDate("effectDate");
    }
    public void setEffectDate(java.util.Date item)
    {
        setDate("effectDate", item);
    }
    /**
     * Object:称重结算系数's 失效日期property 
     */
    public java.util.Date getUnEffectDate()
    {
        return getDate("unEffectDate");
    }
    public void setUnEffectDate(java.util.Date item)
    {
        setDate("unEffectDate", item);
    }
    /**
     * Object: 称重结算系数 's 分录 property 
     */
    public com.kingdee.eas.custom.taihe.weight.WgtDisRateEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.taihe.weight.WgtDisRateEntryCollection)get("Entrys");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5DBA1500");
    }
}