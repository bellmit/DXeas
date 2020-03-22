package com.kingdee.eas.custom.rye;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRyeReadFilesEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractRyeReadFilesEntryInfo()
    {
        this("id");
    }
    protected AbstractRyeReadFilesEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.rye.RyeReadFilesInfo getParent()
    {
        return (com.kingdee.eas.custom.rye.RyeReadFilesInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.rye.RyeReadFilesInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("36861A7A");
    }
}