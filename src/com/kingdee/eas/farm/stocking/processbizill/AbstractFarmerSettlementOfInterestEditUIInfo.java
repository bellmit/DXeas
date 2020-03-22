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
     * Object: ��ֳ��������Ϣ 's ��¼ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.FarmerSettlementOfInterestEditUIEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.FarmerSettlementOfInterestEditUIEntryCollection)get("entrys");
    }
    /**
     * Object:��ֳ��������Ϣ's �Ƿ�����ƾ֤property 
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
     * Object: ��ֳ��������Ϣ 's ��˾ property 
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
     * Object: ��ֳ��������Ϣ 's ����ڼ� property 
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