package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedStandardTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractBreedStandardTreeInfo()
    {
        this("id");
    }
    protected AbstractBreedStandardTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖规范组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedStandardTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedStandardTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.BreedStandardTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FA29705E");
    }
}