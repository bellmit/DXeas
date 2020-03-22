package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLayEggDailyEntryEntryFieldEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLayEggDailyEntryEntryFieldEntryInfo()
    {
        this("id");
    }
    protected AbstractLayEggDailyEntryEntryFieldEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 栏位饲喂明细 's null property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggDailyEntryInfo getParent1()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggDailyEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.farm.breed.layegg.LayEggDailyEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object: 栏位饲喂明细 's 栏位 property 
     */
    public com.kingdee.eas.farm.breed.HouseFieldInfo getField()
    {
        return (com.kingdee.eas.farm.breed.HouseFieldInfo)get("field");
    }
    public void setField(com.kingdee.eas.farm.breed.HouseFieldInfo item)
    {
        put("field", item);
    }
    /**
     * Object:栏位饲喂明细's 母禽料量（KG）property 
     */
    public java.math.BigDecimal getHenQty()
    {
        return getBigDecimal("henQty");
    }
    public void setHenQty(java.math.BigDecimal item)
    {
        setBigDecimal("henQty", item);
    }
    /**
     * Object:栏位饲喂明细's 公禽料量（KG）property 
     */
    public java.math.BigDecimal getCockQty()
    {
        return getBigDecimal("cockQty");
    }
    public void setCockQty(java.math.BigDecimal item)
    {
        setBigDecimal("cockQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3EF593A3");
    }
}