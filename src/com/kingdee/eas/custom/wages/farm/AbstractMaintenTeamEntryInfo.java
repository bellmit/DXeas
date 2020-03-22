package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaintenTeamEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMaintenTeamEntryInfo()
    {
        this("id");
    }
    protected AbstractMaintenTeamEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.custom.wages.farm.MaintenTeamInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.farm.MaintenTeamInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.farm.MaintenTeamInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's Ա�� property 
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
     * Object:��¼'s ������ʱproperty 
     */
    public java.math.BigDecimal getTimenumber()
    {
        return getBigDecimal("timenumber");
    }
    public void setTimenumber(java.math.BigDecimal item)
    {
        setBigDecimal("timenumber", item);
    }
    /**
     * Object:��¼'s ������ʱ����property 
     */
    public java.math.BigDecimal getTimeamount()
    {
        return getBigDecimal("timeamount");
    }
    public void setTimeamount(java.math.BigDecimal item)
    {
        setBigDecimal("timeamount", item);
    }
    /**
     * Object:��¼'s ��˾��ʱproperty 
     */
    public java.math.BigDecimal getCompanytime()
    {
        return getBigDecimal("companytime");
    }
    public void setCompanytime(java.math.BigDecimal item)
    {
        setBigDecimal("companytime", item);
    }
    /**
     * Object:��¼'s ��˾��ʱ����property 
     */
    public java.math.BigDecimal getCompanyamount()
    {
        return getBigDecimal("companyamount");
    }
    public void setCompanyamount(java.math.BigDecimal item)
    {
        setBigDecimal("companyamount", item);
    }
    /**
     * Object:��¼'s �ܹ�ʱ����property 
     */
    public java.math.BigDecimal getSumwages()
    {
        return getBigDecimal("sumwages");
    }
    public void setSumwages(java.math.BigDecimal item)
    {
        setBigDecimal("sumwages", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("352F4CDB");
    }
}