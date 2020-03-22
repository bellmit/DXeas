package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;

public class SignBDInfo extends AbstractSignBDInfo implements Serializable 
{
    public SignBDInfo()
    {
        super();
    }
    protected SignBDInfo(String pkField)
    {
        super(pkField);
    }
}