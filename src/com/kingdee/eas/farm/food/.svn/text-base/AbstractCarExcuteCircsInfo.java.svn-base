package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarExcuteCircsInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCarExcuteCircsInfo()
    {
        this("id");
    }
    protected AbstractCarExcuteCircsInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.food.CarExcuteCircsEntryCollection());
    }
    /**
     * Object: 派车执行情况表 's 分录 property 
     */
    public com.kingdee.eas.farm.food.CarExcuteCircsEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.food.CarExcuteCircsEntryCollection)get("entrys");
    }
    /**
     * Object:派车执行情况表's 是否生成凭证property 
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
     * Object:派车执行情况表's 派车数量property 
     */
    public java.math.BigDecimal getCarCount()
    {
        return getBigDecimal("carCount");
    }
    public void setCarCount(java.math.BigDecimal item)
    {
        setBigDecimal("carCount", item);
    }
    /**
     * Object:派车执行情况表's 审核时间property 
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
     * Object: 派车执行情况表 's 库存组织 property 
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
     * Object:派车执行情况表's 单据状态property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5A6D8CFC");
    }
}