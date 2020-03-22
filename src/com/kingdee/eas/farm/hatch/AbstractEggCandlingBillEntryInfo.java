package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggCandlingBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractEggCandlingBillEntryInfo()
    {
        this("id");
    }
    protected AbstractEggCandlingBillEntryInfo(String pkField)
    {
        super(pkField);
        put("EggEntrys", new com.kingdee.eas.farm.hatch.EggCandlingBillEntryEggEntryCollection());
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.hatch.EggCandlingBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.EggCandlingBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.EggCandlingBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 上孵种蛋明细 property 
     */
    public com.kingdee.eas.farm.hatch.EggCandlingBillEntryEggEntryCollection getEggEntrys()
    {
        return (com.kingdee.eas.farm.hatch.EggCandlingBillEntryEggEntryCollection)get("EggEntrys");
    }
    /**
     * Object: 分录 's 孵化箱 property 
     */
    public com.kingdee.eas.farm.hatch.IncubatorInfo getIncubator()
    {
        return (com.kingdee.eas.farm.hatch.IncubatorInfo)get("incubator");
    }
    public void setIncubator(com.kingdee.eas.farm.hatch.IncubatorInfo item)
    {
        put("incubator", item);
    }
    /**
     * Object:分录's 上孵总蛋数property 
     */
    public int getEggAllQty()
    {
        return getInt("eggAllQty");
    }
    public void setEggAllQty(int item)
    {
        setInt("eggAllQty", item);
    }
    /**
     * Object:分录's 无精蛋property 
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
     * Object:分录's 死胚property 
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
     * Object:分录's 臭蛋property 
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
     * Object:分录's 活胚property 
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
     * Object:分录's 其他损耗property 
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
        return new BOSObjectType("F39918CA");
    }
}