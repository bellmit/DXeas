package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedSeedPriceEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedSeedPriceEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedSeedPriceEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 药品成本物料分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BreedSeedPriceInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BreedSeedPriceInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.BreedSeedPriceInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 药品成本物料分录 's 物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:药品成本物料分录's 成本property 
     */
    public java.math.BigDecimal getCost()
    {
        return getBigDecimal("cost");
    }
    public void setCost(java.math.BigDecimal item)
    {
        setBigDecimal("cost", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EDDE5FAC");
    }
}