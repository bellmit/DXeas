package com.kingdee.eas.farm.feemanager.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettlementCEInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettlementCEInfo()
    {
        this("id");
    }
    protected AbstractSettlementCEInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 车厢 's null property 
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
     * Object: 车厢 's 车厢 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo getCarsize()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo)get("carsize");
    }
    public void setCarsize(com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo item)
    {
        put("carsize", item);
    }
    /**
     * Object:车厢's 车厢规格property 
     */
    public String getCarsizetype()
    {
        return getString("carsizetype");
    }
    public void setCarsizetype(String item)
    {
        setString("carsizetype", item);
    }
    /**
     * Object:车厢's 每公里运费property 
     */
    public java.math.BigDecimal getKilamount()
    {
        return getBigDecimal("kilamount");
    }
    public void setKilamount(java.math.BigDecimal item)
    {
        setBigDecimal("kilamount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B541A0F7");
    }
}