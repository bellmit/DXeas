package com.kingdee.eas.farm.pig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPigFarmTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractPigFarmTreeInfo()
    {
        this("id");
    }
    protected AbstractPigFarmTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养猪场组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.pig.PigFarmTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.PigFarmTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.PigFarmTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("22E63A62");
    }
}