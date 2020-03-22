package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractParentBreedBatchEntryFieldDetailEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractParentBreedBatchEntryFieldDetailEntryInfo()
    {
        this("id");
    }
    protected AbstractParentBreedBatchEntryFieldDetailEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 入栏明细 's null property 
     */
    public com.kingdee.eas.farm.breed.ParentBreedBatchEntryInfo getParent1()
    {
        return (com.kingdee.eas.farm.breed.ParentBreedBatchEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.farm.breed.ParentBreedBatchEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object: 入栏明细 's 栏位 property 
     */
    public com.kingdee.eas.farm.breed.HouseFieldInfo getHousefield()
    {
        return (com.kingdee.eas.farm.breed.HouseFieldInfo)get("housefield");
    }
    public void setHousefield(com.kingdee.eas.farm.breed.HouseFieldInfo item)
    {
        put("housefield", item);
    }
    /**
     * Object:入栏明细's 入栏量（♀）property 
     */
    public int getHenInitQty()
    {
        return getInt("henInitQty");
    }
    public void setHenInitQty(int item)
    {
        setInt("henInitQty", item);
    }
    /**
     * Object:入栏明细's 入栏量（♂）property 
     */
    public int getCockInitQty()
    {
        return getInt("cockInitQty");
    }
    public void setCockInitQty(int item)
    {
        setInt("cockInitQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1B7FB82F");
    }
}