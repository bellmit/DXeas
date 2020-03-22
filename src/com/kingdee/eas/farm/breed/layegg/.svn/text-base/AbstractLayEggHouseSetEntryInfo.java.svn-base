package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLayEggHouseSetEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLayEggHouseSetEntryInfo()
    {
        this("id");
    }
    protected AbstractLayEggHouseSetEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggHouseSetInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggHouseSetInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.layegg.LayEggHouseSetInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 母鸡料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getHenMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("henMaterial");
    }
    public void setHenMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("henMaterial", item);
    }
    /**
     * Object: 分录 's 公鸡料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getCockMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("cockMaterial");
    }
    public void setCockMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("cockMaterial", item);
    }
    /**
     * Object:分录's 日默认投料量property 
     */
    public java.math.BigDecimal getHenDefaultQty()
    {
        return getBigDecimal("henDefaultQty");
    }
    public void setHenDefaultQty(java.math.BigDecimal item)
    {
        setBigDecimal("henDefaultQty", item);
    }
    /**
     * Object:分录's 日默认投料量property 
     */
    public java.math.BigDecimal getCockDefaultQty()
    {
        return getBigDecimal("cockDefaultQty");
    }
    public void setCockDefaultQty(java.math.BigDecimal item)
    {
        setBigDecimal("cockDefaultQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A97AE882");
    }
}