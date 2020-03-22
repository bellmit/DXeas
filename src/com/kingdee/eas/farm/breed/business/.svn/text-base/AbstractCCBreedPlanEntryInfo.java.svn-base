package com.kingdee.eas.farm.breed.business;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCBreedPlanEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCCBreedPlanEntryInfo()
    {
        this("id");
    }
    protected AbstractCCBreedPlanEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.breed.business.CCBreedPlanInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.business.CCBreedPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.business.CCBreedPlanInfo item)
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
     * Object:分录's  备注property 
     */
    public String getDescription()
    {
        return getString("description");
    }
    public void setDescription(String item)
    {
        setString("description", item);
    }
    /**
     * Object:分录's 养殖密度property 
     */
    public java.math.BigDecimal getStockingdensity()
    {
        return getBigDecimal("stockingdensity");
    }
    public void setStockingdensity(java.math.BigDecimal item)
    {
        setBigDecimal("stockingdensity", item);
    }
    /**
     * Object:分录's 预计出栏量property 
     */
    public java.math.BigDecimal getSlaughterAmt()
    {
        return getBigDecimal("slaughterAmt");
    }
    public void setSlaughterAmt(java.math.BigDecimal item)
    {
        setBigDecimal("slaughterAmt", item);
    }
    /**
     * Object:分录's 预计出栏日期property 
     */
    public java.util.Date getSlaughterDate()
    {
        return getDate("slaughterDate");
    }
    public void setSlaughterDate(java.util.Date item)
    {
        setDate("slaughterDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("630F6763");
    }
}