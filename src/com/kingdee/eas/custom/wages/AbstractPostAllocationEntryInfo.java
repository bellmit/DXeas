package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPostAllocationEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPostAllocationEntryInfo()
    {
        this("id");
    }
    protected AbstractPostAllocationEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.wages.PostAllocationInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.PostAllocationInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.PostAllocationInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 员工名称 property 
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
     * Object:分录's 员工编号property 
     */
    public String getPersonnumber()
    {
        return getString("personnumber");
    }
    public void setPersonnumber(String item)
    {
        setString("personnumber", item);
    }
    /**
     * Object: 分录 's 来源调拨岗位 property 
     */
    public com.kingdee.eas.custom.wages.BasicPostInfo getFromgroup()
    {
        return (com.kingdee.eas.custom.wages.BasicPostInfo)get("fromgroup");
    }
    public void setFromgroup(com.kingdee.eas.custom.wages.BasicPostInfo item)
    {
        put("fromgroup", item);
    }
    /**
     * Object: 分录 's 调拨岗位 property 
     */
    public com.kingdee.eas.custom.wages.BasicPostInfo getTogroup()
    {
        return (com.kingdee.eas.custom.wages.BasicPostInfo)get("togroup");
    }
    public void setTogroup(com.kingdee.eas.custom.wages.BasicPostInfo item)
    {
        put("togroup", item);
    }
    /**
     * Object:分录's 调拨理由property 
     */
    public String getRemarks()
    {
        return getString("remarks");
    }
    public void setRemarks(String item)
    {
        setString("remarks", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C76DF5AA");
    }
}