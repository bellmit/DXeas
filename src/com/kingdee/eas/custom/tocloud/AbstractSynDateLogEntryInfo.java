package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSynDateLogEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSynDateLogEntryInfo()
    {
        this("id");
    }
    protected AbstractSynDateLogEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.custom.tocloud.SynDateLogInfo getParent()
    {
        return (com.kingdee.eas.custom.tocloud.SynDateLogInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.tocloud.SynDateLogInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s Ŀ��ϵͳ����property 
     */
    public String getTargetSystemName()
    {
        return getString("targetSystemName");
    }
    public void setTargetSystemName(String item)
    {
        setString("targetSystemName", item);
    }
    /**
     * Object:��¼'s ҵ����������property 
     */
    public String getBizTypeName()
    {
        return getString("bizTypeName");
    }
    public void setBizTypeName(String item)
    {
        setString("bizTypeName", item);
    }
    /**
     * Object:��¼'s ��֯����property 
     */
    public String getCompanyName()
    {
        return getString("companyName");
    }
    public void setCompanyName(String item)
    {
        setString("companyName", item);
    }
    /**
     * Object:��¼'s ����ͬ��ʱ��property 
     */
    public String getSynDateTime()
    {
        return getString("synDateTime");
    }
    public void setSynDateTime(String item)
    {
        setString("synDateTime", item);
    }
    /**
     * Object:��¼'s ��¼IDproperty 
     */
    public String getEntryid()
    {
        return getString("entryid");
    }
    public void setEntryid(String item)
    {
        setString("entryid", item);
    }
    /**
     * Object:��¼'s ����IDproperty 
     */
    public String getBillid()
    {
        return getString("billid");
    }
    public void setBillid(String item)
    {
        setString("billid", item);
    }
    /**
     * Object:��¼'s �Ƿ�ɹ�property 
     */
    public boolean isIsSuccess()
    {
        return getBoolean("isSuccess");
    }
    public void setIsSuccess(boolean item)
    {
        setBoolean("isSuccess", item);
    }
    /**
     * Object:��¼'s ��ʱproperty 
     */
    public String getCostTime()
    {
        return getString("costTime");
    }
    public void setCostTime(String item)
    {
        setString("costTime", item);
    }
    /**
     * Object:��¼'s ҵ������IDproperty 
     */
    public String getBizTypeid()
    {
        return getString("bizTypeid");
    }
    public void setBizTypeid(String item)
    {
        setString("bizTypeid", item);
    }
    /**
     * Object:��¼'s ����ͬ�����property 
     */
    public String getSynDateInformation()
    {
        return getString("synDateInformation");
    }
    public void setSynDateInformation(String item)
    {
        setString("synDateInformation", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public String getBatchName()
    {
        return getString("batchName");
    }
    public void setBatchName(String item)
    {
        setString("batchName", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public String getHouse()
    {
        return getString("house");
    }
    public void setHouse(String item)
    {
        setString("house", item);
    }
    /**
     * Object:��¼'s cloud����IDproperty 
     */
    public String getCloudid()
    {
        return getString("Cloudid");
    }
    public void setCloudid(String item)
    {
        setString("Cloudid", item);
    }
    /**
     * Object:��¼'s Cloud���ݱ��property 
     */
    public String getCloudNum()
    {
        return getString("CloudNum");
    }
    public void setCloudNum(String item)
    {
        setString("CloudNum", item);
    }
    /**
     * Object:��¼'s ԭ���ݱ��property 
     */
    public String getBillNumber()
    {
        return getString("billNumber");
    }
    public void setBillNumber(String item)
    {
        setString("billNumber", item);
    }
    /**
     * Object:��¼'s ��ֳ�ձ�����property 
     */
    public String getStockingBizDateStocking()
    {
        return getString("stockingBizDateStocking");
    }
    public void setStockingBizDateStocking(String item)
    {
        setString("stockingBizDateStocking", item);
    }
    /**
     * Object: ��¼ 's �����֯ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorage()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storage");
    }
    public void setStorage(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storage", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EC86100B");
    }
}