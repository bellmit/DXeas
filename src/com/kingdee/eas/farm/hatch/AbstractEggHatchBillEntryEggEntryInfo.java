package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggHatchBillEntryEggEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractEggHatchBillEntryEggEntryInfo()
    {
        this("id");
    }
    protected AbstractEggHatchBillEntryEggEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 上孵种蛋明细 's null property 
     */
    public com.kingdee.eas.farm.hatch.EggHatchBillEntryInfo getParent1()
    {
        return (com.kingdee.eas.farm.hatch.EggHatchBillEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.farm.hatch.EggHatchBillEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object:上孵种蛋明细's 种蛋来源property 
     */
    public com.kingdee.eas.farm.hatch.EggSourceType getEggSourceType()
    {
        return com.kingdee.eas.farm.hatch.EggSourceType.getEnum(getInt("eggSourceType"));
    }
    public void setEggSourceType(com.kingdee.eas.farm.hatch.EggSourceType item)
    {
		if (item != null) {
        setInt("eggSourceType", item.getValue());
		}
    }
    /**
     * Object: 上孵种蛋明细 's 蛋库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getEggHouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("eggHouse");
    }
    public void setEggHouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("eggHouse", item);
    }
    /**
     * Object:上孵种蛋明细's 种蛋批次号property 
     */
    public String getEggLog()
    {
        return getString("eggLog");
    }
    public void setEggLog(String item)
    {
        setString("eggLog", item);
    }
    /**
     * Object: 上孵种蛋明细 's 养殖场 property 
     */
    public com.kingdee.eas.farm.breed.BreedStoorgSetInfo getFarmFactory()
    {
        return (com.kingdee.eas.farm.breed.BreedStoorgSetInfo)get("farmFactory");
    }
    public void setFarmFactory(com.kingdee.eas.farm.breed.BreedStoorgSetInfo item)
    {
        put("farmFactory", item);
    }
    /**
     * Object:上孵种蛋明细's 上孵数量property 
     */
    public int getEggQty()
    {
        return getInt("eggQty");
    }
    public void setEggQty(int item)
    {
        setInt("eggQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("067348EF");
    }
}