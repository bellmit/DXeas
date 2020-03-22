package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;

public class DiscountSetEntryInfo extends AbstractDiscountSetEntryInfo implements Serializable 
{
    public DiscountSetEntryInfo()
    {
        super();
    }
    protected DiscountSetEntryInfo(String pkField)
    {
        super(pkField);
    }
}