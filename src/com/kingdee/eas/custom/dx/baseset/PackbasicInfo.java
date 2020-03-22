package com.kingdee.eas.custom.dx.baseset;

import java.io.Serializable;

public class PackbasicInfo extends AbstractPackbasicInfo implements Serializable 
{
    public PackbasicInfo()
    {
        super();
    }
    protected PackbasicInfo(String pkField)
    {
        super(pkField);
    }
}