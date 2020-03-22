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
     * Object: ��¼ 's null property 
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
     * Object: ��¼ 's ��ֳ�� property 
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
     * Object: ��¼ 's ��ֳ�� property 
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
     * Object:��¼'s ��ֳ����ַproperty 
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
     * Object: ��¼ 's ����� property 
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
     * Object:��¼'s ����(km)property 
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
     * Object:��¼'s �����˷�(Ԫ)property 
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
     * Object:��¼'s �����˷�(Ԫ/��)property 
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
     * Object:��¼'s ë���˷�(Ԫ/��)property 
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