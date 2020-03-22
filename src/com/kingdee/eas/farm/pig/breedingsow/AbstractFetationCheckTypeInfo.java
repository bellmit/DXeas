package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFetationCheckTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFetationCheckTypeInfo()
    {
        this("id");
    }
    protected AbstractFetationCheckTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 妊检方式 's 组别 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.FetationCheckTypeTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.FetationCheckTypeTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.pig.breedingsow.FetationCheckTypeTreeInfo item)
    {
        put("treeid", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D6F75FC1");
    }
}