package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMonthBillFarmInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractMonthBillFarmInfo()
    {
        this("id");
    }
    protected AbstractMonthBillFarmInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.farm.MonthBillFarmEntryCollection());
    }
    /**
     * Object: 养殖月工资计算单 's 分录 property 
     */
    public com.kingdee.eas.custom.wages.farm.MonthBillFarmEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.farm.MonthBillFarmEntryCollection)get("entrys");
    }
    /**
     * Object:养殖月工资计算单's 是否生成凭证property 
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
     * Object:养殖月工资计算单's 单据状态property 
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
     * Object: 养殖月工资计算单 's 工资期间 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    /**
     * Object:养殖月工资计算单's 结算起始日期property 
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
     * Object:养殖月工资计算单's 结算结束日期property 
     */
    public java.util.Date getEnddate()
    {
        return getDate("enddate");
    }
    public void setEnddate(java.util.Date item)
    {
        setDate("enddate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("36C77F93");
    }
}