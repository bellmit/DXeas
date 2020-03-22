package com.kingdee.eas.farm.breed.business;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCommecialChikenApplyFodderInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCommecialChikenApplyFodderInfo()
    {
        this("id");
    }
    protected AbstractCommecialChikenApplyFodderInfo(String pkField)
    {
        super(pkField);
        put("FodderPlanEntrys", new com.kingdee.eas.farm.breed.business.CommecialChikenApplyFodderFodderPlanEntryCollection());
    }
    /**
     * Object:商品鸡要料计划's 是否生成凭证property 
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
     * Object:商品鸡要料计划's 状态property 
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
     * Object:商品鸡要料计划's 审核时间property 
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
     * Object: 商品鸡要料计划 's 养殖场 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStoOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("stoOrg");
    }
    public void setStoOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("stoOrg", item);
    }
    /**
     * Object: 商品鸡要料计划 's 饲料要料计划 property 
     */
    public com.kingdee.eas.farm.breed.business.CommecialChikenApplyFodderFodderPlanEntryCollection getFodderPlanEntrys()
    {
        return (com.kingdee.eas.farm.breed.business.CommecialChikenApplyFodderFodderPlanEntryCollection)get("FodderPlanEntrys");
    }
    /**
     * Object: 商品鸡要料计划 's 成本对象(批次) property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("costObject");
    }
    public void setCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("costObject", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("08A076B8");
    }
}