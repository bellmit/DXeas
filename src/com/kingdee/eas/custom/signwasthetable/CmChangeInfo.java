package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;

public class CmChangeInfo extends AbstractCmChangeInfo implements Serializable 
{
    public CmChangeInfo()
    {
        super();
    }
    protected CmChangeInfo(String pkField)
    {
        super(pkField);
    }
}