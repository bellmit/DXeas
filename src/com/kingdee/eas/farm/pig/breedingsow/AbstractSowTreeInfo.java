package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSowTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractSowTreeInfo()
    {
        this("id");
    }
    protected AbstractSowTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 种母猪档案组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.SowTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.SowTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingsow.SowTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("73273298");
    }
}