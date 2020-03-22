package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractChickenRecBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractChickenRecBillEntryInfo()
    {
        this("id");
    }
    protected AbstractChickenRecBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 派车信息 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 派车信息 's 司机 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.DriverInfo getDriver()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.DriverInfo)get("driver");
    }
    public void setDriver(com.kingdee.eas.farm.feemanager.basedata.DriverInfo item)
    {
        put("driver", item);
    }
    /**
     * Object:派车信息's 司机联系方式property 
     */
    public String getTelephone()
    {
        return getString("telephone");
    }
    public void setTelephone(String item)
    {
        setString("telephone", item);
    }
    /**
     * Object:派车信息's 本车只数property 
     */
    public java.math.BigDecimal getChickenQty()
    {
        return getBigDecimal("chickenQty");
    }
    public void setChickenQty(java.math.BigDecimal item)
    {
        setBigDecimal("chickenQty", item);
    }
    /**
     * Object: 派车信息 's 车辆 property 
     */
    public com.kingdee.eas.publicdata.CarInfo getCar()
    {
        return (com.kingdee.eas.publicdata.CarInfo)get("car");
    }
    public void setCar(com.kingdee.eas.publicdata.CarInfo item)
    {
        put("car", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("922FAC93");
    }
}