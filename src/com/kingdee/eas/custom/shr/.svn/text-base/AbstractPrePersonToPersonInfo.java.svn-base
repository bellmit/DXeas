package com.kingdee.eas.custom.shr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPrePersonToPersonInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractPrePersonToPersonInfo()
    {
        this("id");
    }
    protected AbstractPrePersonToPersonInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.shr.PrePersonToPersonEntryCollection());
    }
    /**
     * Object: 转入职单 's 分录 property 
     */
    public com.kingdee.eas.custom.shr.PrePersonToPersonEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.shr.PrePersonToPersonEntryCollection)get("entrys");
    }
    /**
     * Object:转入职单's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8E4D4B92");
    }
}