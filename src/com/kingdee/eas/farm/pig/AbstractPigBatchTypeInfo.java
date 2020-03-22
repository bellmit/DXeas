package com.kingdee.eas.farm.pig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPigBatchTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPigBatchTypeInfo()
    {
        this("id");
    }
    protected AbstractPigBatchTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 猪群分类 's 组别 property 
     */
    public com.kingdee.eas.farm.pig.PigBatchTypeTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.pig.PigBatchTypeTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.pig.PigBatchTypeTreeInfo item)
    {
        put("treeid", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4297D5E6");
    }
}