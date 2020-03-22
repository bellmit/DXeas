package com.kingdee.eas.farm.carnivorous.basebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMarginUnlockBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMarginUnlockBillEntryInfo()
    {
        this("id");
    }
    protected AbstractMarginUnlockBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 解锁金额property 
     */
    public java.math.BigDecimal getUnlockAmt()
    {
        return getBigDecimal("unlockAmt");
    }
    public void setUnlockAmt(java.math.BigDecimal item)
    {
        setBigDecimal("unlockAmt", item);
    }
    /**
     * Object: 分录 's 批次合同  property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo getBatchContract()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo)get("batchContract");
    }
    public void setBatchContract(com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo item)
    {
        put("batchContract", item);
    }
    /**
     * Object:分录's 解锁初始化property 
     */
    public boolean isIsUnlockInit()
    {
        return getBoolean("isUnlockInit");
    }
    public void setIsUnlockInit(boolean item)
    {
        setBoolean("isUnlockInit", item);
    }
    /**
     * Object:分录's 初始化占用金额property 
     */
    public java.math.BigDecimal getInitOccupyMargin()
    {
        return getBigDecimal("initOccupyMargin");
    }
    public void setInitOccupyMargin(java.math.BigDecimal item)
    {
        setBigDecimal("initOccupyMargin", item);
    }
    /**
     * Object:分录's 实际上苗日期property 
     */
    public java.util.Date getActualInDate()
    {
        return getDate("actualInDate");
    }
    public void setActualInDate(java.util.Date item)
    {
        setDate("actualInDate", item);
    }
    /**
     * Object:分录's 剩余单只保证金property 
     */
    public java.math.BigDecimal getRestSingleMargin()
    {
        return getBigDecimal("restSingleMargin");
    }
    public void setRestSingleMargin(java.math.BigDecimal item)
    {
        setBigDecimal("restSingleMargin", item);
    }
    /**
     * Object:分录's 可解锁占用保证金property 
     */
    public java.math.BigDecimal getActualUsedMargin()
    {
        return getBigDecimal("actualUsedMargin");
    }
    public void setActualUsedMargin(java.math.BigDecimal item)
    {
        setBigDecimal("actualUsedMargin", item);
    }
    /**
     * Object:分录's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object: 分录 's 养殖批次 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchInfo getStockingBatch()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchInfo)get("stockingBatch");
    }
    public void setStockingBatch(com.kingdee.eas.farm.carnivorous.basedata.BatchInfo item)
    {
        put("stockingBatch", item);
    }
    /**
     * Object:分录's 已解锁初始化占用金额property 
     */
    public java.math.BigDecimal getUnLockedOpMargin()
    {
        return getBigDecimal("unLockedOpMargin");
    }
    public void setUnLockedOpMargin(java.math.BigDecimal item)
    {
        setBigDecimal("unLockedOpMargin", item);
    }
    /**
     * Object:分录's 可解锁初始化占用金额property 
     */
    public java.math.BigDecimal getEnableOccupyMargin()
    {
        return getBigDecimal("enableOccupyMargin");
    }
    public void setEnableOccupyMargin(java.math.BigDecimal item)
    {
        setBigDecimal("enableOccupyMargin", item);
    }
    /**
     * Object:分录's 上苗数量property 
     */
    public java.math.BigDecimal getBatchQty()
    {
        return getBigDecimal("batchQty");
    }
    public void setBatchQty(java.math.BigDecimal item)
    {
        setBigDecimal("batchQty", item);
    }
    /**
     * Object:分录's 最低保证金property 
     */
    public java.math.BigDecimal getMMargin()
    {
        return getBigDecimal("mMargin");
    }
    public void setMMargin(java.math.BigDecimal item)
    {
        setBigDecimal("mMargin", item);
    }
    /**
     * Object:分录's 标准保证金property 
     */
    public java.math.BigDecimal getSMargin()
    {
        return getBigDecimal("sMargin");
    }
    public void setSMargin(java.math.BigDecimal item)
    {
        setBigDecimal("sMargin", item);
    }
    /**
     * Object: 分录 's 养殖场 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("farm", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FE69BA02");
    }
}