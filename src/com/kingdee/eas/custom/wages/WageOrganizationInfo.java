package com.kingdee.eas.custom.wages;

import java.io.Serializable;

public class WageOrganizationInfo extends AbstractWageOrganizationInfo implements Serializable 
{
    public WageOrganizationInfo()
    {
        super();
    }
    protected WageOrganizationInfo(String pkField)
    {
        super(pkField);
    }
}