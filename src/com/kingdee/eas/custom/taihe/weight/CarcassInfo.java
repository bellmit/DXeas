package com.kingdee.eas.custom.taihe.weight;

import java.io.Serializable;

public class CarcassInfo extends AbstractCarcassInfo implements Serializable 
{
    public CarcassInfo()
    {
        super();
    }
    protected CarcassInfo(String pkField)
    {
        super(pkField);
    }
}