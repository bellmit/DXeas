package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCostAllocationEntryDetailInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCostAllocationEntryDetailInfo()
    {
        this("id");
    }
    protected AbstractCostAllocationEntryDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分配明细 's null property 
     */
    public com.kingdee.eas.farm.dayratecost.CostAllocationEntryInfo getParent1()
    {
        return (com.kingdee.eas.farm.dayratecost.CostAllocationEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.farm.dayratecost.CostAllocationEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object: 分配明细 's 棚舍 property 
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
     * Object: 分配明细 's 批次 property 
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
     * Object: 分配明细 's 养殖户 property 
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
     * Object: 分配明细 's 养殖场 property 
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
     * Object:分配明细's 定群日期property 
     */
    public java.util.Date getMatureDate()
    {
        return getDate("matureDate");
    }
    public void setMatureDate(java.util.Date item)
    {
        setDate("matureDate", item);
    }
    /**
     * Object:分配明细's 定群比例property 
     */
    public java.math.BigDecimal getMatureprop()
    {
        return getBigDecimal("matureprop");
    }
    public void setMatureprop(java.math.BigDecimal item)
    {
        setBigDecimal("matureprop", item);
    }
    /**
     * Object:分配明细's 定群分摊金额property 
     */
    public java.math.BigDecimal getMatureAmount()
    {
        return getBigDecimal("matureAmount");
    }
    public void setMatureAmount(java.math.BigDecimal item)
    {
        setBigDecimal("matureAmount", item);
    }
    /**
     * Object:分配明细's 分摊金额property 
     */
    public java.math.BigDecimal getAlloctionAmount()
    {
        return getBigDecimal("alloctionAmount");
    }
    public void setAlloctionAmount(java.math.BigDecimal item)
    {
        setBigDecimal("alloctionAmount", item);
    }
    /**
     * Object:分配明细's 批次分摊比例property 
     */
    public java.math.BigDecimal getProportion()
    {
        return getBigDecimal("proportion");
    }
    public void setProportion(java.math.BigDecimal item)
    {
        setBigDecimal("proportion", item);
    }
    /**
     * Object:分配明细's 批次分摊金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:分配明细's 养殖阶段property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmStageEnum getBreedStage()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmStageEnum.getEnum(getInt("breedStage"));
    }
    public void setBreedStage(com.kingdee.eas.farm.stocking.basedata.FarmStageEnum item)
    {
		if (item != null) {
        setInt("breedStage", item.getValue());
		}
    }
    /**
     * Object:分配明细's 日存栏合计property 
     */
    public int getLastStock()
    {
        return getInt("lastStock");
    }
    public void setLastStock(int item)
    {
        setInt("lastStock", item);
    }
    /**
     * Object:分配明细's 总日存栏合计property 
     */
    public int getAllLastStock()
    {
        return getInt("allLastStock");
    }
    public void setAllLastStock(int item)
    {
        setInt("allLastStock", item);
    }
    /**
     * Object:分配明细's 定群存栏合计property 
     */
    public int getMatureQty()
    {
        return getInt("matureQty");
    }
    public void setMatureQty(int item)
    {
        setInt("matureQty", item);
    }
    /**
     * Object:分配明细's 批次分摊比例property 
     */
    public java.math.BigDecimal getProportion2()
    {
        return getBigDecimal("proportion2");
    }
    public void setProportion2(java.math.BigDecimal item)
    {
        setBigDecimal("proportion2", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("05FA66D1");
    }
}