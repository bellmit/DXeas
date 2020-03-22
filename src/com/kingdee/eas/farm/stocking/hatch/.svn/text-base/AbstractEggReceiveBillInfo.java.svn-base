package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggReceiveBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractEggReceiveBillInfo()
    {
        this("id");
    }
    protected AbstractEggReceiveBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryCollection());
    }
    /**
     * Object: 种蛋挑选表 's 分录 property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryCollection)get("entrys");
    }
    /**
     * Object:种蛋挑选表's 是否生成凭证property 
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
     * Object:种蛋挑选表's 单据状态property 
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
     * Object: 种蛋挑选表 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:种蛋挑选表's 审核时间property 
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
     * Object: 种蛋挑选表 's 库存组织 property 
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
     * Object:种蛋挑选表's 初始化单据property 
     */
    public boolean isIsInit()
    {
        return getBoolean("isInit");
    }
    public void setIsInit(boolean item)
    {
        setBoolean("isInit", item);
    }
    /**
     * Object:种蛋挑选表's 种蛋来源property 
     */
    public com.kingdee.eas.farm.hatch.EggSourceType getEggSource()
    {
        return com.kingdee.eas.farm.hatch.EggSourceType.getEnum(getInt("eggSource"));
    }
    public void setEggSource(com.kingdee.eas.farm.hatch.EggSourceType item)
    {
		if (item != null) {
        setInt("eggSource", item.getValue());
		}
    }
    /**
     * Object:种蛋挑选表's 整数property 
     */
    public int getBIMUDF0129()
    {
        return getInt("BIMUDF0129");
    }
    public void setBIMUDF0129(int item)
    {
        setInt("BIMUDF0129", item);
    }
    /**
     * Object:种蛋挑选表's 是否带走property 
     */
    public boolean isHasTakeAway()
    {
        return getBoolean("hasTakeAway");
    }
    public void setHasTakeAway(boolean item)
    {
        setBoolean("hasTakeAway", item);
    }
    /**
     * Object: 种蛋挑选表 's 孵化厂 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBaseDataInfo getIncubation()
    {
        return (com.kingdee.eas.farm.hatch.HatchBaseDataInfo)get("incubation");
    }
    public void setIncubation(com.kingdee.eas.farm.hatch.HatchBaseDataInfo item)
    {
        put("incubation", item);
    }
    /**
     * Object:种蛋挑选表's 是否生成生产入负数property 
     */
    public boolean isIsManuMin()
    {
        return getBoolean("isManuMin");
    }
    public void setIsManuMin(boolean item)
    {
        setBoolean("isManuMin", item);
    }
    /**
     * Object:种蛋挑选表's 是否生成其它入property 
     */
    public boolean isIsOtherIn()
    {
        return getBoolean("isOtherIn");
    }
    public void setIsOtherIn(boolean item)
    {
        setBoolean("isOtherIn", item);
    }
    /**
     * Object:种蛋挑选表's 是否生成批次转换property 
     */
    public boolean isIsBatchTrans()
    {
        return getBoolean("isBatchTrans");
    }
    public void setIsBatchTrans(boolean item)
    {
        setBoolean("isBatchTrans", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("38D35EAF");
    }
}