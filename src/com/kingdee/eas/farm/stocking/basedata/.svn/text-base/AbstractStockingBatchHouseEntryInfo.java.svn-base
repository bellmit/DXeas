package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingBatchHouseEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStockingBatchHouseEntryInfo()
    {
        this("id");
    }
    protected AbstractStockingBatchHouseEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 棚舍明细 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 棚舍明细 's 棚舍 property 
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
     * Object:棚舍明细's 公禽数量property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:棚舍明细's 母禽数量property 
     */
    public java.math.BigDecimal getFemaleQty()
    {
        return getBigDecimal("femaleQty");
    }
    public void setFemaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleQty", item);
    }
    /**
     * Object:棚舍明细's 入雏日期property 
     */
    public java.util.Date getInData()
    {
        return getDate("inData");
    }
    public void setInData(java.util.Date item)
    {
        setDate("inData", item);
    }
    /**
     * Object:棚舍明细's 是否完全出栏property 
     */
    public boolean isIsAllOut()
    {
        return getBoolean("isAllOut");
    }
    public void setIsAllOut(boolean item)
    {
        setBoolean("isAllOut", item);
    }
    /**
     * Object:棚舍明细's 转正日期property 
     */
    public java.util.Date getFormalDate()
    {
        return getDate("formalDate");
    }
    public void setFormalDate(java.util.Date item)
    {
        setDate("formalDate", item);
    }
    /**
     * Object:棚舍明细's 完全出栏日期property 
     */
    public java.util.Date getAllOutDate()
    {
        return getDate("allOutDate");
    }
    public void setAllOutDate(java.util.Date item)
    {
        setDate("allOutDate", item);
    }
    /**
     * Object:棚舍明细's 入栏日期property 
     */
    public java.util.Date getRlData()
    {
        return getDate("rlData");
    }
    public void setRlData(java.util.Date item)
    {
        setDate("rlData", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0FE6CEEF");
    }
}