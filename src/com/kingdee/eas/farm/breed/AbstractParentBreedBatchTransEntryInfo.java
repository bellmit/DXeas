package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractParentBreedBatchTransEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractParentBreedBatchTransEntryInfo()
    {
        this("id");
    }
    protected AbstractParentBreedBatchTransEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 转栏分录 's null property 
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
     * Object:转栏分录's 是否跨批次转栏property 
     */
    public boolean isIsFromOtherBatch()
    {
        return getBoolean("isFromOtherBatch");
    }
    public void setIsFromOtherBatch(boolean item)
    {
        setBoolean("isFromOtherBatch", item);
    }
    /**
     * Object: 转栏分录 's 来源禽舍 property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getFromHenhouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("fromHenhouse");
    }
    public void setFromHenhouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("fromHenhouse", item);
    }
    /**
     * Object: 转栏分录 's 转入禽舍 property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getToHenhouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("toHenhouse");
    }
    public void setToHenhouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("toHenhouse", item);
    }
    /**
     * Object:转栏分录's 转栏日期property 
     */
    public java.util.Date getTransDate()
    {
        return getDate("transDate");
    }
    public void setTransDate(java.util.Date item)
    {
        setDate("transDate", item);
    }
    /**
     * Object:转栏分录's 转栏后周龄property 
     */
    public int getTransWeeks()
    {
        return getInt("transWeeks");
    }
    public void setTransWeeks(int item)
    {
        setInt("transWeeks", item);
    }
    /**
     * Object:转栏分录's 专栏后周日龄property 
     */
    public int getTransWeekDays()
    {
        return getInt("transWeekDays");
    }
    public void setTransWeekDays(int item)
    {
        setInt("transWeekDays", item);
    }
    /**
     * Object: 转栏分录 's 转出栏位 property 
     */
    public com.kingdee.eas.farm.breed.HouseFieldInfo getOutHousefield()
    {
        return (com.kingdee.eas.farm.breed.HouseFieldInfo)get("outHousefield");
    }
    public void setOutHousefield(com.kingdee.eas.farm.breed.HouseFieldInfo item)
    {
        put("outHousefield", item);
    }
    /**
     * Object: 转栏分录 's 转入栏位 property 
     */
    public com.kingdee.eas.farm.breed.HouseFieldInfo getInHousefield()
    {
        return (com.kingdee.eas.farm.breed.HouseFieldInfo)get("inHousefield");
    }
    public void setInHousefield(com.kingdee.eas.farm.breed.HouseFieldInfo item)
    {
        put("inHousefield", item);
    }
    /**
     * Object:转栏分录's 是否外购property 
     */
    public boolean isIsBuy()
    {
        return getBoolean("isBuy");
    }
    public void setIsBuy(boolean item)
    {
        setBoolean("isBuy", item);
    }
    /**
     * Object: 转栏分录 's 供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object:转栏分录's 是否转出property 
     */
    public boolean isIsTransOut()
    {
        return getBoolean("isTransOut");
    }
    public void setIsTransOut(boolean item)
    {
        setBoolean("isTransOut", item);
    }
    /**
     * Object:转栏分录's 转移蛋数property 
     */
    public int getAsTransEggQty()
    {
        return getInt("asTransEggQty");
    }
    public void setAsTransEggQty(int item)
    {
        setInt("asTransEggQty", item);
    }
    /**
     * Object:转栏分录's 转栏数量（♀）property 
     */
    public int getTransHenQty()
    {
        return getInt("transHenQty");
    }
    public void setTransHenQty(int item)
    {
        setInt("transHenQty", item);
    }
    /**
     * Object:转栏分录's 转栏数量（♂）property 
     */
    public int getTransCockQty()
    {
        return getInt("transCockQty");
    }
    public void setTransCockQty(int item)
    {
        setInt("transCockQty", item);
    }
    /**
     * Object:转栏分录's 源单据IDproperty 
     */
    public String getSourceBillID()
    {
        return getString("sourceBillID");
    }
    public void setSourceBillID(String item)
    {
        setString("sourceBillID", item);
    }
    /**
     * Object:转栏分录's 源明细分录IDproperty 
     */
    public String getSourceEntryID()
    {
        return getString("sourceEntryID");
    }
    public void setSourceEntryID(String item)
    {
        setString("sourceEntryID", item);
    }
    /**
     * Object:转栏分录's 折合定栏数（♀）property 
     */
    public int getHenAsFixedQty()
    {
        return getInt("henAsFixedQty");
    }
    public void setHenAsFixedQty(int item)
    {
        setInt("henAsFixedQty", item);
    }
    /**
     * Object:转栏分录's 折合定栏数（♂）property 
     */
    public int getCockAsFixedQty()
    {
        return getInt("cockAsFixedQty");
    }
    public void setCockAsFixedQty(int item)
    {
        setInt("cockAsFixedQty", item);
    }
    /**
     * Object: 转栏分录 's 转出批次 property 
     */
    public com.kingdee.eas.farm.breed.ParentBreedBatchInfo getFromBatch()
    {
        return (com.kingdee.eas.farm.breed.ParentBreedBatchInfo)get("fromBatch");
    }
    public void setFromBatch(com.kingdee.eas.farm.breed.ParentBreedBatchInfo item)
    {
        put("fromBatch", item);
    }
    /**
     * Object: 转栏分录 's 转入批次 property 
     */
    public com.kingdee.eas.farm.breed.ParentBreedBatchInfo getToBatch()
    {
        return (com.kingdee.eas.farm.breed.ParentBreedBatchInfo)get("toBatch");
    }
    public void setToBatch(com.kingdee.eas.farm.breed.ParentBreedBatchInfo item)
    {
        put("toBatch", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3C69AA14");
    }
}