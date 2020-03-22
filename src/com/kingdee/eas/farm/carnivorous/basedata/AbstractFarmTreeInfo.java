package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractFarmTreeInfo()
    {
        this("id");
    }
    protected AbstractFarmTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖场组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.FarmTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A1610496");
    }
}