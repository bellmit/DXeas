package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractFarmerTreeInfo()
    {
        this("id");
    }
    protected AbstractFarmerTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖户组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 养殖户组别 's 成本对象组 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectSuiteInfo getCostObjectSuite()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectSuiteInfo)get("costObjectSuite");
    }
    public void setCostObjectSuite(com.kingdee.eas.basedata.assistant.CostObjectSuiteInfo item)
    {
        put("costObjectSuite", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EA2D1CC3");
    }
}