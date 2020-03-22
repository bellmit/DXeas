package com.kingdee.eas.farm.food.stocount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSemiProductCountEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSemiProductCountEntryInfo()
    {
        this("id");
    }
    protected AbstractSemiProductCountEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.food.stocount.SemiProductCountInfo getParent()
    {
        return (com.kingdee.eas.farm.food.stocount.SemiProductCountInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.food.stocount.SemiProductCountInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D3F9F687");
    }
}