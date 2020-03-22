package com.kingdee.eas.custom.wages;

import java.io.Serializable;

public class ExtractFromEntryInfo extends AbstractExtractFromEntryInfo implements Serializable 
{
    public ExtractFromEntryInfo()
    {
        super();
    }
    protected ExtractFromEntryInfo(String pkField)
    {
        super(pkField);
    }
}