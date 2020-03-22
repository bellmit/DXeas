package com.kingdee.eas.publicdata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDatabaseSettingTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractDatabaseSettingTreeInfo()
    {
        this("id");
    }
    protected AbstractDatabaseSettingTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 数据库连接设置组别 's 父节点 property 
     */
    public com.kingdee.eas.publicdata.DatabaseSettingTreeInfo getParent()
    {
        return (com.kingdee.eas.publicdata.DatabaseSettingTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.publicdata.DatabaseSettingTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("850BD0D0");
    }
}