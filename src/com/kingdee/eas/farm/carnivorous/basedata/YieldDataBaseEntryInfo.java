package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class YieldDataBaseEntryInfo extends AbstractYieldDataBaseEntryInfo implements Serializable 
{
    public YieldDataBaseEntryInfo()
    {
        super();
    }
    protected YieldDataBaseEntryInfo(String pkField)
    {
        super(pkField);
    }
}