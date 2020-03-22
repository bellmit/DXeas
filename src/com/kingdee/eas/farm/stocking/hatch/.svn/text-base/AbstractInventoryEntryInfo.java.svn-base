package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInventoryEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractInventoryEntryInfo()
    {
        this("id");
    }
    protected AbstractInventoryEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.stocking.hatch.InventoryInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.hatch.InventoryInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.hatch.InventoryInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("23B59AE0");
    }
}