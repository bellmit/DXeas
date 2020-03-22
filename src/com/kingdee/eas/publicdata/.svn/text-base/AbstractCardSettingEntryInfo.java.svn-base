package com.kingdee.eas.publicdata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCardSettingEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCardSettingEntryInfo()
    {
        this("id");
    }
    protected AbstractCardSettingEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: œÍœ∏…Ë÷√ 's null property 
     */
    public com.kingdee.eas.publicdata.CardSettingInfo getParent()
    {
        return (com.kingdee.eas.publicdata.CardSettingInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.publicdata.CardSettingInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: œÍœ∏…Ë÷√ 's À¢ø®∆˜ property 
     */
    public com.kingdee.eas.publicdata.CardReaderInfo getCard()
    {
        return (com.kingdee.eas.publicdata.CardReaderInfo)get("card");
    }
    public void setCard(com.kingdee.eas.publicdata.CardReaderInfo item)
    {
        put("card", item);
    }
    /**
     * Object:œÍœ∏…Ë÷√'s ±∏◊¢property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A0F1AD15");
    }
}