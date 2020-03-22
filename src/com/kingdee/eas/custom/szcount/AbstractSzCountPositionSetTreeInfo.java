package com.kingdee.eas.custom.szcount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSzCountPositionSetTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractSzCountPositionSetTreeInfo()
    {
        this("id");
    }
    protected AbstractSzCountPositionSetTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 双增计数岗位组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.szcount.SzCountPositionSetTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.szcount.SzCountPositionSetTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.szcount.SzCountPositionSetTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A1D124DA");
    }
}