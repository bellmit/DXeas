package com.kingdee.eas.custom.lhsm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPersonGuaranteeEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPersonGuaranteeEntryInfo()
    {
        this("id");
    }
    protected AbstractPersonGuaranteeEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's null property 
     */
    public com.kingdee.eas.custom.lhsm.PersonGuaranteeInfo getParent()
    {
        return (com.kingdee.eas.custom.lhsm.PersonGuaranteeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.lhsm.PersonGuaranteeInfo item)
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
     * Object:分录's 身份证号码property 
     */
    public String getIDCard()
    {
        return getString("IDCard");
    }
    public void setIDCard(String item)
    {
        setString("IDCard", item);
    }
    /**
     * Object:分录's 总额度property 
     */
    public java.math.BigDecimal getTopQuota()
    {
        return getBigDecimal("topQuota");
    }
    public void setTopQuota(java.math.BigDecimal item)
    {
        setBigDecimal("topQuota", item);
    }
    /**
     * Object:分录's 当前剩余额度property 
     */
    public java.math.BigDecimal getCurrentQuota()
    {
        return getBigDecimal("currentQuota");
    }
    public void setCurrentQuota(java.math.BigDecimal item)
    {
        setBigDecimal("currentQuota", item);
    }
    /**
     * Object:分录's 已使用额度property 
     */
    public java.math.BigDecimal getUsedQuota()
    {
        return getBigDecimal("usedQuota");
    }
    public void setUsedQuota(java.math.BigDecimal item)
    {
        setBigDecimal("usedQuota", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3DEC846C");
    }
}