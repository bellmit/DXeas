package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLayEggDailyTransHenhouseEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLayEggDailyTransHenhouseEntryInfo()
    {
        this("id");
    }
    protected AbstractLayEggDailyTransHenhouseEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 转栏信息 's null property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:转栏信息's 是否跨批次property 
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
     * Object: 转栏信息 's 转出禽舍 property 
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
     * Object: 转栏信息 's 转入禽舍 property 
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
     * Object:转栏信息's 转栏数（♀）property 
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
     * Object:转栏信息's 转栏数（♂）property 
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
     * Object:转栏信息's 转入蛋数property 
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
     * Object:转栏信息's 是否外购property 
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
     * Object: 转栏信息 's 供应商 property 
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
     * Object: 转栏信息 's 转出栏位 property 
     */
    public com.kingdee.eas.farm.breed.HouseFieldInfo getFromField()
    {
        return (com.kingdee.eas.farm.breed.HouseFieldInfo)get("fromField");
    }
    public void setFromField(com.kingdee.eas.farm.breed.HouseFieldInfo item)
    {
        put("fromField", item);
    }
    /**
     * Object: 转栏信息 's 转入栏位 property 
     */
    public com.kingdee.eas.farm.breed.HouseFieldInfo getToField()
    {
        return (com.kingdee.eas.farm.breed.HouseFieldInfo)get("toField");
    }
    public void setToField(com.kingdee.eas.farm.breed.HouseFieldInfo item)
    {
        put("toField", item);
    }
    /**
     * Object: 转栏信息 's 转出批次 property 
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
     * Object:转栏信息's 折合定栏数（♀）property 
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
     * Object:转栏信息's 折合定栏数（♂）property 
     */
    public int getCockAsFixedQty()
    {
        return getInt("cockAsFixedQty");
    }
    public void setCockAsFixedQty(int item)
    {
        setInt("cockAsFixedQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B16790C6");
    }
}