package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAppealBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractAppealBillEntryInfo()
    {
        this("id");
    }
    protected AbstractAppealBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.AppealBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.AppealBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.AppealBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public java.math.BigDecimal getAmout()
    {
        return getBigDecimal("amout");
    }
    public void setAmout(java.math.BigDecimal item)
    {
        setBigDecimal("amout", item);
    }
    /**
     * Object:��¼'s ԭ��property 
     */
    public String getReason()
    {
        return getString("reason");
    }
    public void setReason(String item)
    {
        setString("reason", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("67C371D7");
    }
}