package com.kingdee.eas.custom.rentalapplicationform;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRentalApplicationOfBusinessCarEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractRentalApplicationOfBusinessCarEntryInfo()
    {
        this("id");
    }
    protected AbstractRentalApplicationOfBusinessCarEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarInfo getParent()
    {
        return (com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2952419E");
    }
}