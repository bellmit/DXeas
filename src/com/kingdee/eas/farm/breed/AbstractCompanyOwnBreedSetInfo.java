package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCompanyOwnBreedSetInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCompanyOwnBreedSetInfo()
    {
        this("id");
    }
    protected AbstractCompanyOwnBreedSetInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 自养基础设置 's 公司 property 
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
        return new BOSObjectType("FFA6F611");
    }
}