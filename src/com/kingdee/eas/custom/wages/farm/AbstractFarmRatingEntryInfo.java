package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmRatingEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFarmRatingEntryInfo()
    {
        this("id");
    }
    protected AbstractFarmRatingEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.wages.farm.FarmRatingInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.farm.FarmRatingInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.farm.FarmRatingInfo item)
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
     * Object:分录's 工龄工资property 
     */
    public java.math.BigDecimal getRzhpbkh()
    {
        return getBigDecimal("rzhpbkh");
    }
    public void setRzhpbkh(java.math.BigDecimal item)
    {
        setBigDecimal("rzhpbkh", item);
    }
    /**
     * Object:分录's 日综合评比考核扣款property 
     */
    public java.math.BigDecimal getRzhpbkhkk()
    {
        return getBigDecimal("rzhpbkhkk");
    }
    public void setRzhpbkhkk(java.math.BigDecimal item)
    {
        setBigDecimal("rzhpbkhkk", item);
    }
    /**
     * Object:分录's 代扣意外险property 
     */
    public java.math.BigDecimal getDkywx()
    {
        return getBigDecimal("dkywx");
    }
    public void setDkywx(java.math.BigDecimal item)
    {
        setBigDecimal("dkywx", item);
    }
    /**
     * Object:分录's 罚款property 
     */
    public java.math.BigDecimal getFk()
    {
        return getBigDecimal("fk");
    }
    public void setFk(java.math.BigDecimal item)
    {
        setBigDecimal("fk", item);
    }
    /**
     * Object:分录's 月补助property 
     */
    public java.math.BigDecimal getMonthsub()
    {
        return getBigDecimal("monthsub");
    }
    public void setMonthsub(java.math.BigDecimal item)
    {
        setBigDecimal("monthsub", item);
    }
    /**
     * Object:分录's 年补助property 
     */
    public java.math.BigDecimal getYearsub()
    {
        return getBigDecimal("yearsub");
    }
    public void setYearsub(java.math.BigDecimal item)
    {
        setBigDecimal("yearsub", item);
    }
    /**
     * Object:分录's 批次奖励property 
     */
    public java.math.BigDecimal getBatchWage()
    {
        return getBigDecimal("BatchWage");
    }
    public void setBatchWage(java.math.BigDecimal item)
    {
        setBigDecimal("BatchWage", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E9104955");
    }
}