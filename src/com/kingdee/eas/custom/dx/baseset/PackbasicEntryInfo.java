package com.kingdee.eas.custom.dx.baseset;

import java.io.Serializable;

public class PackbasicEntryInfo extends AbstractPackbasicEntryInfo implements Serializable 
{
    public PackbasicEntryInfo()
    {
        super();
    }
    protected PackbasicEntryInfo(String pkField)
    {
        super(pkField);
    }
}