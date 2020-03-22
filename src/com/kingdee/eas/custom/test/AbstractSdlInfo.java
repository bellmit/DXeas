package com.kingdee.eas.custom.test;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSdlInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSdlInfo()
    {
        this("id");
    }
    protected AbstractSdlInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.test.SdlEntryCollection());
    }
    /**
     * Object: Sdl 's 分录 property 
     */
    public com.kingdee.eas.custom.test.SdlEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.test.SdlEntryCollection)get("entrys");
    }
    /**
     * Object:Sdl's 是否生成凭证property 
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
     * Object: Sdl 's ss property 
     */
    public com.kingdee.eas.basedata.master.account.AccountViewInfo getSs()
    {
        return (com.kingdee.eas.basedata.master.account.AccountViewInfo)get("ss");
    }
    public void setSs(com.kingdee.eas.basedata.master.account.AccountViewInfo item)
    {
        put("ss", item);
    }
    /**
     * Object: Sdl 's 人员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8151256A");
    }
}