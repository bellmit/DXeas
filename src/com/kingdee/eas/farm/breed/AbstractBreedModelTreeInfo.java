package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedModelTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractBreedModelTreeInfo()
    {
        this("id");
    }
    protected AbstractBreedModelTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��ι�淶��� 's ���ڵ� property 
     */
    public com.kingdee.eas.farm.breed.BreedModelTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.BreedModelTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.BreedModelTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2B40E32D");
    }
}