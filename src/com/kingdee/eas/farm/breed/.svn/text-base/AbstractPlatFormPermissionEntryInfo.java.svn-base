package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPlatFormPermissionEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPlatFormPermissionEntryInfo()
    {
        this("id");
    }
    protected AbstractPlatFormPermissionEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.breed.PlatFormPermissionInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.PlatFormPermissionInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.PlatFormPermissionInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8C358036");
    }
}