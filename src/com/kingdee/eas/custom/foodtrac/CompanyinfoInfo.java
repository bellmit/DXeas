package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;

public class CompanyinfoInfo extends AbstractCompanyinfoInfo implements Serializable 
{
    public CompanyinfoInfo()
    {
        super();
    }
    protected CompanyinfoInfo(String pkField)
    {
        super(pkField);
    }
}