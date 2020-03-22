package com.kingdee.eas.custom.shr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWincosForSHRInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractWincosForSHRInfo()
    {
        this("id");
    }
    protected AbstractWincosForSHRInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:SHR链接库设置's 数据库IP:property 
     */
    public String getDbIP()
    {
        return getString("dbIP");
    }
    public void setDbIP(String item)
    {
        setString("dbIP", item);
    }
    /**
     * Object:SHR链接库设置's 数据库端口号property 
     */
    public int getDbPort()
    {
        return getInt("dbPort");
    }
    public void setDbPort(int item)
    {
        setInt("dbPort", item);
    }
    /**
     * Object:SHR链接库设置's 用户名property 
     */
    public String getUserName()
    {
        return getString("userName");
    }
    public void setUserName(String item)
    {
        setString("userName", item);
    }
    /**
     * Object:SHR链接库设置's 密码property 
     */
    public String getPassword()
    {
        return getString("password");
    }
    public void setPassword(String item)
    {
        setString("password", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F4928315");
    }
}