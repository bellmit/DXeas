package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;

public class SynDateLogEntryInfo extends AbstractSynDateLogEntryInfo implements Serializable 
{
    public SynDateLogEntryInfo()
    {
        super();
    }
    protected SynDateLogEntryInfo(String pkField)
    {
        super(pkField);
    }
}