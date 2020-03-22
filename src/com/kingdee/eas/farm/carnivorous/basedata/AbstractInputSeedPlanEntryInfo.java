package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInputSeedPlanEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractInputSeedPlanEntryInfo()
    {
        this("id");
    }
    protected AbstractInputSeedPlanEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.InputSeedPlanInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.InputSeedPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.InputSeedPlanInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 日期property 
     */
    public java.util.Date getDate()
    {
        return getDate("date");
    }
    public void setDate(java.util.Date item)
    {
        setDate("date", item);
    }
    /**
     * Object:分录's 数量(万只)property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("18D91CD0");
    }
}