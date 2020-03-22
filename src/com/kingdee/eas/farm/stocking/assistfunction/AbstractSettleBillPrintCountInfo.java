package com.kingdee.eas.farm.stocking.assistfunction;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleBillPrintCountInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSettleBillPrintCountInfo()
    {
        this("id");
    }
    protected AbstractSettleBillPrintCountInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:���㵥��ӡ��¼'s �Ƿ�����ƾ֤property 
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
     * Object:���㵥��ӡ��¼'s ���֤��property 
     */
    public String getIdentityID()
    {
        return getString("identityID");
    }
    public void setIdentityID(String item)
    {
        setString("identityID", item);
    }
    /**
     * Object:���㵥��ӡ��¼'s Ա������property 
     */
    public String getPersonName()
    {
        return getString("personName");
    }
    public void setPersonName(String item)
    {
        setString("personName", item);
    }
    /**
     * Object:���㵥��ӡ��¼'s ����property 
     */
    public boolean isIsCancel()
    {
        return getBoolean("isCancel");
    }
    public void setIsCancel(boolean item)
    {
        setBoolean("isCancel", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E79C877F");
    }
}