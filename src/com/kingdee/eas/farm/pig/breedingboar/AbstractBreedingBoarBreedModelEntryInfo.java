package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedingBoarBreedModelEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedingBoarBreedModelEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedingBoarBreedModelEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BreedingBoarBreedModelInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BreedingBoarBreedModelInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingboar.BreedingBoarBreedModelInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("57C07635");
    }
}