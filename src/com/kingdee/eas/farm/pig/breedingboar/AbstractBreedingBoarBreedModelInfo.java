package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedingBoarBreedModelInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBreedingBoarBreedModelInfo()
    {
        this("id");
    }
    protected AbstractBreedingBoarBreedModelInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.pig.breedingboar.BreedingBoarBreedModelEntryCollection());
    }
    /**
     * Object: 种公猪养殖规范 's 分录 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BreedingBoarBreedModelEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BreedingBoarBreedModelEntryCollection)get("entrys");
    }
    /**
     * Object:种公猪养殖规范's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 种公猪养殖规范 's 养殖场 property 
     */
    public com.kingdee.eas.farm.pig.PigFarmInfo getPigFarm()
    {
        return (com.kingdee.eas.farm.pig.PigFarmInfo)get("pigFarm");
    }
    public void setPigFarm(com.kingdee.eas.farm.pig.PigFarmInfo item)
    {
        put("pigFarm", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1DDF403D");
    }
}