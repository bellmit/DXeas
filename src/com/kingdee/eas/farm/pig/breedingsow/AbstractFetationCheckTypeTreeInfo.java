package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFetationCheckTypeTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractFetationCheckTypeTreeInfo()
    {
        this("id");
    }
    protected AbstractFetationCheckTypeTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 妊检方式组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.FetationCheckTypeTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.FetationCheckTypeTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingsow.FetationCheckTypeTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C8F77EFF");
    }
}