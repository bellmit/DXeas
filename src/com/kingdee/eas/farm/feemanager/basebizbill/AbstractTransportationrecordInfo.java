package com.kingdee.eas.farm.feemanager.basebizbill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTransportationrecordInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractTransportationrecordInfo()
    {
        this("id");
    }
    protected AbstractTransportationrecordInfo(String pkField)
    {
        super(pkField);
        put("AssEntrys", new com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordAssEntryCollection());
        put("entrys", new com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordEntryCollection());
        put("CarEntry", new com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordCarEntryCollection());
    }
    /**
     * Object: 车辆运输记录 's 运输记录 property 
     */
    public com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordEntryCollection)get("entrys");
    }
    /**
     * Object:车辆运输记录's 是否生成凭证property 
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
     * Object: 车辆运输记录 's 结算信息 property 
     */
    public com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordAssEntryCollection getAssEntrys()
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordAssEntryCollection)get("AssEntrys");
    }
    /**
     * Object: 车辆运输记录 's 运输车辆 property 
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
     * Object:车辆运输记录's 单程里程property 
     */
    public String getOnemileage()
    {
        return getString("onemileage");
    }
    public void setOnemileage(String item)
    {
        setString("onemileage", item);
    }
    /**
     * Object:车辆运输记录's 全程里程property 
     */
    public String getAllmileage()
    {
        return getString("allmileage");
    }
    public void setAllmileage(String item)
    {
        setString("allmileage", item);
    }
    /**
     * Object:车辆运输记录's 运费合计property 
     */
    public java.math.BigDecimal getFreight()
    {
        return getBigDecimal("freight");
    }
    public void setFreight(java.math.BigDecimal item)
    {
        setBigDecimal("freight", item);
    }
    /**
     * Object: 车辆运输记录 's 财务组织 property 
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
     * Object: 车辆运输记录 's 司机 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.DriverInfo getDrive()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.DriverInfo)get("drive");
    }
    public void setDrive(com.kingdee.eas.farm.feemanager.basedata.DriverInfo item)
    {
        put("drive", item);
    }
    /**
     * Object:车辆运输记录's 单程里程property 
     */
    public java.math.BigDecimal getSingleMileage()
    {
        return getBigDecimal("singleMileage");
    }
    public void setSingleMileage(java.math.BigDecimal item)
    {
        setBigDecimal("singleMileage", item);
    }
    /**
     * Object:车辆运输记录's 全程里程property 
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
     * Object: 车辆运输记录 's 派送信息 property 
     */
    public com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordCarEntryCollection getCarEntry()
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordCarEntryCollection)get("CarEntry");
    }
    /**
     * Object:车辆运输记录's 单据状态property 
     */
    public com.kingdee.eas.farm.feemanager.basebizbill.BillStatusEnum getStatus()
    {
        return com.kingdee.eas.farm.feemanager.basebizbill.BillStatusEnum.getEnum(getString("status"));
    }
    public void setStatus(com.kingdee.eas.farm.feemanager.basebizbill.BillStatusEnum item)
    {
		if (item != null) {
        setString("status", item.getValue());
		}
    }
    /**
     * Object:车辆运输记录's 总数量property 
     */
    public java.math.BigDecimal getTotalQty()
    {
        return getBigDecimal("totalQty");
    }
    public void setTotalQty(java.math.BigDecimal item)
    {
        setBigDecimal("totalQty", item);
    }
    /**
     * Object:车辆运输记录's 单只运费property 
     */
    public java.math.BigDecimal getAvePrice()
    {
        return getBigDecimal("avePrice");
    }
    public void setAvePrice(java.math.BigDecimal item)
    {
        setBigDecimal("avePrice", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("96CFDA63");
    }
}