package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchAssessInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractHatchAssessInfo()
    {
        this("id");
    }
    protected AbstractHatchAssessInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.farm.HatchAssessEntryCollection());
    }
    /**
     * Object: 孵化场考核计算表 's 分录 property 
     */
    public com.kingdee.eas.custom.wages.farm.HatchAssessEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.farm.HatchAssessEntryCollection)get("entrys");
    }
    /**
     * Object:孵化场考核计算表's 单据状态property 
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
     * Object:孵化场考核计算表's 核算起始日期property 
     */
    public java.util.Date getBegindate()
    {
        return getDate("begindate");
    }
    public void setBegindate(java.util.Date item)
    {
        setDate("begindate", item);
    }
    /**
     * Object:孵化场考核计算表's 核算终止日期property 
     */
    public java.util.Date getEnddate()
    {
        return getDate("enddate");
    }
    public void setEnddate(java.util.Date item)
    {
        setDate("enddate", item);
    }
    /**
     * Object:孵化场考核计算表's 单据名称property 
     */
    public String getName()
    {
        return getString("name");
    }
    public void setName(String item)
    {
        setString("name", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FE2A055A");
    }
}