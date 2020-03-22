package com.kingdee.eas.spray;

import java.io.Serializable;

public class SparyRecordEntryInfo extends AbstractSparyRecordEntryInfo implements Serializable 
{
    public SparyRecordEntryInfo()
    {
        super();
    }
    protected SparyRecordEntryInfo(String pkField)
    {
        super(pkField);
    }
}