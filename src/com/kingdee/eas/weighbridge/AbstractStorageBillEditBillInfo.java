package com.kingdee.eas.weighbridge;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStorageBillEditBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractStorageBillEditBillInfo()
    {
        this("id");
    }
    protected AbstractStorageBillEditBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.weighbridge.StorageBillEditBillEntryCollection());
    }
    /**
     * Object: ���������¼�¼ 's ��¼ property 
     */
    public com.kingdee.eas.weighbridge.StorageBillEditBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.weighbridge.StorageBillEditBillEntryCollection)get("entrys");
    }
    /**
     * Object:���������¼�¼'s �Ƿ�����ƾ֤property 
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
     * Object:���������¼�¼'s �������property 
     */
    public String getStorageBillNumber()
    {
        return getString("storageBillNumber");
    }
    public void setStorageBillNumber(String item)
    {
        setString("storageBillNumber", item);
    }
    /**
     * Object:���������¼�¼'s �������property 
     */
    public com.kingdee.eas.weighbridge.StorageBillType getStorageBillType()
    {
        return com.kingdee.eas.weighbridge.StorageBillType.getEnum(getString("storageBillType"));
    }
    public void setStorageBillType(com.kingdee.eas.weighbridge.StorageBillType item)
    {
		if (item != null) {
        setString("storageBillType", item.getValue());
		}
    }
    /**
     * Object:���������¼�¼'s ����IDproperty 
     */
    public String getBillID()
    {
        return getString("billID");
    }
    public void setBillID(String item)
    {
        setString("billID", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CDD394B8");
    }
}