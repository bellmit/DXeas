package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingBreedDailySendEggEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStockingBreedDailySendEggEntryInfo()
    {
        this("id");
    }
    protected AbstractStockingBreedDailySendEggEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 蛋品报送 's null property 
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
     * Object: 蛋品报送 's 栋舍 property 
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
     * Object: 蛋品报送 's 物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:蛋品报送's 合格蛋property 
     */
    public int getQcQty()
    {
        return getInt("qcQty");
    }
    public void setQcQty(int item)
    {
        setInt("qcQty", item);
    }
    /**
     * Object:蛋品报送's 总蛋数property 
     */
    public int getAllQty()
    {
        return getInt("allQty");
    }
    public void setAllQty(int item)
    {
        setInt("allQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1F4EA18B");
    }
}