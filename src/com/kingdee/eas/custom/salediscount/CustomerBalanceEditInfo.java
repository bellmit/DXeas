package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;

public class CustomerBalanceEditInfo extends AbstractCustomerBalanceEditInfo implements Serializable 
{
    public CustomerBalanceEditInfo()
    {
        super();
    }
    protected CustomerBalanceEditInfo(String pkField)
    {
        super(pkField);
    }
}