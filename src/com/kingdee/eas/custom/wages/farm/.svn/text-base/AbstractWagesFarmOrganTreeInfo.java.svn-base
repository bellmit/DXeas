package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWagesFarmOrganTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractWagesFarmOrganTreeInfo()
    {
        this("id");
    }
    protected AbstractWagesFarmOrganTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖组织架构组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.wages.farm.WagesFarmOrganTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.farm.WagesFarmOrganTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.farm.WagesFarmOrganTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E05814D8");
    }
}