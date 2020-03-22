package com.kingdee.eas.custom.dx.baseset;

import java.io.Serializable;

public class ChangepackingEntryInfo extends AbstractChangepackingEntryInfo implements Serializable 
{
    public ChangepackingEntryInfo()
    {
        super();
    }
    protected ChangepackingEntryInfo(String pkField)
    {
        super(pkField);
    }
}