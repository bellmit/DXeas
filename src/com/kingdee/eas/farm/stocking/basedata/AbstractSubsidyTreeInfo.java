package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSubsidyTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractSubsidyTreeInfo()
    {
        this("id");
    }
    protected AbstractSubsidyTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 补贴组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SubsidyTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.SubsidyTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.SubsidyTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4C1C0DF8");
    }
}