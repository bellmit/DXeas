package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;

public class DiscountSetInfo extends AbstractDiscountSetInfo implements Serializable 
{
    public DiscountSetInfo()
    {
        super();
    }
    protected DiscountSetInfo(String pkField)
    {
        super(pkField);
    }
}