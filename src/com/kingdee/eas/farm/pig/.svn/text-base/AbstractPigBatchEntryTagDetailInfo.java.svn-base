package com.kingdee.eas.farm.pig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPigBatchEntryTagDetailInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPigBatchEntryTagDetailInfo()
    {
        this("id");
    }
    protected AbstractPigBatchEntryTagDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 耳标明细 's null property 
     */
    public com.kingdee.eas.farm.pig.PigBatchEntryInfo getParent1()
    {
        return (com.kingdee.eas.farm.pig.PigBatchEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.farm.pig.PigBatchEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object:耳标明细's 耳标property 
     */
    public String getTag()
    {
        return getString("tag");
    }
    public void setTag(String item)
    {
        setString("tag", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AEBB7FE5");
    }
}