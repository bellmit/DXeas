package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPersonFarmerRelationTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractPersonFarmerRelationTreeInfo()
    {
        this("id");
    }
    protected AbstractPersonFarmerRelationTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 业务员养户范围组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8A12EF43");
    }
}