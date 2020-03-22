package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCheckItemTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractCheckItemTreeInfo()
    {
        this("id");
    }
    protected AbstractCheckItemTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 评定项目组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.CheckItemTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.CheckItemTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.CheckItemTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2B3012C8");
    }
}