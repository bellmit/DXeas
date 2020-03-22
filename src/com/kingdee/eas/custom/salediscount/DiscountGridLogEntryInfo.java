package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;

public class DiscountGridLogEntryInfo extends AbstractDiscountGridLogEntryInfo implements Serializable 
{
    public DiscountGridLogEntryInfo()
    {
        super();
    }
    protected DiscountGridLogEntryInfo(String pkField)
    {
        super(pkField);
    }
}