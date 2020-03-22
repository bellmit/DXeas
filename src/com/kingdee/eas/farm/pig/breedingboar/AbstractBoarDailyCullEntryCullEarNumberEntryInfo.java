package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBoarDailyCullEntryCullEarNumberEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBoarDailyCullEntryCullEarNumberEntryInfo()
    {
        this("id");
    }
    protected AbstractBoarDailyCullEntryCullEarNumberEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ÌÔÌ­¶ú±êÃ÷Ï¸ 's null property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyCullEntryInfo getParent1()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyCullEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.farm.pig.breedingboar.BoarDailyCullEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object:ÌÔÌ­¶ú±êÃ÷Ï¸'s ¶ú±êproperty 
     */
    public String getPigNumber()
    {
        return getString("pigNumber");
    }
    public void setPigNumber(String item)
    {
        setString("pigNumber", item);
    }
    /**
     * Object:ÌÔÌ­¶ú±êÃ÷Ï¸'s ±¸×¢property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("391AF906");
    }
}