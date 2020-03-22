package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmersTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractFarmersTreeInfo()
    {
        this("id");
    }
    protected AbstractFarmersTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖户组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo item)
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
        return new BOSObjectType("BFB8653D");
    }
}