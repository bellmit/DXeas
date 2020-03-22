package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;

public class DiscountCustomerRelInfo extends AbstractDiscountCustomerRelInfo implements Serializable 
{
    public DiscountCustomerRelInfo()
    {
        super();
    }
    protected DiscountCustomerRelInfo(String pkField)
    {
        super(pkField);
    }
}