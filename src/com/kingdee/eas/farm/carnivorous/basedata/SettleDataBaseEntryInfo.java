package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class SettleDataBaseEntryInfo extends AbstractSettleDataBaseEntryInfo implements Serializable 
{
    public SettleDataBaseEntryInfo()
    {
        super();
    }
    protected SettleDataBaseEntryInfo(String pkField)
    {
        super(pkField);
    }
}