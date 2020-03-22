package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;

public class FodderReceptionInfo extends AbstractFodderReceptionInfo implements Serializable 
{
    public FodderReceptionInfo()
    {
        super();
    }
    protected FodderReceptionInfo(String pkField)
    {
        super(pkField);
    }
}