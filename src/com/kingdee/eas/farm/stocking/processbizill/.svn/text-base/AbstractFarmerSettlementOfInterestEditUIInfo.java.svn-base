package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerSettlementOfInterestEditUIInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFarmerSettlementOfInterestEditUIInfo()
    {
        this("id");
    }
    protected AbstractFarmerSettlementOfInterestEditUIInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.stocking.processbizill.FarmerSettlementOfInterestEditUIEntryCollection());
    }
    /**
     * Object: 养殖户结算利息 's 分录 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.FarmerSettlementOfInterestEditUIEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.FarmerSettlementOfInterestEditUIEntryCollection)get("entrys");
    }
    /**
     * Object:养殖户结算利息's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 养殖户结算利息 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("Company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("Company", item);
    }
    /**
     * Object: 养殖户结算利息 's 会计期间 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("Period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("Period", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("977B4810");
    }
}