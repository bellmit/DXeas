package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchAdjustBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractHatchAdjustBillInfo()
    {
        this("id");
    }
    protected AbstractHatchAdjustBillInfo(String pkField)
    {
        super(pkField);
        put("EggEntry", new com.kingdee.eas.farm.hatch.HatchAdjustBillEggEntryCollection());
    }
    /**
     * Object:孵化调整单's 是否生成凭证property 
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
     * Object:孵化调整单's 审核日期property 
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
     * Object:孵化调整单's 状态property 
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
     * Object: 孵化调整单 's 种蛋来源 property 
     */
    public com.kingdee.eas.farm.hatch.HatchAdjustBillEggEntryCollection getEggEntry()
    {
        return (com.kingdee.eas.farm.hatch.HatchAdjustBillEggEntryCollection)get("EggEntry");
    }
    /**
     * Object: 孵化调整单 's 来源单据 property 
     */
    public com.kingdee.eas.farm.hatch.BEggHatchBillInfo getSrcBill()
    {
        return (com.kingdee.eas.farm.hatch.BEggHatchBillInfo)get("srcBill");
    }
    public void setSrcBill(com.kingdee.eas.farm.hatch.BEggHatchBillInfo item)
    {
        put("srcBill", item);
    }
    /**
     * Object:孵化调整单's 来源单据类型property 
     */
    public com.kingdee.eas.farm.hatch.HatchBillTypeEnum getSrcBillType()
    {
        return com.kingdee.eas.farm.hatch.HatchBillTypeEnum.getEnum(getInt("srcBillType"));
    }
    public void setSrcBillType(com.kingdee.eas.farm.hatch.HatchBillTypeEnum item)
    {
		if (item != null) {
        setInt("srcBillType", item.getValue());
		}
    }
    /**
     * Object: 孵化调整单 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrgUnit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6A51F4C8");
    }
}