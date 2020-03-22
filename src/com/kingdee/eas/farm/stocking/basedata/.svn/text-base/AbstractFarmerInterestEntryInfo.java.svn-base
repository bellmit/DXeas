package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerInterestEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFarmerInterestEntryInfo()
    {
        this("id");
    }
    protected AbstractFarmerInterestEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖户利息分录 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmerInterestInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmerInterestInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.FarmerInterestInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 养殖户利息分录 's 养殖户 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object:养殖户利息分录's 利息(%)property 
     */
    public java.math.BigDecimal getInterest()
    {
        return getBigDecimal("interest");
    }
    public void setInterest(java.math.BigDecimal item)
    {
        setBigDecimal("interest", item);
    }
    /**
     * Object: 养殖户利息分录 's 批次 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getStockingBatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("stockingBatch");
    }
    public void setStockingBatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("stockingBatch", item);
    }
    /**
     * Object: 养殖户利息分录 's 栋舍 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryInfo getOutHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryInfo)get("outHouse");
    }
    public void setOutHouse(com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryInfo item)
    {
        put("outHouse", item);
    }
    /**
     * Object: 养殖户利息分录 's 养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:养殖户利息分录's 贷款利息差property 
     */
    public java.math.BigDecimal getDiffInterest()
    {
        return getBigDecimal("diffInterest");
    }
    public void setDiffInterest(java.math.BigDecimal item)
    {
        setBigDecimal("diffInterest", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BCD62DD4");
    }
}