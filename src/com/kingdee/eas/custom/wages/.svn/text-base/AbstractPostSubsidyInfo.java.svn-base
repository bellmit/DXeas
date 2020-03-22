package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPostSubsidyInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractPostSubsidyInfo()
    {
        this("id");
    }
    protected AbstractPostSubsidyInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.wages.PostSubsidyEntryCollection());
    }
    /**
     * Object:岗位补助's 是否生成凭证property 
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
     * Object: 岗位补助 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object: 岗位补助 's 岗位补助分录 property 
     */
    public com.kingdee.eas.custom.wages.PostSubsidyEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.wages.PostSubsidyEntryCollection)get("Entry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("52F0D5E3");
    }
}