package com.kingdee.eas.custom.shr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMyTestInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractMyTestInfo()
    {
        this("id");
    }
    protected AbstractMyTestInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.shr.MyTestEntryCollection());
    }
    /**
     * Object:测试's 是否生成凭证property 
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
     * Object: 测试 's 第1个表体 property 
     */
    public com.kingdee.eas.custom.shr.MyTestEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.shr.MyTestEntryCollection)get("Entry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8B4D60B4");
    }
}