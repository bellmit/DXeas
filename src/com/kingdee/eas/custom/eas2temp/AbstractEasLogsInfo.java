package com.kingdee.eas.custom.eas2temp;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEasLogsInfo extends AbstractObjectValue implements Serializable 
{
    public AbstractEasLogsInfo()
    {
        this("id");
    }
    protected AbstractEasLogsInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:ÖÐ¿Ø¼ÇÂ¼'s nullproperty 
     */
    public com.kingdee.bos.util.BOSUuid getId()
    {
        return getBOSUuid("id");
    }
    public void setId(com.kingdee.bos.util.BOSUuid item)
    {
        setBOSUuid("id", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("45007552");
    }
}