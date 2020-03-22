package com.kingdee.eas.custom.wages.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAdjustFoodmoneyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractAdjustFoodmoneyInfo()
    {
        this("id");
    }
    protected AbstractAdjustFoodmoneyInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.food.AdjustFoodmoneyEntryCollection());
    }
    /**
     * Object: 食品公司调整工资单 's 分录 property 
     */
    public com.kingdee.eas.custom.wages.food.AdjustFoodmoneyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.food.AdjustFoodmoneyEntryCollection)get("entrys");
    }
    /**
     * Object:食品公司调整工资单's 是否生成凭证property 
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
     * Object:食品公司调整工资单's 单据状态property 
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
     * Object:食品公司调整工资单's 生效日期property 
     */
    public java.util.Date getStartDate()
    {
        return getDate("startDate");
    }
    public void setStartDate(java.util.Date item)
    {
        setDate("startDate", item);
    }
    /**
     * Object: 食品公司调整工资单 's 部门 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F07F5F11");
    }
}