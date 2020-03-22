package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedBatchEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedBatchEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedBatchEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.breed.BreedBatchInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.BreedBatchInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.BreedBatchInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 鸡舍 property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getHenHouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("henHouse");
    }
    public void setHenHouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("henHouse", item);
    }
    /**
     * Object:分录's 鸡类别property 
     */
    public com.kingdee.eas.farm.breed.ChikenType getChikenType()
    {
        return com.kingdee.eas.farm.breed.ChikenType.getEnum(getString("chikenType"));
    }
    public void setChikenType(com.kingdee.eas.farm.breed.ChikenType item)
    {
		if (item != null) {
        setString("chikenType", item.getValue());
		}
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
     * Object:分录's 鸡舍名称property 
     */
    public String getHenhouseName()
    {
        return getString("henhouseName");
    }
    public void setHenhouseName(String item)
    {
        setString("henhouseName", item);
    }
    /**
     * Object:分录's 母鸡入栏量property 
     */
    public int getHenQty()
    {
        return getInt("henQty");
    }
    public void setHenQty(int item)
    {
        setInt("henQty", item);
    }
    /**
     * Object:分录's 公鸡入栏量property 
     */
    public int getCockQty()
    {
        return getInt("cockQty");
    }
    public void setCockQty(int item)
    {
        setInt("cockQty", item);
    }
    /**
     * Object:分录's 母鸡定栏量property 
     */
    public int getHenFixedQty()
    {
        return getInt("henFixedQty");
    }
    public void setHenFixedQty(int item)
    {
        setInt("henFixedQty", item);
    }
    /**
     * Object:分录's 公鸡定栏量property 
     */
    public int getCockFixedQty()
    {
        return getInt("cockFixedQty");
    }
    public void setCockFixedQty(int item)
    {
        setInt("cockFixedQty", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AE939152");
    }
}