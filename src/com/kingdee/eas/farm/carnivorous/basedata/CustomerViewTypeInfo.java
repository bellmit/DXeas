package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class CustomerViewTypeInfo extends AbstractCustomerViewTypeInfo implements Serializable 
{
    public CustomerViewTypeInfo()
    {
        super();
    }
    protected CustomerViewTypeInfo(String pkField)
    {
        super(pkField);
    }
}