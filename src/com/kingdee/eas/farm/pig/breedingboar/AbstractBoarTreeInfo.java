package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBoarTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractBoarTreeInfo()
    {
        this("id");
    }
    protected AbstractBoarTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 种公猪档案组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingboar.BoarTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F2D483B8");
    }
}