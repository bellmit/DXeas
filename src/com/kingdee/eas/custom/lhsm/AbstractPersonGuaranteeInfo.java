package com.kingdee.eas.custom.lhsm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPersonGuaranteeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPersonGuaranteeInfo()
    {
        this("id");
    }
    protected AbstractPersonGuaranteeInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.lhsm.PersonGuaranteeEntryCollection());
    }
    /**
     * Object: 担保人员资料 's 分录 property 
     */
    public com.kingdee.eas.custom.lhsm.PersonGuaranteeEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.lhsm.PersonGuaranteeEntryCollection)get("Entry");
    }
    /**
     * Object: 担保人员资料 's 公司 property 
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
        return new BOSObjectType("3B72EBA6");
    }
}