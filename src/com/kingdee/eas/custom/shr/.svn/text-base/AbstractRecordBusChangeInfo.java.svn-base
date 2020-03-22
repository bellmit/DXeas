package com.kingdee.eas.custom.shr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRecordBusChangeInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractRecordBusChangeInfo()
    {
        this("id");
    }
    protected AbstractRecordBusChangeInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.shr.RecordBusChangeEntryCollection());
    }
    /**
     * Object: 车次更改记录 's 分录 property 
     */
    public com.kingdee.eas.custom.shr.RecordBusChangeEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.shr.RecordBusChangeEntryCollection)get("entrys");
    }
    /**
     * Object:车次更改记录's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A1B04D69");
    }
}