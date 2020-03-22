package com.kingdee.eas.custom.test;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSdlEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSdlEntryInfo()
    {
        this("id");
    }
    protected AbstractSdlEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.test.SdlInfo getParent()
    {
        return (com.kingdee.eas.custom.test.SdlInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.test.SdlInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's sss property 
     */
    public com.kingdee.eas.basedata.master.account.AccountViewInfo getSss()
    {
        return (com.kingdee.eas.basedata.master.account.AccountViewInfo)get("sss");
    }
    public void setSss(com.kingdee.eas.basedata.master.account.AccountViewInfo item)
    {
        put("sss", item);
    }
    /**
     * Object: 分录 's ssssss property 
     */
    public com.kingdee.eas.basedata.master.account.AccountViewInfo getAaaa()
    {
        return (com.kingdee.eas.basedata.master.account.AccountViewInfo)get("aaaa");
    }
    public void setAaaa(com.kingdee.eas.basedata.master.account.AccountViewInfo item)
    {
        put("aaaa", item);
    }
    /**
     * Object: 分录 's sssssssss property 
     */
    public com.kingdee.eas.basedata.master.account.AccountViewInfo getSssss()
    {
        return (com.kingdee.eas.basedata.master.account.AccountViewInfo)get("sssss");
    }
    public void setSssss(com.kingdee.eas.basedata.master.account.AccountViewInfo item)
    {
        put("sssss", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("857FC528");
    }
}