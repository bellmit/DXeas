package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBaseDataRelInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBaseDataRelInfo()
    {
        this("id");
    }
    protected AbstractBaseDataRelInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.tocloud.BaseDataRelEntryCollection());
    }
    /**
     * Object: 基础资料映射 's 组别 property 
     */
    public com.kingdee.eas.custom.tocloud.BaseDataRelTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.tocloud.BaseDataRelTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.tocloud.BaseDataRelTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 基础资料映射 's 分录 property 
     */
    public com.kingdee.eas.custom.tocloud.BaseDataRelEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.tocloud.BaseDataRelEntryCollection)get("Entry");
    }
    /**
     * Object: 基础资料映射 's 目标系统 property 
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
     * Object: 基础资料映射 's 基础资料类型 property 
     */
    public com.kingdee.eas.custom.tocloud.BaseDataTypeInfo getBaseDataType()
    {
        return (com.kingdee.eas.custom.tocloud.BaseDataTypeInfo)get("baseDataType");
    }
    public void setBaseDataType(com.kingdee.eas.custom.tocloud.BaseDataTypeInfo item)
    {
        put("baseDataType", item);
    }
    /**
     * Object:基础资料映射's 业务日期property 
     */
    public java.util.Date getBizDate()
    {
        return getDate("bizDate");
    }
    public void setBizDate(java.util.Date item)
    {
        setDate("bizDate", item);
    }
    /**
     * Object:基础资料映射's 单据状态property 
     */
    public com.kingdee.eas.ncm.common.BillBaseStatusEnum getStatus()
    {
        return com.kingdee.eas.ncm.common.BillBaseStatusEnum.getEnum(getInt("status"));
    }
    public void setStatus(com.kingdee.eas.ncm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("status", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FDC6EBC5");
    }
}