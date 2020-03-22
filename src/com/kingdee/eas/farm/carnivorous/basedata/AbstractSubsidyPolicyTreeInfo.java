package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSubsidyPolicyTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractSubsidyPolicyTreeInfo()
    {
        this("id");
    }
    protected AbstractSubsidyPolicyTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 补贴政策组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SubsidyPolicyTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SubsidyPolicyTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.SubsidyPolicyTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("45C7C899");
    }
}