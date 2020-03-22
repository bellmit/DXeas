package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;

public class CustomerBalanceInfo extends AbstractCustomerBalanceInfo implements Serializable 
{
    public CustomerBalanceInfo()
    {
        super();
    }
    protected CustomerBalanceInfo(String pkField)
    {
        super(pkField);
    }
}