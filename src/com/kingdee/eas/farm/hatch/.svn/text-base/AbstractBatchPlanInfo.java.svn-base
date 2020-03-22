package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchPlanInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBatchPlanInfo()
    {
        this("id");
    }
    protected AbstractBatchPlanInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.hatch.BatchPlanEntryCollection());
        put("LayEggEntry", new com.kingdee.eas.farm.hatch.BatchPlanLayEggEntryCollection());
    }
    /**
     * Object: 上孵计划 's 分录 property 
     */
    public com.kingdee.eas.farm.hatch.BatchPlanEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.hatch.BatchPlanEntryCollection)get("entrys");
    }
    /**
     * Object:上孵计划's 是否生成凭证property 
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
     * Object:上孵计划's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object: 上孵计划 's 孵化场 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getHatchFactory()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("hatchFactory");
    }
    public void setHatchFactory(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("hatchFactory", item);
    }
    /**
     * Object: 上孵计划 's 期间（月份） property 
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
     * Object:上孵计划's 状态property 
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
     * Object: 上孵计划 's 产蛋信息分录 property 
     */
    public com.kingdee.eas.farm.hatch.BatchPlanLayEggEntryCollection getLayEggEntry()
    {
        return (com.kingdee.eas.farm.hatch.BatchPlanLayEggEntryCollection)get("LayEggEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4282CB35");
    }
}