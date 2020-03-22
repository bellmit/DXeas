package com.kingdee.eas.bdm.bdapply;

import java.io.Serializable;

public class CustomerInfoReqInfo extends AbstractCustomerInfoReqInfo implements Serializable 
{
    public CustomerInfoReqInfo()
    {
        super();
    }
    protected CustomerInfoReqInfo(String pkField)
    {
        super(pkField);
    }
}