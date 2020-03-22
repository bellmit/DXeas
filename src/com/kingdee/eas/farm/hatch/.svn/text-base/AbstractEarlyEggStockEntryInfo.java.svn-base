package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEarlyEggStockEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractEarlyEggStockEntryInfo()
    {
        this("id");
    }
    protected AbstractEarlyEggStockEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.hatch.EarlyEggStockInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.EarlyEggStockInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.EarlyEggStockInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 合格蛋数量property 
     */
    public java.math.BigDecimal getQualifiedEggNum()
    {
        return getBigDecimal("qualifiedEggNum");
    }
    public void setQualifiedEggNum(java.math.BigDecimal item)
    {
        setBigDecimal("qualifiedEggNum", item);
    }
    /**
     * Object:分录's 备注property 
     */
    public String getRemarks()
    {
        return getString("remarks");
    }
    public void setRemarks(String item)
    {
        setString("remarks", item);
    }
    /**
     * Object: 分录 's 养殖批次 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getBreedingbatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("breedingbatch");
    }
    public void setBreedingbatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("breedingbatch", item);
    }
    /**
     * Object:分录's 养殖场property 
     */
    public String getFarm()
    {
        return getString("farm");
    }
    public void setFarm(String item)
    {
        setString("farm", item);
    }
    /**
     * Object:分录's 养殖户property 
     */
    public String getFarmers()
    {
        return getString("farmers");
    }
    public void setFarmers(String item)
    {
        setString("farmers", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AF7118CC");
    }
}