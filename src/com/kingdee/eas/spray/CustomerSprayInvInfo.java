package com.kingdee.eas.spray;

import java.io.Serializable;

public class CustomerSprayInvInfo extends AbstractCustomerSprayInvInfo implements Serializable 
{
    public CustomerSprayInvInfo()
    {
        super();
    }
    protected CustomerSprayInvInfo(String pkField)
    {
        super(pkField);
    }
}