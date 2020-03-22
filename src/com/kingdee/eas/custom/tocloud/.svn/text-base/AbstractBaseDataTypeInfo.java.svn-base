package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBaseDataTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBaseDataTypeInfo()
    {
        this("id");
    }
    protected AbstractBaseDataTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 基础资料类型 's 组别 property 
     */
    public com.kingdee.eas.custom.tocloud.BaseDataTypeTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.tocloud.BaseDataTypeTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.tocloud.BaseDataTypeTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 基础资料类型 's 目标系统 property 
     */
    public com.kingdee.eas.custom.tocloud.TargetSystemInfo getTargetSystem()
    {
        return (com.kingdee.eas.custom.tocloud.TargetSystemInfo)get("targetSystem");
    }
    public void setTargetSystem(com.kingdee.eas.custom.tocloud.TargetSystemInfo item)
    {
        put("targetSystem", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BB17C18E");
    }
}