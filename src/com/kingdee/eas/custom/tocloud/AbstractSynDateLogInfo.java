package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSynDateLogInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSynDateLogInfo()
    {
        this("id");
    }
    protected AbstractSynDateLogInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.tocloud.SynDateLogEntryCollection());
    }
    /**
     * Object: ����ͬ����־ 's ��¼ property 
     */
    public com.kingdee.eas.custom.tocloud.SynDateLogEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.tocloud.SynDateLogEntryCollection)get("entrys");
    }
    /**
     * Object:����ͬ����־'s �Ƿ�����ƾ֤property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: ����ͬ����־ 's �����֯ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorareBill()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storareBill");
    }
    public void setStorareBill(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storareBill", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("892A58A7");
    }
}