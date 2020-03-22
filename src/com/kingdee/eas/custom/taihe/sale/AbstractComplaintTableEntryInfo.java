package com.kingdee.eas.custom.taihe.sale;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractComplaintTableEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractComplaintTableEntryInfo()
    {
        this("id");
    }
    protected AbstractComplaintTableEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.taihe.sale.ComplaintTableInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.sale.ComplaintTableInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.sale.ComplaintTableInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 跟进日期property 
     */
    public java.util.Date getDealDate()
    {
        return getDate("dealDate");
    }
    public void setDealDate(java.util.Date item)
    {
        setDate("dealDate", item);
    }
    /**
     * Object:分录's 跟进人property 
     */
    public String getDealer()
    {
        return getString("dealer");
    }
    public void setDealer(String item)
    {
        setString("dealer", item);
    }
    /**
     * Object: 分录 's 跟进员工 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getDealerPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("dealerPerson");
    }
    public void setDealerPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("dealerPerson", item);
    }
    /**
     * Object: 分录 's 责任部门 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getDepartment()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("department");
    }
    public void setDepartment(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("department", item);
    }
    /**
     * Object: 分录 's 责任人 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPersonLiable()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("personLiable");
    }
    public void setPersonLiable(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("personLiable", item);
    }
    /**
     * Object:分录's 处理结果property 
     */
    public String getResult()
    {
        return getString("result");
    }
    public void setResult(String item)
    {
        setString("result", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EB0AF668");
    }
}