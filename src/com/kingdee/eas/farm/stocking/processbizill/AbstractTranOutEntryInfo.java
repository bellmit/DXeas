package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTranOutEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTranOutEntryInfo()
    {
        this("id");
    }
    protected AbstractTranOutEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.TranOutInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.TranOutInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.TranOutInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 转出养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getOutFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("outFarm");
    }
    public void setOutFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("outFarm", item);
    }
    /**
     * Object: 分录 's 转出批次 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getOutBatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("outBatch");
    }
    public void setOutBatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("outBatch", item);
    }
    /**
     * Object:分录's 转出周龄property 
     */
    public String getOutWeek()
    {
        return getString("outWeek");
    }
    public void setOutWeek(String item)
    {
        setString("outWeek", item);
    }
    /**
     * Object:分录's 转出日龄property 
     */
    public String getOutDay()
    {
        return getString("outDay");
    }
    public void setOutDay(String item)
    {
        setString("outDay", item);
    }
    /**
     * Object:分录's 转出公鸡数property 
     */
    public java.math.BigDecimal getOutmaleQty()
    {
        return getBigDecimal("outmaleQty");
    }
    public void setOutmaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("outmaleQty", item);
    }
    /**
     * Object:分录's 转出母鸡数property 
     */
    public java.math.BigDecimal getOutFemaleQty()
    {
        return getBigDecimal("outFemaleQty");
    }
    public void setOutFemaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("outFemaleQty", item);
    }
    /**
     * Object: 分录 's 转入养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getInFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("inFarm");
    }
    public void setInFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("inFarm", item);
    }
    /**
     * Object:分录's 是否转入新批次property 
     */
    public boolean isIsNewBatch()
    {
        return getBoolean("isNewBatch");
    }
    public void setIsNewBatch(boolean item)
    {
        setBoolean("isNewBatch", item);
    }
    /**
     * Object:分录's 批次property 
     */
    public String getBatchid()
    {
        return getString("batchid");
    }
    public void setBatchid(String item)
    {
        setString("batchid", item);
    }
    /**
     * Object: 分录 's 转入批次 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getInBbatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("inBbatch");
    }
    public void setInBbatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("inBbatch", item);
    }
    /**
     * Object: 分录 's 转出棚舍 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getOutHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("outHouse");
    }
    public void setOutHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("outHouse", item);
    }
    /**
     * Object: 分录 's 转入棚舍 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getInHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("inHouse");
    }
    public void setInHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("inHouse", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E7FB91F4");
    }
}