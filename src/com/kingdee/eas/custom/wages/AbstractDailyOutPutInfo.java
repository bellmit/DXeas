package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDailyOutPutInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDailyOutPutInfo()
    {
        this("id");
    }
    protected AbstractDailyOutPutInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.DailyOutPutEntryCollection());
    }
    /**
     * Object: 班组日产量明细表 's 分录 property 
     */
    public com.kingdee.eas.custom.wages.DailyOutPutEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.DailyOutPutEntryCollection)get("entrys");
    }
    /**
     * Object:班组日产量明细表's 是否生成凭证property 
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
     * Object: 班组日产量明细表 's 所属班组 property 
     */
    public com.kingdee.eas.custom.wages.WageOrganizationInfo getWageOrganization()
    {
        return (com.kingdee.eas.custom.wages.WageOrganizationInfo)get("WageOrganization");
    }
    public void setWageOrganization(com.kingdee.eas.custom.wages.WageOrganizationInfo item)
    {
        put("WageOrganization", item);
    }
    /**
     * Object:班组日产量明细表's 班组长property 
     */
    public String getOrganForeman()
    {
        return getString("OrganForeman");
    }
    public void setOrganForeman(String item)
    {
        setString("OrganForeman", item);
    }
    /**
     * Object:班组日产量明细表's 单据状态property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8CDF0352");
    }
}