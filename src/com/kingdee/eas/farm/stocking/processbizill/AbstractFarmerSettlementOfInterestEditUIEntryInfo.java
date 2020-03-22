package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerSettlementOfInterestEditUIEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFarmerSettlementOfInterestEditUIEntryInfo()
    {
        this("id");
    }
    protected AbstractFarmerSettlementOfInterestEditUIEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.FarmerSettlementOfInterestEditUIInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.FarmerSettlementOfInterestEditUIInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.FarmerSettlementOfInterestEditUIInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 养殖户姓名 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmerName()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("FarmerName");
    }
    public void setFarmerName(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("FarmerName", item);
    }
    /**
     * Object:分录's 占款利息property 
     */
    public java.math.BigDecimal getIntersetRate()
    {
        return getBigDecimal("IntersetRate");
    }
    public void setIntersetRate(java.math.BigDecimal item)
    {
        setBigDecimal("IntersetRate", item);
    }
    /**
     * Object:分录's 贷款利息property 
     */
    public java.math.BigDecimal getLocaInterest()
    {
        return getBigDecimal("LocaInterest");
    }
    public void setLocaInterest(java.math.BigDecimal item)
    {
        setBigDecimal("LocaInterest", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D99F5A42");
    }
}