package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchPlanEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBatchPlanEntryInfo()
    {
        this("id");
    }
    protected AbstractBatchPlanEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.hatch.BatchPlanInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.BatchPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.BatchPlanInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 入孵日期property 
     */
    public java.util.Date getPlanDate()
    {
        return getDate("planDate");
    }
    public void setPlanDate(java.util.Date item)
    {
        setDate("planDate", item);
    }
    /**
     * Object:分录's 上孵车数property 
     */
    public int getCarCount()
    {
        return getInt("carCount");
    }
    public void setCarCount(int item)
    {
        setInt("carCount", item);
    }
    /**
     * Object:分录's 上孵数量property 
     */
    public int getEggQty()
    {
        return getInt("eggQty");
    }
    public void setEggQty(int item)
    {
        setInt("eggQty", item);
    }
    /**
     * Object:分录's 出雏日期property 
     */
    public java.util.Date getHatchBabyDate()
    {
        return getDate("hatchBabyDate");
    }
    public void setHatchBabyDate(java.util.Date item)
    {
        setDate("hatchBabyDate", item);
    }
    /**
     * Object: 分录 's 鸡苗去向（商品场） property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getCcFarm()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("ccFarm");
    }
    public void setCcFarm(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("ccFarm", item);
    }
    /**
     * Object:分录's 预计孵化率(%)property 
     */
    public java.math.BigDecimal getPreHatchRate()
    {
        return getBigDecimal("preHatchRate");
    }
    public void setPreHatchRate(java.math.BigDecimal item)
    {
        setBigDecimal("preHatchRate", item);
    }
    /**
     * Object:分录's 预计出雏数property 
     */
    public int getPreHatchQty()
    {
        return getInt("preHatchQty");
    }
    public void setPreHatchQty(int item)
    {
        setInt("preHatchQty", item);
    }
    /**
     * Object:分录's 商品鸡场需求量property 
     */
    public java.math.BigDecimal getRequirementAmt()
    {
        return getBigDecimal("requirementAmt");
    }
    public void setRequirementAmt(java.math.BigDecimal item)
    {
        setBigDecimal("requirementAmt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C4F5063D");
    }
}