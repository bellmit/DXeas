package com.kingdee.eas.custom.rye;

import java.io.Serializable;

public class RyeReadFilesEntryInfo extends AbstractRyeReadFilesEntryInfo implements Serializable 
{
    public RyeReadFilesEntryInfo()
    {
        super();
    }
    protected RyeReadFilesEntryInfo(String pkField)
    {
        super(pkField);
    }
}