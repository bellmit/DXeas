package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTechnicianInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractTechnicianInfo()
    {
        this("id");
    }
    protected AbstractTechnicianInfo(String pkField)
    {
        super(pkField);
        put("CustomerEntry", new com.kingdee.eas.custom.salepayment.TechnicianCustomerEntryCollection());
    }
    /**
     * Object: 技术员 's 负责客户 property 
     */
    public com.kingdee.eas.custom.salepayment.TechnicianCustomerEntryCollection getCustomerEntry()
    {
        return (com.kingdee.eas.custom.salepayment.TechnicianCustomerEntryCollection)get("CustomerEntry");
    }
    /**
     * Object: 技术员 's 职员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object: 技术员 's 公司 property 
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
        return new BOSObjectType("982DF758");
    }
}