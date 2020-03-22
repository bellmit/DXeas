package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchEggReceivingBillGoodsEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractHatchEggReceivingBillGoodsEntryInfo()
    {
        this("id");
    }
    protected AbstractHatchEggReceivingBillGoodsEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 商品蛋分录 's null property 
     */
    public com.kingdee.eas.farm.hatch.HatchEggReceivingBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.HatchEggReceivingBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.HatchEggReceivingBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 商品蛋分录 's 养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getStockingFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("stockingFarm");
    }
    public void setStockingFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("stockingFarm", item);
    }
    /**
     * Object:商品蛋分录's 不合格蛋property 
     */
    public java.math.BigDecimal getUnqualifiedEggs()
    {
        return getBigDecimal("UnqualifiedEggs");
    }
    public void setUnqualifiedEggs(java.math.BigDecimal item)
    {
        setBigDecimal("UnqualifiedEggs", item);
    }
    /**
     * Object:商品蛋分录's 破蛋 property 
     */
    public java.math.BigDecimal getBrokenEggs()
    {
        return getBigDecimal("brokenEggs");
    }
    public void setBrokenEggs(java.math.BigDecimal item)
    {
        setBigDecimal("brokenEggs", item);
    }
    /**
     * Object:商品蛋分录's 损耗蛋property 
     */
    public java.math.BigDecimal getLossEggs()
    {
        return getBigDecimal("lossEggs");
    }
    public void setLossEggs(java.math.BigDecimal item)
    {
        setBigDecimal("lossEggs", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FE4D6BF0");
    }
}