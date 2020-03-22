package com.kingdee.eas.custom.wages;

import java.io.Serializable;

public class ByThePieceBillInfo extends AbstractByThePieceBillInfo implements Serializable 
{
    public ByThePieceBillInfo()
    {
        super();
    }
    protected ByThePieceBillInfo(String pkField)
    {
        super(pkField);
    }
}