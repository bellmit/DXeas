package com.kingdee.eas.message;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBaseSettingInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBaseSettingInfo()
    {
        this("id");
    }
    protected AbstractBaseSettingInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �������� 's ��� property 
     */
    public com.kingdee.eas.message.BaseSettingTreeInfo getTreeid()
    {
        return (com.kingdee.eas.message.BaseSettingTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.message.BaseSettingTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:��������'s ��Ϣ���յ�ַproperty 
     */
    public String getReceiverAddress()
    {
        return getString("receiverAddress");
    }
    public void setReceiverAddress(String item)
    {
        setString("receiverAddress", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D355B106");
    }
}