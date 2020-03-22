package com.kingdee.eas.farm.food.stocount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCountPositionSetOperatorEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCountPositionSetOperatorEntryInfo()
    {
        this("id");
    }
    protected AbstractCountPositionSetOperatorEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 操作员分录 's null property 
     */
    public com.kingdee.eas.farm.food.stocount.CountPositionSetInfo getParent()
    {
        return (com.kingdee.eas.farm.food.stocount.CountPositionSetInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.food.stocount.CountPositionSetInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 操作员分录 's 计数员 property 
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
        return new BOSObjectType("3CC302C7");
    }
}