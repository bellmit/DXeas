package com.kingdee.eas.custom.wages.food;

import java.io.Serializable;

public class WageFoodOrganInfo extends AbstractWageFoodOrganInfo implements Serializable 
{
    public WageFoodOrganInfo()
    {
        super();
    }
    protected WageFoodOrganInfo(String pkField)
    {
        super(pkField);
    }
}