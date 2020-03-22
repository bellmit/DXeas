package com.kingdee.eas.custom.wages.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTAttendanceRecordsInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractTAttendanceRecordsInfo()
    {
        this("id");
    }
    protected AbstractTAttendanceRecordsInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.food.TAttendanceRecordsEntryCollection());
    }
    /**
     * Object: 后勤考勤记录表 's 分录 property 
     */
    public com.kingdee.eas.custom.wages.food.TAttendanceRecordsEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.food.TAttendanceRecordsEntryCollection)get("entrys");
    }
    /**
     * Object:后勤考勤记录表's 是否生成凭证property 
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
     * Object:后勤考勤记录表's 单据状态property 
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
     * Object:后勤考勤记录表's 生效日期property 
     */
    public java.util.Date getStartDate()
    {
        return getDate("startDate");
    }
    public void setStartDate(java.util.Date item)
    {
        setDate("startDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F7BF7987");
    }
}