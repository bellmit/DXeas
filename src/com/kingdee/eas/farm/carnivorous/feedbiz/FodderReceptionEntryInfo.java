package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;

public class FodderReceptionEntryInfo extends AbstractFodderReceptionEntryInfo implements Serializable 
{
    public FodderReceptionEntryInfo()
    {
        super();
    }
    protected FodderReceptionEntryInfo(String pkField)
    {
        super(pkField);
    }
}