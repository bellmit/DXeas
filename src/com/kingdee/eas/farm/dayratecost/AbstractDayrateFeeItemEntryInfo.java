package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDayrateFeeItemEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDayrateFeeItemEntryInfo()
    {
        this("id");
    }
    protected AbstractDayrateFeeItemEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's null property 
     */
    public com.kingdee.eas.farm.dayratecost.DayrateFeeItemInfo getParent()
    {
        return (com.kingdee.eas.farm.dayratecost.DayrateFeeItemInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.dayratecost.DayrateFeeItemInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 会计科目 property 
     */
    public com.kingdee.eas.basedata.master.account.AccountViewInfo getAccount()
    {
        return (com.kingdee.eas.basedata.master.account.AccountViewInfo)get("account");
    }
    public void setAccount(com.kingdee.eas.basedata.master.account.AccountViewInfo item)
    {
        put("account", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8EC15B50");
    }
}