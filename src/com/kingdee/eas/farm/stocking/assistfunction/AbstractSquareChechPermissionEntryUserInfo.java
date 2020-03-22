package com.kingdee.eas.farm.stocking.assistfunction;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSquareChechPermissionEntryUserInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSquareChechPermissionEntryUserInfo()
    {
        this("id");
    }
    protected AbstractSquareChechPermissionEntryUserInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 用户分录 's null property 
     */
    public com.kingdee.eas.farm.stocking.assistfunction.SquareChechPermissionInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.SquareChechPermissionInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.assistfunction.SquareChechPermissionInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 用户分录 's 用户 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getUser()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("user");
    }
    public void setUser(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("user", item);
    }
    /**
     * Object:用户分录's 用户实名property 
     */
    public String getUserName()
    {
        return getString("userName");
    }
    public void setUserName(String item)
    {
        setString("userName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7A2EDD11");
    }
}