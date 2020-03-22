package com.kingdee.eas.custom.settlebill;

import java.io.Serializable;

public class SettleBillEntryInfo extends AbstractSettleBillEntryInfo implements Serializable 
{
    public SettleBillEntryInfo()
    {
        super();
    }
    protected SettleBillEntryInfo(String pkField)
    {
        super(pkField);
    }
}