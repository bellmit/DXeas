package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPlatFormPermissionInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractPlatFormPermissionInfo()
    {
        this("id");
    }
    protected AbstractPlatFormPermissionInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.breed.PlatFormPermissionEntryCollection());
    }
    /**
     * Object: 看板权限 's 分录 property 
     */
    public com.kingdee.eas.farm.breed.PlatFormPermissionEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.PlatFormPermissionEntryCollection)get("entrys");
    }
    /**
     * Object:看板权限's 是否生成凭证property 
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
        return new BOSObjectType("427A399C");
    }
}