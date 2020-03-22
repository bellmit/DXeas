package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggCandlingBillEntryEggEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractEggCandlingBillEntryEggEntryInfo()
    {
        this("id");
    }
    protected AbstractEggCandlingBillEntryEggEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 上孵种蛋明细 's null property 
     */
    public com.kingdee.eas.farm.hatch.EggCandlingBillEntryInfo getParent1()
    {
        return (com.kingdee.eas.farm.hatch.EggCandlingBillEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.farm.hatch.EggCandlingBillEntryInfo item)
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
    /**
     * Object:上孵种蛋明细's 无精蛋property 
     */
    public int getNoFertileEggQty()
    {
        return getInt("noFertileEggQty");
    }
    public void setNoFertileEggQty(int item)
    {
        setInt("noFertileEggQty", item);
    }
    /**
     * Object:上孵种蛋明细's 死胚property 
     */
    public int getAddleEggQty()
    {
        return getInt("addleEggQty");
    }
    public void setAddleEggQty(int item)
    {
        setInt("addleEggQty", item);
    }
    /**
     * Object:上孵种蛋明细's 破损property 
     */
    public int getBrokenEggQty()
    {
        return getInt("brokenEggQty");
    }
    public void setBrokenEggQty(int item)
    {
        setInt("brokenEggQty", item);
    }
    /**
     * Object:上孵种蛋明细's 臭蛋property 
     */
    public int getRottenEggQty()
    {
        return getInt("rottenEggQty");
    }
    public void setRottenEggQty(int item)
    {
        setInt("rottenEggQty", item);
    }
    /**
     * Object:上孵种蛋明细's 活胚property 
     */
    public int getHealthEggQty()
    {
        return getInt("healthEggQty");
    }
    public void setHealthEggQty(int item)
    {
        setInt("healthEggQty", item);
    }
    /**
     * Object:上孵种蛋明细's 其他损耗property 
     */
    public int getOtherEggQty()
    {
        return getInt("otherEggQty");
    }
    public void setOtherEggQty(int item)
    {
        setInt("otherEggQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AF16DE57");
    }
}