package com.kingdee.eas.publicdata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCarInfo()
    {
        this("id");
    }
    protected AbstractCarInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.publicdata.CarEntryCollection());
    }
    /**
     * Object: 车辆 's 组别 property 
     */
    public com.kingdee.eas.publicdata.CarTreeInfo getTreeid()
    {
        return (com.kingdee.eas.publicdata.CarTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.publicdata.CarTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:车辆's 皮重property 
     */
    public java.math.BigDecimal getTare()
    {
        return getBigDecimal("tare");
    }
    public void setTare(java.math.BigDecimal item)
    {
        setBigDecimal("tare", item);
    }
    /**
     * Object:车辆's 车辆类型property 
     */
    public com.kingdee.eas.publicdata.CarType getCarType()
    {
        return com.kingdee.eas.publicdata.CarType.getEnum(getString("carType"));
    }
    public void setCarType(com.kingdee.eas.publicdata.CarType item)
    {
		if (item != null) {
        setString("carType", item.getValue());
		}
    }
    /**
     * Object:车辆's 司机姓名property 
     */
    public String getDriverName()
    {
        return getString("driverName");
    }
    public void setDriverName(String item)
    {
        setString("driverName", item);
    }
    /**
     * Object: 车辆 's 司机 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getDriver()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("driver");
    }
    public void setDriver(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("driver", item);
    }
    /**
     * Object:车辆's 车辆序号property 
     */
    public String getCarOrder()
    {
        return getString("carOrder");
    }
    public void setCarOrder(String item)
    {
        setString("carOrder", item);
    }
    /**
     * Object: 车辆 's 车辆规格 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo getCarSize()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo)get("CarSize");
    }
    public void setCarSize(com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo item)
    {
        put("CarSize", item);
    }
    /**
     * Object: 车辆 's 司机姓名 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.DriverInfo getDriverID()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.DriverInfo)get("driverID");
    }
    public void setDriverID(com.kingdee.eas.farm.feemanager.basedata.DriverInfo item)
    {
        put("driverID", item);
    }
    /**
     * Object:车辆's 司机联系方式property 
     */
    public String getDriverphone()
    {
        return getString("driverphone");
    }
    public void setDriverphone(String item)
    {
        setString("driverphone", item);
    }
    /**
     * Object:车辆's 审车到期日期property 
     */
    public java.util.Date getExcar()
    {
        return getDate("excar");
    }
    public void setExcar(java.util.Date item)
    {
        setDate("excar", item);
    }
    /**
     * Object:车辆's 保险起始日期property 
     */
    public java.util.Date getSafestartdate()
    {
        return getDate("safestartdate");
    }
    public void setSafestartdate(java.util.Date item)
    {
        setDate("safestartdate", item);
    }
    /**
     * Object:车辆's 保险终止日期property 
     */
    public java.util.Date getSafeenddaste()
    {
        return getDate("safeenddaste");
    }
    public void setSafeenddaste(java.util.Date item)
    {
        setDate("safeenddaste", item);
    }
    /**
     * Object:车辆's 车辆状态property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.CarState getCarstate()
    {
        return com.kingdee.eas.farm.feemanager.basedata.CarState.getEnum(getString("carstate"));
    }
    public void setCarstate(com.kingdee.eas.farm.feemanager.basedata.CarState item)
    {
		if (item != null) {
        setString("carstate", item.getValue());
		}
    }
    /**
     * Object:车辆's 资料状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getState()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("state"));
    }
    public void setState(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("state", item.getValue());
		}
    }
    /**
     * Object: 车辆 's 财务组织 property 
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
     * Object:车辆's 车主property 
     */
    public String getCarOwner()
    {
        return getString("carOwner");
    }
    public void setCarOwner(String item)
    {
        setString("carOwner", item);
    }
    /**
     * Object:车辆's 车主联系方式property 
     */
    public String getOwnerCell()
    {
        return getString("ownerCell");
    }
    public void setOwnerCell(String item)
    {
        setString("ownerCell", item);
    }
    /**
     * Object:车辆's 车主身份证号码property 
     */
    public String getOwnerID()
    {
        return getString("ownerID");
    }
    public void setOwnerID(String item)
    {
        setString("ownerID", item);
    }
    /**
     * Object: 车辆 's 分录 property 
     */
    public com.kingdee.eas.publicdata.CarEntryCollection getEntry()
    {
        return (com.kingdee.eas.publicdata.CarEntryCollection)get("Entry");
    }
    /**
     * Object:车辆's 筐数property 
     */
    public java.math.BigDecimal getBasketsNumber()
    {
        return getBigDecimal("basketsNumber");
    }
    public void setBasketsNumber(java.math.BigDecimal item)
    {
        setBigDecimal("basketsNumber", item);
    }
    /**
     * Object: 车辆 's 自定义核算项目 property 
     */
    public com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo getGeneralAsstActType()
    {
        return (com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo)get("generalAsstActType");
    }
    public void setGeneralAsstActType(com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo item)
    {
        put("generalAsstActType", item);
    }
    /**
     * Object:车辆's 基本状态property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F8E7B111");
    }
}