package com.kingdee.eas.custom.wages;

import java.io.Serializable;

public class InsuranceTypeInfo extends AbstractInsuranceTypeInfo implements Serializable 
{
    public InsuranceTypeInfo()
    {
        super();
    }
    protected InsuranceTypeInfo(String pkField)
    {
        super(pkField);
    }
}