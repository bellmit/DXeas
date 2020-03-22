package com.kingdee.eas.farm.pig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStrainTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractStrainTreeInfo()
    {
        this("id");
    }
    protected AbstractStrainTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 品系组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.pig.StrainTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.StrainTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.StrainTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("44C1D0F3");
    }
}