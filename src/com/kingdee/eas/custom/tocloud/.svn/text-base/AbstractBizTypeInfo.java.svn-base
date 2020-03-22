package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBizTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBizTypeInfo()
    {
        this("id");
    }
    protected AbstractBizTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 业务类型 's 组别 property 
     */
    public com.kingdee.eas.custom.tocloud.BizTypeTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.tocloud.BizTypeTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.tocloud.BizTypeTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:业务类型's BosTypeproperty 
     */
    public String getBosType()
    {
        return getString("BosType");
    }
    public void setBosType(String item)
    {
        setString("BosType", item);
    }
    /**
     * Object:业务类型's queryproperty 
     */
    public String getQuery()
    {
        return getString("query");
    }
    public void setQuery(String item)
    {
        setString("query", item);
    }
    /**
     * Object: 业务类型 's 目标系统 property 
     */
    public com.kingdee.eas.custom.tocloud.TargetSystemInfo getTargetSystem()
    {
        return (com.kingdee.eas.custom.tocloud.TargetSystemInfo)get("targetSystem");
    }
    public void setTargetSystem(com.kingdee.eas.custom.tocloud.TargetSystemInfo item)
    {
        put("targetSystem", item);
    }
    /**
     * Object:业务类型's 实现类property 
     */
    public String getImplClass()
    {
        return getString("implClass");
    }
    public void setImplClass(String item)
    {
        setString("implClass", item);
    }
    /**
     * Object:业务类型's 批次property 
     */
    public String getBatchQuery()
    {
        return getString("batchQuery");
    }
    public void setBatchQuery(String item)
    {
        setString("batchQuery", item);
    }
    /**
     * Object: 业务类型 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOranization()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("StorageOranization");
    }
    public void setStorageOranization(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("StorageOranization", item);
    }
    /**
     * Object:业务类型's 是否按照批次过滤property 
     */
    public boolean isIsBatchFilter()
    {
        return getBoolean("isBatchFilter");
    }
    public void setIsBatchFilter(boolean item)
    {
        setBoolean("isBatchFilter", item);
    }
    /**
     * Object:业务类型's 是否退料property 
     */
    public boolean isIsReturn()
    {
        return getBoolean("isReturn");
    }
    public void setIsReturn(boolean item)
    {
        setBoolean("isReturn", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("80DBB9B4");
    }
}