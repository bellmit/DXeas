package com.kingdee.eas.spray;

import java.io.Serializable;

public class CustomerSprayInvEntryInfo extends AbstractCustomerSprayInvEntryInfo implements Serializable 
{
    public CustomerSprayInvEntryInfo()
    {
        super();
    }
    protected CustomerSprayInvEntryInfo(String pkField)
    {
        super(pkField);
    }
}