package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggConveyorTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractEggConveyorTreeInfo()
    {
        this("id");
    }
    protected AbstractEggConveyorTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 鸡蛋传送带组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.breed.layegg.EggConveyorTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.layegg.EggConveyorTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.layegg.EggConveyorTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D808B981");
    }
}