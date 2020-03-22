package com.kingdee.eas.custom.salaryvoucher;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractConnectServerInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractConnectServerInfo()
    {
        this("id");
    }
    protected AbstractConnectServerInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:外部服务器连接's IP地址property 
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
     * Object:外部服务器连接's 端口property 
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
     * Object:外部服务器连接's 数据库名property 
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
     * Object:外部服务器连接's 用户名property 
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
     * Object:外部服务器连接's 密码property 
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
     * Object:外部服务器连接's 状态property 
     */
    public com.kingdee.eas.custom.salaryvoucher.voucherStatus getStatus()
    {
        return com.kingdee.eas.custom.salaryvoucher.voucherStatus.getEnum(getString("status"));
    }
    public void setStatus(com.kingdee.eas.custom.salaryvoucher.voucherStatus item)
    {
		if (item != null) {
        setString("status", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3CEBDADE");
    }
}