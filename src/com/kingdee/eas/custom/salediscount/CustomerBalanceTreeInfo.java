package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;

public class CustomerBalanceTreeInfo extends AbstractCustomerBalanceTreeInfo implements Serializable 
{
    public CustomerBalanceTreeInfo()
    {
        super();
    }
    protected CustomerBalanceTreeInfo(String pkField)
    {
        super(pkField);
    }
}