package com.kingdee.eas.custom.mobileRPT;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRPTRoleRoleEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractRPTRoleRoleEntryInfo()
    {
        this("id");
    }
    protected AbstractRPTRoleRoleEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 权限分录 's null property 
     */
    public com.kingdee.eas.custom.mobileRPT.RPTRoleInfo getParent()
    {
        return (com.kingdee.eas.custom.mobileRPT.RPTRoleInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.mobileRPT.RPTRoleInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 权限分录 's 角色 property 
     */
    public com.kingdee.eas.base.permission.RoleInfo getRole()
    {
        return (com.kingdee.eas.base.permission.RoleInfo)get("role");
    }
    public void setRole(com.kingdee.eas.base.permission.RoleInfo item)
    {
        put("role", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DE30B56F");
    }
}