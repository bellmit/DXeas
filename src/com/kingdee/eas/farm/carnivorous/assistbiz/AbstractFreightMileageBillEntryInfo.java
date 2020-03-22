package com.kingdee.eas.farm.carnivorous.assistbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFreightMileageBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFreightMileageBillEntryInfo()
    {
        this("id");
    }
    protected AbstractFreightMileageBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.assistbiz.FreightMileageBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.FreightMileageBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.assistbiz.FreightMileageBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 养殖户 property 
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
     * Object: 分录 's 养殖场 property 
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
     * Object:分录's 养殖场地址property 
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
     * Object: 分录 's 计算点 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FreightCalPointInfo getCalUnit()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FreightCalPointInfo)get("calUnit");
    }
    public void setCalUnit(com.kingdee.eas.farm.carnivorous.basedata.FreightCalPointInfo item)
    {
        put("calUnit", item);
    }
    /**
     * Object:分录's 距离(km)property 
     */
    public java.math.BigDecimal getDistance()
    {
        return getBigDecimal("distance");
    }
    public void setDistance(java.math.BigDecimal item)
    {
        setBigDecimal("distance", item);
    }
    /**
     * Object:分录's 雏苗运费(元)property 
     */
    public java.math.BigDecimal getSeedFreight()
    {
        return getBigDecimal("seedFreight");
    }
    public void setSeedFreight(java.math.BigDecimal item)
    {
        setBigDecimal("seedFreight", item);
    }
    /**
     * Object:分录's 饲料运费(元/吨)property 
     */
    public java.math.BigDecimal getFodderFreight()
    {
        return getBigDecimal("fodderFreight");
    }
    public void setFodderFreight(java.math.BigDecimal item)
    {
        setBigDecimal("fodderFreight", item);
    }
    /**
     * Object:分录's 毛鸡运费(元/吨)property 
     */
    public java.math.BigDecimal getRecCKFreight()
    {
        return getBigDecimal("recCKFreight");
    }
    public void setRecCKFreight(java.math.BigDecimal item)
    {
        setBigDecimal("recCKFreight", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("49020AD5");
    }
}