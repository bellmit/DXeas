package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractYieldDataBaseTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractYieldDataBaseTreeInfo()
    {
        this("id");
    }
    protected AbstractYieldDataBaseTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 出成率设置组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("89E016A4");
    }
}