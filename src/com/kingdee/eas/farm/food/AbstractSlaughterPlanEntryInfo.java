package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSlaughterPlanEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSlaughterPlanEntryInfo()
    {
        this("id");
    }
    protected AbstractSlaughterPlanEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.food.SlaughterPlanInfo getParent()
    {
        return (com.kingdee.eas.farm.food.SlaughterPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.food.SlaughterPlanInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 养殖场 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStoOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("stoOrgUnit");
    }
    public void setStoOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("stoOrgUnit", item);
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
     * Object:分录's 鸡舍名称property 
     */
    public String getHenHouseName()
    {
        return getString("henHouseName");
    }
    public void setHenHouseName(String item)
    {
        setString("henHouseName", item);
    }
    /**
     * Object:分录's 宰杀只数property 
     */
    public int getSlaughterAmt()
    {
        return getInt("SlaughterAmt");
    }
    public void setSlaughterAmt(int item)
    {
        setInt("SlaughterAmt", item);
    }
    /**
     * Object:分录's 宰杀日期property 
     */
    public java.util.Date getPkDate()
    {
        return getDate("pkDate");
    }
    public void setPkDate(java.util.Date item)
    {
        setDate("pkDate", item);
    }
    /**
     * Object:分录's 宰杀日龄property 
     */
    public int getAgeOfDaysActually()
    {
        return getInt("ageOfDaysActually");
    }
    public void setAgeOfDaysActually(int item)
    {
        setInt("ageOfDaysActually", item);
    }
    /**
     * Object:分录's 入栏日期property 
     */
    public java.util.Date getLairageDate()
    {
        return getDate("lairageDate");
    }
    public void setLairageDate(java.util.Date item)
    {
        setDate("lairageDate", item);
    }
    /**
     * Object:分录's 是否锁定property 
     */
    public boolean isIsLocked()
    {
        return getBoolean("isLocked");
    }
    public void setIsLocked(boolean item)
    {
        setBoolean("isLocked", item);
    }
    /**
     * Object: 分录 's 养殖批次 property 
     */
    public com.kingdee.eas.farm.breed.BreedBatchInfo getBreedBatch()
    {
        return (com.kingdee.eas.farm.breed.BreedBatchInfo)get("breedBatch");
    }
    public void setBreedBatch(com.kingdee.eas.farm.breed.BreedBatchInfo item)
    {
        put("breedBatch", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5940FAC0");
    }
}