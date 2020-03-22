package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBoarDailyLiveStockEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBoarDailyLiveStockEntryInfo()
    {
        this("id");
    }
    protected AbstractBoarDailyLiveStockEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 存栏情况 's null property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingboar.BoarDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 存栏情况 's 猪舍 property 
     */
    public com.kingdee.eas.farm.pig.PigHouseInfo getPigHouse()
    {
        return (com.kingdee.eas.farm.pig.PigHouseInfo)get("pigHouse");
    }
    public void setPigHouse(com.kingdee.eas.farm.pig.PigHouseInfo item)
    {
        put("pigHouse", item);
    }
    /**
     * Object:存栏情况's 初始头数property 
     */
    public int getStockQty()
    {
        return getInt("stockQty");
    }
    public void setStockQty(int item)
    {
        setInt("stockQty", item);
    }
    /**
     * Object:存栏情况's 日龄property 
     */
    public int getDays()
    {
        return getInt("days");
    }
    public void setDays(int item)
    {
        setInt("days", item);
    }
    /**
     * Object:存栏情况's 死淘数量property 
     */
    public int getCulldeathQty()
    {
        return getInt("culldeathQty");
    }
    public void setCulldeathQty(int item)
    {
        setInt("culldeathQty", item);
    }
    /**
     * Object:存栏情况's 出栏数量property 
     */
    public int getOutQty()
    {
        return getInt("outQty");
    }
    public void setOutQty(int item)
    {
        setInt("outQty", item);
    }
    /**
     * Object:存栏情况's 剩余头数property 
     */
    public int getEndStock()
    {
        return getInt("endStock");
    }
    public void setEndStock(int item)
    {
        setInt("endStock", item);
    }
    /**
     * Object:存栏情况's 淘汰数量property 
     */
    public int getCullQty()
    {
        return getInt("cullQty");
    }
    public void setCullQty(int item)
    {
        setInt("cullQty", item);
    }
    /**
     * Object:存栏情况's 死亡数量property 
     */
    public int getDeathQty()
    {
        return getInt("deathQty");
    }
    public void setDeathQty(int item)
    {
        setInt("deathQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("16D67827");
    }
}