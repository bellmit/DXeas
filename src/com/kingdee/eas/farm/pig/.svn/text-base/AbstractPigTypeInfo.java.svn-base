package com.kingdee.eas.farm.pig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPigTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPigTypeInfo()
    {
        this("id");
    }
    protected AbstractPigTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 品种 's 组别 property 
     */
    public com.kingdee.eas.farm.pig.PigTypeTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.pig.PigTypeTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.pig.PigTypeTreeInfo item)
    {
        put("treeid", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FFFFFBA8");
    }
}