package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMiddlemanFeeBillInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractMiddlemanFeeBillInfo()
    {
        this("id");
    }
    protected AbstractMiddlemanFeeBillInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.wages.MiddlemanFeeBillEntryCollection());
    }
    /**
     * Object:介绍费's 是否生成凭证property 
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
     * Object: 介绍费 's 介绍费分录 property 
     */
    public com.kingdee.eas.custom.wages.MiddlemanFeeBillEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.wages.MiddlemanFeeBillEntryCollection)get("Entry");
    }
    /**
     * Object: 介绍费 's 公司 property 
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
        return new BOSObjectType("56FDF950");
    }
}