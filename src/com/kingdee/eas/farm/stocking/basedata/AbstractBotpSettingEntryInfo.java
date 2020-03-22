package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBotpSettingEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBotpSettingEntryInfo()
    {
        this("id");
    }
    protected AbstractBotpSettingEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BotpSettingInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BotpSettingInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.BotpSettingInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public String getBillName()
    {
        return getString("billName");
    }
    public void setBillName(String item)
    {
        setString("billName", item);
    }
    /**
     * Object:��¼'s ת���������property 
     */
    public String getBotpNum()
    {
        return getString("botpNum");
    }
    public void setBotpNum(String item)
    {
        setString("botpNum", item);
    }
    /**
     * Object:��¼'s ˵��property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:��¼'s BOSTYPEproperty 
     */
    public String getBillBosType()
    {
        return getString("billBosType");
    }
    public void setBillBosType(String item)
    {
        setString("billBosType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A7273F7C");
    }
}