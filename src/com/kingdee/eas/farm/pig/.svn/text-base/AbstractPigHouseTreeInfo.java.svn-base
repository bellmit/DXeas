package com.kingdee.eas.farm.pig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPigHouseTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractPigHouseTreeInfo()
    {
        this("id");
    }
    protected AbstractPigHouseTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 猪舍组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.pig.PigHouseTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.PigHouseTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.PigHouseTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BA8C4730");
    }
}