package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBaseSysSettingMarginTypeEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBaseSysSettingMarginTypeEntryInfo()
    {
        this("id");
    }
    protected AbstractBaseSysSettingMarginTypeEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 保证金收款类型 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 保证金收款类型 's 收款类型 property 
     */
    public com.kingdee.eas.fi.cas.ReceivingBillTypeInfo getReceiveType()
    {
        return (com.kingdee.eas.fi.cas.ReceivingBillTypeInfo)get("receiveType");
    }
    public void setReceiveType(com.kingdee.eas.fi.cas.ReceivingBillTypeInfo item)
    {
        put("receiveType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A2AC2685");
    }
}