package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTargetSystemInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractTargetSystemInfo()
    {
        this("id");
    }
    protected AbstractTargetSystemInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: Ŀ��ϵͳ 's ��� property 
     */
    public com.kingdee.eas.custom.tocloud.TargetSystemTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.tocloud.TargetSystemTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.tocloud.TargetSystemTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:Ŀ��ϵͳ's �汾��property 
     */
    public String getVersion()
    {
        return getString("version");
    }
    public void setVersion(String item)
    {
        setString("version", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("940248B9");
    }
}