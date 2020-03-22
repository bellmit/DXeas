package com.kingdee.eas.custom.runkanban;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractKanbanAuthroityInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractKanbanAuthroityInfo()
    {
        this("id");
    }
    protected AbstractKanbanAuthroityInfo(String pkField)
    {
        super(pkField);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("11519DE1");
    }
}