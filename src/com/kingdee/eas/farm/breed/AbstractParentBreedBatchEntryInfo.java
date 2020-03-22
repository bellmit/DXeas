package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractParentBreedBatchEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractParentBreedBatchEntryInfo()
    {
        this("id");
    }
    protected AbstractParentBreedBatchEntryInfo(String pkField)
    {
        super(pkField);
        put("FieldDetailEntrys", new com.kingdee.eas.farm.breed.ParentBreedBatchEntryFieldDetailEntryCollection());
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.breed.ParentBreedBatchInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.ParentBreedBatchInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.ParentBreedBatchInfo item)
    {
        put("parent", item);
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
     * Object: 分录 's 禽舍 property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getHenhouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("henhouse");
    }
    public void setHenhouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("henhouse", item);
    }
    /**
     * Object:分录's 入栏量（♀）property 
     */
    public int getHenInitQty()
    {
        return getInt("henInitQty");
    }
    public void setHenInitQty(int item)
    {
        setInt("henInitQty", item);
    }
    /**
     * Object:分录's 入栏量（♂）property 
     */
    public int getCockInitQty()
    {
        return getInt("cockInitQty");
    }
    public void setCockInitQty(int item)
    {
        setInt("cockInitQty", item);
    }
    /**
     * Object: 分录 's 入栏明细 property 
     */
    public com.kingdee.eas.farm.breed.ParentBreedBatchEntryFieldDetailEntryCollection getFieldDetailEntrys()
    {
        return (com.kingdee.eas.farm.breed.ParentBreedBatchEntryFieldDetailEntryCollection)get("FieldDetailEntrys");
    }
    /**
     * Object:分录's 禽舍名称property 
     */
    public String getHenhouseName()
    {
        return getString("henhouseName");
    }
    public void setHenhouseName(String item)
    {
        setString("henhouseName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A719F2C8");
    }
}