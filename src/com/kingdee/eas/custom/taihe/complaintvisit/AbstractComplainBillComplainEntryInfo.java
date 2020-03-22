package com.kingdee.eas.custom.taihe.complaintvisit;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractComplainBillComplainEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractComplainBillComplainEntryInfo()
    {
        this("id");
    }
    protected AbstractComplainBillComplainEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: Í¶Ëßµ¥·ÖÂ¼ 's null property 
     */
    public com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B48C46EB");
    }
}