package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchBreedApplyBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBatchBreedApplyBillEntryInfo()
    {
        this("id");
    }
    protected AbstractBatchBreedApplyBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.BatchBreedApplyBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.BatchBreedApplyBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.BatchBreedApplyBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: 分录 's 品种 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreedData()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breedData");
    }
    public void setBreedData(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breedData", item);
    }
    /**
     * Object:分录's 上苗日期property 
     */
    public java.util.Date getBreedDate()
    {
        return getDate("breedDate");
    }
    public void setBreedDate(java.util.Date item)
    {
        setDate("breedDate", item);
    }
    /**
     * Object:分录's 上苗数量property 
     */
    public java.math.BigDecimal getBreedQty()
    {
        return getBigDecimal("breedQty");
    }
    public void setBreedQty(java.math.BigDecimal item)
    {
        setBigDecimal("breedQty", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AE64423C");
    }
}