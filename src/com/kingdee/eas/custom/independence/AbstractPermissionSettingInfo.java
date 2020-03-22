package com.kingdee.eas.custom.independence;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPermissionSettingInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPermissionSettingInfo()
    {
        this("id");
    }
    protected AbstractPermissionSettingInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 权限控制 's 组别 property 
     */
    public com.kingdee.eas.custom.independence.PermissionSettingTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.independence.PermissionSettingTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.independence.PermissionSettingTreeInfo item)
    {
        put("treeid", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("69804A7A");
    }
}