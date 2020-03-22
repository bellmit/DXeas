package com.kingdee.eas.custom.eas2temp;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMMPlanInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractMMPlanInfo()
    {
        this("id");
    }
    protected AbstractMMPlanInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.eas2temp.MMPlanEntryCollection());
    }
    /**
     * Object: 生产计划 's 分录 property 
     */
    public com.kingdee.eas.custom.eas2temp.MMPlanEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.eas2temp.MMPlanEntryCollection)get("entrys");
    }
    /**
     * Object:生产计划's 是否生成凭证property 
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
     * Object:生产计划's 单据状态property 
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
     * Object:生产计划's 审核时间property 
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
     * Object: 生产计划 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrgUnit", item);
    }
    /**
     * Object:生产计划's 计划完成时间property 
     */
    public java.util.Date getFinishDate()
    {
        return getDate("finishDate");
    }
    public void setFinishDate(java.util.Date item)
    {
        setDate("finishDate", item);
    }
    /**
     * Object:生产计划's 车间property 
     */
    public com.kingdee.eas.custom.eas2temp.workShopNumEnum getWorkShop()
    {
        return com.kingdee.eas.custom.eas2temp.workShopNumEnum.getEnum(getInt("workShop"));
    }
    public void setWorkShop(com.kingdee.eas.custom.eas2temp.workShopNumEnum item)
    {
		if (item != null) {
        setInt("workShop", item.getValue());
		}
    }
    /**
     * Object: 生产计划 's 期间 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("Period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("Period", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1F3B6F9D");
    }
}