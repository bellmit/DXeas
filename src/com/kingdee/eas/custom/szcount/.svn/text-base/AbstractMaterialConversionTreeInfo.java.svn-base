package com.kingdee.eas.custom.szcount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaterialConversionTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractMaterialConversionTreeInfo()
    {
        this("id");
    }
    protected AbstractMaterialConversionTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 物料换算组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.szcount.MaterialConversionTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.szcount.MaterialConversionTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.szcount.MaterialConversionTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("15DF7606");
    }
}