package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCPigBreedModelFarmEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCCPigBreedModelFarmEntryInfo()
    {
        this("id");
    }
    protected AbstractCCPigBreedModelFarmEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 适用养殖场 's null property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 适用养殖场 's 养殖场 property 
     */
    public com.kingdee.eas.farm.pig.PigFarmInfo getFarmFactory()
    {
        return (com.kingdee.eas.farm.pig.PigFarmInfo)get("farmFactory");
    }
    public void setFarmFactory(com.kingdee.eas.farm.pig.PigFarmInfo item)
    {
        put("farmFactory", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("766A7BF9");
    }
}