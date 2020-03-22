package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCarSendBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCCarSendBillEntryInfo()
    {
        this("id");
    }
    protected AbstractCCarSendBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 基础信息 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 基础信息 's 养殖户 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getFarmer()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: 基础信息 's 养殖场 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:基础信息's 养殖场地址property 
     */
    public String getFarmAddress()
    {
        return getString("farmAddress");
    }
    public void setFarmAddress(String item)
    {
        setString("farmAddress", item);
    }
    /**
     * Object:基础信息's 养殖户联系方式property 
     */
    public String getFarmerTele()
    {
        return getString("farmerTele");
    }
    public void setFarmerTele(String item)
    {
        setString("farmerTele", item);
    }
    /**
     * Object: 基础信息 's 养殖批次 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchInfo getBatch()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchInfo)get("batch");
    }
    public void setBatch(com.kingdee.eas.farm.carnivorous.basedata.BatchInfo item)
    {
        put("batch", item);
    }
    /**
     * Object:基础信息's 上苗日期property 
     */
    public java.util.Date getInDate()
    {
        return getDate("inDate");
    }
    public void setInDate(java.util.Date item)
    {
        setDate("inDate", item);
    }
    /**
     * Object:基础信息's 上苗数量property 
     */
    public java.math.BigDecimal getInQty()
    {
        return getBigDecimal("inQty");
    }
    public void setInQty(java.math.BigDecimal item)
    {
        setBigDecimal("inQty", item);
    }
    /**
     * Object:基础信息's 日龄property 
     */
    public int getDays()
    {
        return getInt("days");
    }
    public void setDays(int item)
    {
        setInt("days", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1C76AE15");
    }
}