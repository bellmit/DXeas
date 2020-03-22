package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedSeedCostEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedSeedCostEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedSeedCostEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 药品成本物料分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BreedSeedCostInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BreedSeedCostInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.BreedSeedCostInfo item)
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
        return new BOSObjectType("0142C142");
    }
}