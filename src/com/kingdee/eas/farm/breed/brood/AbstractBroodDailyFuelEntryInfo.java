package com.kingdee.eas.farm.breed.brood;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBroodDailyFuelEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBroodDailyFuelEntryInfo()
    {
        this("id");
    }
    protected AbstractBroodDailyFuelEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 燃料信息 's null property 
     */
    public com.kingdee.eas.farm.breed.brood.BroodDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.brood.BroodDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.brood.BroodDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:燃料信息's 耗煤量property 
     */
    public java.math.BigDecimal getCoalQuantity()
    {
        return getBigDecimal("coalQuantity");
    }
    public void setCoalQuantity(java.math.BigDecimal item)
    {
        setBigDecimal("coalQuantity", item);
    }
    /**
     * Object: 燃料信息 's 鸡舍 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("warehouse");
    }
    public void setWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("warehouse", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F5E0B203");
    }
}