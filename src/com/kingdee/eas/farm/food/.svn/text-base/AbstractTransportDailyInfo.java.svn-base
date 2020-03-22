package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTransportDailyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractTransportDailyInfo()
    {
        this("id");
    }
    protected AbstractTransportDailyInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.food.TransportDailyEntryCollection());
        put("OilEntry", new com.kingdee.eas.farm.food.TransportDailyOilEntryCollection());
    }
    /**
     * Object: 车辆运输统计 's 库存组织 property 
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
     * Object:车辆运输统计's 单据状态property 
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
     * Object:车辆运输统计's 审核时间property 
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
     * Object: 车辆运输统计 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompanyOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("companyOrgUnit");
    }
    public void setCompanyOrgUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("companyOrgUnit", item);
    }
    /**
     * Object: 车辆运输统计 's 运输明细 property 
     */
    public com.kingdee.eas.farm.food.TransportDailyEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.food.TransportDailyEntryCollection)get("Entry");
    }
    /**
     * Object: 车辆运输统计 's 加油明细 property 
     */
    public com.kingdee.eas.farm.food.TransportDailyOilEntryCollection getOilEntry()
    {
        return (com.kingdee.eas.farm.food.TransportDailyOilEntryCollection)get("OilEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8949F39A");
    }
}