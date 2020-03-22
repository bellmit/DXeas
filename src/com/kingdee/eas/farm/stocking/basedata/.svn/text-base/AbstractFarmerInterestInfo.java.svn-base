package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerInterestInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFarmerInterestInfo()
    {
        this("id");
    }
    protected AbstractFarmerInterestInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.stocking.basedata.FarmerInterestEntryCollection());
    }
    /**
     * Object: 养殖户利息 's 期间 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    /**
     * Object: 养殖户利息 's 养殖户利息分录 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmerInterestEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmerInterestEntryCollection)get("Entry");
    }
    /**
     * Object:养殖户利息's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object: 养殖户利息 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0B2F013E");
    }
}