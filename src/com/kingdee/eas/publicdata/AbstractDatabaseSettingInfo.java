package com.kingdee.eas.publicdata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDatabaseSettingInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDatabaseSettingInfo()
    {
        this("id");
    }
    protected AbstractDatabaseSettingInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 数据库连接设置 's 组别 property 
     */
    public com.kingdee.eas.publicdata.DatabaseSettingTreeInfo getTreeid()
    {
        return (com.kingdee.eas.publicdata.DatabaseSettingTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.publicdata.DatabaseSettingTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:数据库连接设置's 数据库类型property 
     */
    public com.kingdee.eas.publicdata.dbType getDbType()
    {
        return com.kingdee.eas.publicdata.dbType.getEnum(getString("dbType"));
    }
    public void setDbType(com.kingdee.eas.publicdata.dbType item)
    {
		if (item != null) {
        setString("dbType", item.getValue());
		}
    }
    /**
     * Object:数据库连接设置's 数据库文件地址property 
     */
    public String getDbFileAddress()
    {
        return getString("dbFileAddress");
    }
    public void setDbFileAddress(String item)
    {
        setString("dbFileAddress", item);
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
    public String getPassword()
    {
        return getString("password");
    }
    public void setPassword(String item)
    {
        setString("password", item);
    }
    /**
     * Object: 数据库连接设置 's 组织 property 
     */
    public com.kingdee.eas.basedata.org.FullOrgUnitInfo getOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.FullOrgUnitInfo)get("orgUnit");
    }
    public void setOrgUnit(com.kingdee.eas.basedata.org.FullOrgUnitInfo item)
    {
        put("orgUnit", item);
    }
    /**
     * Object:数据库连接设置's 数据库地址property 
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
     * Object:数据库连接设置's 数据库名称property 
     */
    public String getDbName()
    {
        return getString("dbName");
    }
    public void setDbName(String item)
    {
        setString("dbName", item);
    }
    /**
     * Object:数据库连接设置's 数据库端口property 
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
     * Object:数据库连接设置's 数据库名称脚本property 
     */
    public String getDbNameJS()
    {
        return getString("dbNameJS");
    }
    public void setDbNameJS(String item)
    {
        setString("dbNameJS", item);
    }
    /**
     * Object:数据库连接设置's 文本property 
     */
    public String getBIMUDF0012()
    {
        return getString("BIMUDF0012");
    }
    public void setBIMUDF0012(String item)
    {
        setString("BIMUDF0012", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("65574212");
    }
}