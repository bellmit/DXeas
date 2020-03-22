package com.kingdee.eas.farm.pig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPigBatchEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPigBatchEntryInfo()
    {
        this("id");
    }
    protected AbstractPigBatchEntryInfo(String pkField)
    {
        super(pkField);
        put("TagDetails", new com.kingdee.eas.farm.pig.PigBatchEntryTagDetailCollection());
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.pig.PigBatchInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.PigBatchInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.PigBatchInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 入栏量property 
     */
    public int getInitQty()
    {
        return getInt("initQty");
    }
    public void setInitQty(int item)
    {
        setInt("initQty", item);
    }
    /**
     * Object:分录's 入栏日期property 
     */
    public java.util.Date getIncoopDate()
    {
        return getDate("incoopDate");
    }
    public void setIncoopDate(java.util.Date item)
    {
        setDate("incoopDate", item);
    }
    /**
     * Object:分录's 已完全出栏property 
     */
    public boolean isIsMarket()
    {
        return getBoolean("isMarket");
    }
    public void setIsMarket(boolean item)
    {
        setBoolean("isMarket", item);
    }
    /**
     * Object:分录's 完全出栏日期property 
     */
    public java.util.Date getMarketDate()
    {
        return getDate("marketDate");
    }
    public void setMarketDate(java.util.Date item)
    {
        setDate("marketDate", item);
    }
    /**
     * Object:分录's 出栏总数property 
     */
    public int getMarketQty()
    {
        return getInt("marketQty");
    }
    public void setMarketQty(int item)
    {
        setInt("marketQty", item);
    }
    /**
     * Object:分录's 养殖密度（只/平米）property 
     */
    public java.math.BigDecimal getStockingDensity()
    {
        return getBigDecimal("stockingDensity");
    }
    public void setStockingDensity(java.math.BigDecimal item)
    {
        setBigDecimal("stockingDensity", item);
    }
    /**
     * Object: 分录 's 猪舍 property 
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
     * Object: 分录 's 耳标明细 property 
     */
    public com.kingdee.eas.farm.pig.PigBatchEntryTagDetailCollection getTagDetails()
    {
        return (com.kingdee.eas.farm.pig.PigBatchEntryTagDetailCollection)get("TagDetails");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0F8A9746");
    }
}