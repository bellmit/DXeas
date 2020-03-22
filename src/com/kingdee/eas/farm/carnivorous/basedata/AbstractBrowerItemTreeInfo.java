package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBrowerItemTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractBrowerItemTreeInfo()
    {
        this("id");
    }
    protected AbstractBrowerItemTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 借款项目组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BrowerItemTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BrowerItemTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.BrowerItemTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9DC98378");
    }
}