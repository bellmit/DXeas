package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractQuitWagesBillInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractQuitWagesBillInfo()
    {
        this("id");
    }
    protected AbstractQuitWagesBillInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.wages.QuitWagesBillEntryCollection());
    }
    /**
     * Object: 离职工资处理 's 公司 property 
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
     * Object: 离职工资处理 's 离职工资分录 property 
     */
    public com.kingdee.eas.custom.wages.QuitWagesBillEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.wages.QuitWagesBillEntryCollection)get("Entry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CA63A65B");
    }
}