package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAreaSetInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractAreaSetInfo()
    {
        this("id");
    }
    protected AbstractAreaSetInfo(String pkField)
    {
        super(pkField);
        put("SalerEntry", new com.kingdee.eas.custom.salepayment.AreaSetSalerEntryCollection());
    }
    /**
     * Object: �������� 's �������� property 
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
     * Object:��������'s ��������property 
     */
    public String getArea()
    {
        return getString("area");
    }
    public void setArea(String item)
    {
        setString("area", item);
    }
    /**
     * Object: �������� 's ����Ա��ϸ property 
     */
    public com.kingdee.eas.custom.salepayment.AreaSetSalerEntryCollection getSalerEntry()
    {
        return (com.kingdee.eas.custom.salepayment.AreaSetSalerEntryCollection)get("SalerEntry");
    }
    /**
     * Object: �������� 's ��˾ property 
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
        return new BOSObjectType("2C5E4321");
    }
}