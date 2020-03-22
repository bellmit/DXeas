package com.kingdee.eas.farm.breed.freedplan;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedFodderPlanInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBreedFodderPlanInfo()
    {
        this("id");
    }
    protected AbstractBreedFodderPlanInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.breed.freedplan.BreedFodderPlanEntryCollection());
    }
    /**
     * Object: 批次要料计划 's 分录 property 
     */
    public com.kingdee.eas.farm.breed.freedplan.BreedFodderPlanEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.freedplan.BreedFodderPlanEntryCollection)get("entrys");
    }
    /**
     * Object:批次要料计划's 是否生成凭证property 
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
     * Object:批次要料计划's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6CE20F2C");
    }
}