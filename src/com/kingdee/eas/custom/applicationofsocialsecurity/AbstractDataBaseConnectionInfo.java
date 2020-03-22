package com.kingdee.eas.custom.applicationofsocialsecurity;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDataBaseConnectionInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDataBaseConnectionInfo()
    {
        this("id");
    }
    protected AbstractDataBaseConnectionInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:数据库连接设置's IP地址property 
     */
    public String getIP()
    {
        return getString("IP");
    }
    public void setIP(String item)
    {
        setString("IP", item);
    }
    /**
     * Object:数据库连接设置's 端口property 
     */
    public String getPort()
    {
        return getString("port");
    }
    public void setPort(String item)
    {
        setString("port", item);
    }
    /**
     * Object:数据库连接设置's 数据库名property 
     */
    public String getDataBaseName()
    {
        return getString("dataBaseName");
    }
    public void setDataBaseName(String item)
    {
        setString("dataBaseName", item);
    }
    /**
     * Object:数据库连接设置's 用户名property 
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
     * Object:数据库连接设置's 密码property 
     */
    public String getUserPassword()
    {
        return getString("userPassword");
    }
    public void setUserPassword(String item)
    {
        setString("userPassword", item);
    }
    /**
     * Object:数据库连接设置's 密码property 
     */
    public String getPassword()
    {
        return getString("password");
    }
    public void setPassword(String item)
    {
        setString("password", item);
    }
    /**
     * Object:数据库连接设置's 单据状态property 
     */
    public com.kingdee.eas.custom.applicationofsocialsecurity.billStatus getBillStatus()
    {
        return com.kingdee.eas.custom.applicationofsocialsecurity.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.applicationofsocialsecurity.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("38328C78");
    }
}