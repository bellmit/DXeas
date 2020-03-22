package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEntrustSettleStandardTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractEntrustSettleStandardTreeInfo()
    {
        this("id");
    }
    protected AbstractEntrustSettleStandardTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 委托养殖结算标准组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.breed.EntrustSettleStandardTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.EntrustSettleStandardTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.EntrustSettleStandardTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BC38667B");
    }
}