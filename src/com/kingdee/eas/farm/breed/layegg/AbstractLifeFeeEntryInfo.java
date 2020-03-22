package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLifeFeeEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLifeFeeEntryInfo()
    {
        this("id");
    }
    protected AbstractLifeFeeEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.breed.layegg.LifeFeeInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.layegg.LifeFeeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.layegg.LifeFeeInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 养殖户 property 
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
     * Object: 分录 's 批次 property 
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
     * Object:分录's 上苗日期property 
     */
    public java.util.Date getInitDate()
    {
        return getDate("initDate");
    }
    public void setInitDate(java.util.Date item)
    {
        setDate("initDate", item);
    }
    /**
     * Object:分录's 月底日龄property 
     */
    public int getDayAge()
    {
        return getInt("dayAge");
    }
    public void setDayAge(int item)
    {
        setInt("dayAge", item);
    }
    /**
     * Object:分录's 母鸭存栏量property 
     */
    public int getFemaleQty()
    {
        return getInt("femaleQty");
    }
    public void setFemaleQty(int item)
    {
        setInt("femaleQty", item);
    }
    /**
     * Object:分录's 单只生活费property 
     */
    public java.math.BigDecimal getLifeFeeAvg()
    {
        return getBigDecimal("lifeFeeAvg");
    }
    public void setLifeFeeAvg(java.math.BigDecimal item)
    {
        setBigDecimal("lifeFeeAvg", item);
    }
    /**
     * Object:分录's 本月生活费property 
     */
    public java.math.BigDecimal getLifeFeeAll()
    {
        return getBigDecimal("lifeFeeAll");
    }
    public void setLifeFeeAll(java.math.BigDecimal item)
    {
        setBigDecimal("lifeFeeAll", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E106F0B5");
    }
}