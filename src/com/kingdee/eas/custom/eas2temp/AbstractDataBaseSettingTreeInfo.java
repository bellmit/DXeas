package com.kingdee.eas.custom.eas2temp;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDataBaseSettingTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractDataBaseSettingTreeInfo()
    {
        this("id");
    }
    protected AbstractDataBaseSettingTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 中间库连接设置组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.eas2temp.DataBaseSettingTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.eas2temp.DataBaseSettingTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.eas2temp.DataBaseSettingTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5F5A871F");
    }
}