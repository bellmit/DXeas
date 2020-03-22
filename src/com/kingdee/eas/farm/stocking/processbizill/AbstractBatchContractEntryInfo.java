package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchContractEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBatchContractEntryInfo()
    {
        this("id");
    }
    protected AbstractBatchContractEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo item)
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
     * Object: 分录 's 养殖品种 property 
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
     * Object:分录's 养殖数量property 
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
     * Object:分录's 入雏日期property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object: 分录 's 批次编码 property 
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
     * Object:分录's 只保证金property 
     */
    public java.math.BigDecimal getUnitMargin()
    {
        return getBigDecimal("unitMargin");
    }
    public void setUnitMargin(java.math.BigDecimal item)
    {
        setBigDecimal("unitMargin", item);
    }
    /**
     * Object: 分录 's 结算政策 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo getSettlementPolicy()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo)get("settlementPolicy");
    }
    public void setSettlementPolicy(com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo item)
    {
        put("settlementPolicy", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5B36558B");
    }
}