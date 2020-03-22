package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractParentEggDailyTransEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractParentEggDailyTransEntryInfo()
    {
        this("id");
    }
    protected AbstractParentEggDailyTransEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ת����ϸ 's null property 
     */
    public com.kingdee.eas.farm.breed.layegg.ParentEggDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.layegg.ParentEggDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.layegg.ParentEggDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:ת����ϸ's ������ת��property 
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
     * Object: ת����ϸ 's ��Դ���� property 
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
     * Object: ת����ϸ 's ת������ property 
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
     * Object: ת����ϸ 's ת������ property 
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
     * Object:ת����ϸ's ת������property 
     */
    public int getTransQty()
    {
        return getInt("transQty");
    }
    public void setTransQty(int item)
    {
        setInt("transQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("11270EB5");
    }
}