package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWageOrganizationTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractWageOrganizationTreeInfo()
    {
        this("id");
    }
    protected AbstractWageOrganizationTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 工资系统组织架构组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.wages.WageOrganizationTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.WageOrganizationTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.WageOrganizationTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A22190C1");
    }
}