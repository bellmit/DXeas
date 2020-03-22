package com.kingdee.eas.farm.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmCodeTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractFarmCodeTreeInfo()
    {
        this("id");
    }
    protected AbstractFarmCodeTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖场编号组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.foodtrac.FarmCodeTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.foodtrac.FarmCodeTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.foodtrac.FarmCodeTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6F0B6C8B");
    }
}