package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchAssessEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractHatchAssessEntryInfo()
    {
        this("id");
    }
    protected AbstractHatchAssessEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.wages.farm.HatchAssessInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.farm.HatchAssessInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.farm.HatchAssessInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 员工 property 
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
     * Object: 分录 's 岗位 property 
     */
    public com.kingdee.eas.basedata.org.PositionInfo getPosition()
    {
        return (com.kingdee.eas.basedata.org.PositionInfo)get("position");
    }
    public void setPosition(com.kingdee.eas.basedata.org.PositionInfo item)
    {
        put("position", item);
    }
    /**
     * Object:分录's 计件基数property 
     */
    public java.math.BigDecimal getJjjs()
    {
        return getBigDecimal("jjjs");
    }
    public void setJjjs(java.math.BigDecimal item)
    {
        setBigDecimal("jjjs", item);
    }
    /**
     * Object:分录's 班组人数property 
     */
    public java.math.BigDecimal getBzrs()
    {
        return getBigDecimal("bzrs");
    }
    public void setBzrs(java.math.BigDecimal item)
    {
        setBigDecimal("bzrs", item);
    }
    /**
     * Object:分录's 百计单位property 
     */
    public java.math.BigDecimal getBjdw()
    {
        return getBigDecimal("bjdw");
    }
    public void setBjdw(java.math.BigDecimal item)
    {
        setBigDecimal("bjdw", item);
    }
    /**
     * Object:分录's 比例系数property 
     */
    public String getBlsx()
    {
        return getString("blsx");
    }
    public void setBlsx(String item)
    {
        setString("blsx", item);
    }
    /**
     * Object:分录's 考核工资property 
     */
    public java.math.BigDecimal getAssesswages()
    {
        return getBigDecimal("assesswages");
    }
    public void setAssesswages(java.math.BigDecimal item)
    {
        setBigDecimal("assesswages", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("71E55B38");
    }
}