package com.kingdee.eas.farm.feemanager.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettlementEInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettlementEInfo()
    {
        this("id");
    }
    protected AbstractSettlementEInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 结算项目 's null property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.SettlementInfo getParent()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.SettlementInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feemanager.basedata.SettlementInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:结算项目's 鸭苗补贴单价property 
     */
    public java.math.BigDecimal getDuckamount()
    {
        return getBigDecimal("duckamount");
    }
    public void setDuckamount(java.math.BigDecimal item)
    {
        setBigDecimal("duckamount", item);
    }
    /**
     * Object: 结算项目 's 柴油单价 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.OilPriceInfo getOilprice()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.OilPriceInfo)get("oilprice");
    }
    public void setOilprice(com.kingdee.eas.farm.feemanager.basedata.OilPriceInfo item)
    {
        put("oilprice", item);
    }
    /**
     * Object: 结算项目 's 车厢 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo getCarriage()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo)get("carriage");
    }
    public void setCarriage(com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo item)
    {
        put("carriage", item);
    }
    /**
     * Object:结算项目's 实际运费property 
     */
    public java.math.BigDecimal getPolicyfreight()
    {
        return getBigDecimal("policyfreight");
    }
    public void setPolicyfreight(java.math.BigDecimal item)
    {
        setBigDecimal("policyfreight", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DC8E8110");
    }
}