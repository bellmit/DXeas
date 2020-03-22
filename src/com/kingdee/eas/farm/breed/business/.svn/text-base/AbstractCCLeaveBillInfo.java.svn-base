package com.kingdee.eas.farm.breed.business;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCLeaveBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCCLeaveBillInfo()
    {
        this("id");
    }
    protected AbstractCCLeaveBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.breed.business.CCLeaveBillEntryCollection());
    }
    /**
     * Object: 商品鸡出场纪录 's 分录 property 
     */
    public com.kingdee.eas.farm.breed.business.CCLeaveBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.business.CCLeaveBillEntryCollection)get("entrys");
    }
    /**
     * Object:商品鸡出场纪录's 是否生成凭证property 
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
     * Object: 商品鸡出场纪录 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("StorageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("StorageOrgUnit", item);
    }
    /**
     * Object:商品鸡出场纪录's 单据状态property 
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
     * Object:商品鸡出场纪录's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("AuditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("AuditTime", item);
    }
    /**
     * Object: 商品鸡出场纪录 's 车辆 property 
     */
    public com.kingdee.eas.publicdata.CarInfo getCar()
    {
        return (com.kingdee.eas.publicdata.CarInfo)get("car");
    }
    public void setCar(com.kingdee.eas.publicdata.CarInfo item)
    {
        put("car", item);
    }
    /**
     * Object:商品鸡出场纪录's 只均重(KG)property 
     */
    public java.math.BigDecimal getAverageWeight()
    {
        return getBigDecimal("averageWeight");
    }
    public void setAverageWeight(java.math.BigDecimal item)
    {
        setBigDecimal("averageWeight", item);
    }
    /**
     * Object:商品鸡出场纪录's 出场时间property 
     */
    public java.sql.Time getLeaveTime()
    {
        return getTime("leaveTime");
    }
    public void setLeaveTime(java.sql.Time item)
    {
        setTime("leaveTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("607BFEF0");
    }
}