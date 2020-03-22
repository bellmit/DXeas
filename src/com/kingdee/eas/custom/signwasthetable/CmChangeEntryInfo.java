package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;

public class CmChangeEntryInfo extends AbstractCmChangeEntryInfo implements Serializable 
{
    public CmChangeEntryInfo()
    {
        super();
    }
    protected CmChangeEntryInfo(String pkField)
    {
        super(pkField);
    }
}