package com.kingdee.eas.custom.wages;

import java.io.Serializable;

public class InsuranceRegistInfo extends AbstractInsuranceRegistInfo implements Serializable 
{
    public InsuranceRegistInfo()
    {
        super();
    }
    protected InsuranceRegistInfo(String pkField)
    {
        super(pkField);
    }
}