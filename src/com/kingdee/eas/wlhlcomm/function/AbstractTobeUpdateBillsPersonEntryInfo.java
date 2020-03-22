package com.kingdee.eas.wlhlcomm.function;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTobeUpdateBillsPersonEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTobeUpdateBillsPersonEntryInfo()
    {
        this("id");
    }
    protected AbstractTobeUpdateBillsPersonEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 更新用户 's null property 
     */
    public com.kingdee.eas.wlhlcomm.function.TobeUpdateBillsInfo getParent()
    {
        return (com.kingdee.eas.wlhlcomm.function.TobeUpdateBillsInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.wlhlcomm.function.TobeUpdateBillsInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 更新用户 's 用户 property 
     */
    public com.kingdee.eas.base.ssc.UserInfo getUser()
    {
        return (com.kingdee.eas.base.ssc.UserInfo)get("user");
    }
    public void setUser(com.kingdee.eas.base.ssc.UserInfo item)
    {
        put("user", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7F8D2817");
    }
}