package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;

public class TranInEntryInfo extends AbstractTranInEntryInfo implements Serializable 
{
    public TranInEntryInfo()
    {
        super();
    }
    protected TranInEntryInfo(String pkField)
    {
        super(pkField);
    }
}