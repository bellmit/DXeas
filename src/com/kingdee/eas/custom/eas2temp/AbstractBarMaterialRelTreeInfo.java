package com.kingdee.eas.custom.eas2temp;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBarMaterialRelTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractBarMaterialRelTreeInfo()
    {
        this("id");
    }
    protected AbstractBarMaterialRelTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: BarMaterialRel组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.eas2temp.BarMaterialRelTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.eas2temp.BarMaterialRelTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.eas2temp.BarMaterialRelTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E8F4CCF1");
    }
}