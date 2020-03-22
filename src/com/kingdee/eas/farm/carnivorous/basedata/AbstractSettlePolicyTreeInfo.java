package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettlePolicyTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractSettlePolicyTreeInfo()
    {
        this("id");
    }
    protected AbstractSettlePolicyTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 结算政策组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E63B3D3D");
    }
}