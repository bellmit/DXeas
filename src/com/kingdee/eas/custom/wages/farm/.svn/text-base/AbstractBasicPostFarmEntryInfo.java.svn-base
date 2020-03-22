package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBasicPostFarmEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBasicPostFarmEntryInfo()
    {
        this("id");
    }
    protected AbstractBasicPostFarmEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 岗位人员 's null property 
     */
    public com.kingdee.eas.custom.wages.farm.BasicPostFarmInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.farm.BasicPostFarmInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.farm.BasicPostFarmInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 岗位人员 's 员工 property 
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
     * Object:岗位人员's 员工编码property 
     */
    public String getPersonnumber()
    {
        return getString("personnumber");
    }
    public void setPersonnumber(String item)
    {
        setString("personnumber", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D850FD38");
    }
}