package com.kingdee.eas.custom.independence;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPermissionSettingTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractPermissionSettingTreeInfo()
    {
        this("id");
    }
    protected AbstractPermissionSettingTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 权限控制组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.independence.PermissionSettingTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.independence.PermissionSettingTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.independence.PermissionSettingTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C32A6538");
    }
}