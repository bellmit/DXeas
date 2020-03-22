package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractVarietieInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractVarietieInfo()
    {
        this("id");
    }
    protected AbstractVarietieInfo(String pkField)
    {
        super(pkField);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D136E687");
    }
}