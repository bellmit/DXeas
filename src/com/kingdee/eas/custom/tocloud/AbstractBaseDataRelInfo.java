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
     * Object: ��������ӳ�� 's ��� property 
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
     * Object: ��������ӳ�� 's ��¼ property 
     */
    public com.kingdee.eas.custom.tocloud.BaseDataRelEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.tocloud.BaseDataRelEntryCollection)get("Entry");
    }
    /**
     * Object: ��������ӳ�� 's Ŀ��ϵͳ property 
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
     * Object: ��������ӳ�� 's ������������ property 
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
     * Object:��������ӳ��'s ҵ������property 
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
     * Object:��������ӳ��'s ����״̬property 
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