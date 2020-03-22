package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFreightBaseEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFreightBaseEntryInfo()
    {
        this("id");
    }
    protected AbstractFreightBaseEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 运费系数分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FreightBaseInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FreightBaseInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.FreightBaseInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:运费系数分录's 最低里程property 
     */
    public java.math.BigDecimal getLowKm()
    {
        return getBigDecimal("lowKm");
    }
    public void setLowKm(java.math.BigDecimal item)
    {
        setBigDecimal("lowKm", item);
    }
    /**
     * Object:运费系数分录's 最高里程property 
     */
    public java.math.BigDecimal getTopKm()
    {
        return getBigDecimal("topKm");
    }
    public void setTopKm(java.math.BigDecimal item)
    {
        setBigDecimal("topKm", item);
    }
    /**
     * Object:运费系数分录's 运费单价property 
     */
    public java.math.BigDecimal getFreightPrice()
    {
        return getBigDecimal("freightPrice");
    }
    public void setFreightPrice(java.math.BigDecimal item)
    {
        setBigDecimal("freightPrice", item);
    }
    /**
     * Object:运费系数分录's 按吨数计算property 
     */
    public boolean isUseTon()
    {
        return getBoolean("useTon");
    }
    public void setUseTon(boolean item)
    {
        setBoolean("useTon", item);
    }
    /**
     * Object:运费系数分录's 按里程和吨数计算property 
     */
    public boolean isUserTonKm()
    {
        return getBoolean("userTonKm");
    }
    public void setUserTonKm(boolean item)
    {
        setBoolean("userTonKm", item);
    }
    /**
     * Object:运费系数分录's 按里程计算property 
     */
    public boolean isUserKm()
    {
        return getBoolean("userKm");
    }
    public void setUserKm(boolean item)
    {
        setBoolean("userKm", item);
    }
    /**
     * Object:运费系数分录's 固定值property 
     */
    public boolean isUseStable()
    {
        return getBoolean("useStable");
    }
    public void setUseStable(boolean item)
    {
        setBoolean("useStable", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("03C3B1C0");
    }
}