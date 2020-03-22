package com.kingdee.eas.custom.eas2temp;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDataBaseSettingInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDataBaseSettingInfo()
    {
        this("id");
    }
    protected AbstractDataBaseSettingInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 中间库连接设置 's 组别 property 
     */
    public com.kingdee.eas.custom.eas2temp.DataBaseSettingTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.eas2temp.DataBaseSettingTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.eas2temp.DataBaseSettingTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 中间库连接设置 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getCompanyID()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("companyID");
    }
    public void setCompanyID(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("companyID", item);
    }
    /**
     * Object:中间库连接设置's 数据库IPproperty 
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
     * Object:中间库连接设置's 数据库名称property 
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
     * Object:中间库连接设置's 用户名property 
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
     * Object:中间库连接设置's 密码property 
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
     * Object:中间库连接设置's 数据库端口property 
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
     * Object:中间库连接设置's 目标系统property 
     */
    public com.kingdee.eas.custom.eas2temp.TargetSystem getTargetSystem()
    {
        return com.kingdee.eas.custom.eas2temp.TargetSystem.getEnum(getInt("targetSystem"));
    }
    public void setTargetSystem(com.kingdee.eas.custom.eas2temp.TargetSystem item)
    {
		if (item != null) {
        setInt("targetSystem", item.getValue());
		}
    }
    /**
     * Object:中间库连接设置's 数据库版本property 
     */
    public com.kingdee.eas.custom.eas2temp.databaseVersion getDatabaseVersion()
    {
        return com.kingdee.eas.custom.eas2temp.databaseVersion.getEnum(getInt("databaseVersion"));
    }
    public void setDatabaseVersion(com.kingdee.eas.custom.eas2temp.databaseVersion item)
    {
		if (item != null) {
        setInt("databaseVersion", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2F6377E1");
    }
}