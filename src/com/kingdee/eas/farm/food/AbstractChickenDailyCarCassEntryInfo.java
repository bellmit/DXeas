package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractChickenDailyCarCassEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractChickenDailyCarCassEntryInfo()
    {
        this("id");
    }
    protected AbstractChickenDailyCarCassEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 胴体分布 's null property 
     */
    public com.kingdee.eas.farm.food.ChickenDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.food.ChickenDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.food.ChickenDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:胴体分布's 重量property 
     */
    public String getWeight()
    {
        return getString("weight");
    }
    public void setWeight(String item)
    {
        setString("weight", item);
    }
    /**
     * Object:胴体分布's 比例（%）property 
     */
    public java.math.BigDecimal getProportion()
    {
        return getBigDecimal("proportion");
    }
    public void setProportion(java.math.BigDecimal item)
    {
        setBigDecimal("proportion", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C3B2088E");
    }
}