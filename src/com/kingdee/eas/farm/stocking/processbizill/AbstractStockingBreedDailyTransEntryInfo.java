package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingBreedDailyTransEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStockingBreedDailyTransEntryInfo()
    {
        this("id");
    }
    protected AbstractStockingBreedDailyTransEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ת����¼ 's null property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:ת����¼'s ��������property 
     */
    public int getTransQty()
    {
        return getInt("transQty");
    }
    public void setTransQty(int item)
    {
        setInt("transQty", item);
    }
    /**
     * Object:ת����¼'s ĸ������property 
     */
    public int getTransFemaleQty()
    {
        return getInt("transFemaleQty");
    }
    public void setTransFemaleQty(int item)
    {
        setInt("transFemaleQty", item);
    }
    /**
     * Object: ת����¼ 's ���� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("house", item);
    }
    /**
     * Object: ת����¼ 's ת������ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getFromStockingBatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("fromStockingBatch");
    }
    public void setFromStockingBatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("fromStockingBatch", item);
    }
    /**
     * Object: ת����¼ 's ת����ֳ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFromFarmers()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("fromFarmers");
    }
    public void setFromFarmers(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("fromFarmers", item);
    }
    /**
     * Object: ת����¼ 's ת����ֳ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFromFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("fromFarm");
    }
    public void setFromFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("fromFarm", item);
    }
    /**
     * Object: ת����¼ 's ת������ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getFromHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("fromHouse");
    }
    public void setFromHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("fromHouse", item);
    }
    /**
     * Object:ת����¼'s ��עproperty 
     */
    public String getDescription()
    {
        return getString("description");
    }
    public void setDescription(String item)
    {
        setString("description", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("90985EA0");
    }
}