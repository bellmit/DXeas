package com.kingdee.eas.custom.taihe.settle;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarcassDisrateTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractCarcassDisrateTreeInfo()
    {
        this("id");
    }
    protected AbstractCarcassDisrateTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 胴体出成折算标准组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.taihe.settle.CarcassDisrateTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.settle.CarcassDisrateTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.settle.CarcassDisrateTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7CA34B3D");
    }
}