package com.kingdee.eas.farm.pig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPigFieldTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractPigFieldTreeInfo()
    {
        this("id");
    }
    protected AbstractPigFieldTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 栏位组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.pig.PigFieldTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.PigFieldTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.PigFieldTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C858A40A");
    }
}