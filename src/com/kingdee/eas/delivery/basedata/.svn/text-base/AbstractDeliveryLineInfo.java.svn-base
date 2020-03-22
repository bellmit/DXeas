package com.kingdee.eas.delivery.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDeliveryLineInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDeliveryLineInfo()
    {
        this("id");
    }
    protected AbstractDeliveryLineInfo(String pkField)
    {
        super(pkField);
        put("entry", new com.kingdee.eas.delivery.basedata.DeliveryLineEntryCollection());
    }
    /**
     * Object: 发运路线 's 第1个表体 property 
     */
    public com.kingdee.eas.delivery.basedata.DeliveryLineEntryCollection getEntry()
    {
        return (com.kingdee.eas.delivery.basedata.DeliveryLineEntryCollection)get("entry");
    }
    /**
     * Object: 发运路线 's 起点站 property 
     */
    public com.kingdee.eas.basedata.assistant.AddressInfo getBeginStation()
    {
        return (com.kingdee.eas.basedata.assistant.AddressInfo)get("beginStation");
    }
    public void setBeginStation(com.kingdee.eas.basedata.assistant.AddressInfo item)
    {
        put("beginStation", item);
    }
    /**
     * Object: 发运路线 's 终点站 property 
     */
    public com.kingdee.eas.basedata.assistant.AddressInfo getEndStation()
    {
        return (com.kingdee.eas.basedata.assistant.AddressInfo)get("endStation");
    }
    public void setEndStation(com.kingdee.eas.basedata.assistant.AddressInfo item)
    {
        put("endStation", item);
    }
    /**
     * Object:发运路线's 默认运输方式property 
     */
    public com.kingdee.eas.scm.im.dt.TransportTypeEnum getDefaultTranType()
    {
        return com.kingdee.eas.scm.im.dt.TransportTypeEnum.getEnum(getInt("defaultTranType"));
    }
    public void setDefaultTranType(com.kingdee.eas.scm.im.dt.TransportTypeEnum item)
    {
		if (item != null) {
        setInt("defaultTranType", item.getValue());
		}
    }
    /**
     * Object:发运路线's 总里程（公里）property 
     */
    public java.math.BigDecimal getTotalMileage()
    {
        return getBigDecimal("totalMileage");
    }
    public void setTotalMileage(java.math.BigDecimal item)
    {
        setBigDecimal("totalMileage", item);
    }
    /**
     * Object: 发运路线 's 默认承运商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getDefaultCarrier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("defaultCarrier");
    }
    public void setDefaultCarrier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("defaultCarrier", item);
    }
    /**
     * Object:发运路线's 状态property 
     */
    public com.kingdee.eas.scm.im.dt.BillStatusEnum getStatus()
    {
        return com.kingdee.eas.scm.im.dt.BillStatusEnum.getEnum(getInt("status"));
    }
    public void setStatus(com.kingdee.eas.scm.im.dt.BillStatusEnum item)
    {
		if (item != null) {
        setInt("status", item.getValue());
		}
    }
    /**
     * Object:发运路线's 平均耗时（小时）property 
     */
    public java.math.BigDecimal getAvgHour()
    {
        return getBigDecimal("avgHour");
    }
    public void setAvgHour(java.math.BigDecimal item)
    {
        setBigDecimal("avgHour", item);
    }
    /**
     * Object:发运路线's 分钟property 
     */
    public java.math.BigDecimal getAvgMinute()
    {
        return getBigDecimal("avgMinute");
    }
    public void setAvgMinute(java.math.BigDecimal item)
    {
        setBigDecimal("avgMinute", item);
    }
    /**
     * Object:发运路线's 集团内路线property 
     */
    public boolean isIsInner()
    {
        return getBoolean("isInner");
    }
    public void setIsInner(boolean item)
    {
        setBoolean("isInner", item);
    }
    /**
     * Object: 发运路线 's 起始组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getFromStorageOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("fromStorageOrg");
    }
    public void setFromStorageOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("fromStorageOrg", item);
    }
    /**
     * Object: 发运路线 's 目的组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getToStorageOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("toStorageOrg");
    }
    public void setToStorageOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("toStorageOrg", item);
    }
    /**
     * Object:发运路线's 默认派车数property 
     */
    public int getDefaultCarCount()
    {
        return getInt("defaultCarCount");
    }
    public void setDefaultCarCount(int item)
    {
        setInt("defaultCarCount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("23EE40F3");
    }
}