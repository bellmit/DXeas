package com.kingdee.eas.custom.szcount;

import java.io.Serializable;

public class SzSemiProductInfo extends AbstractSzSemiProductInfo implements Serializable 
{
    public SzSemiProductInfo()
    {
        super();
    }
    protected SzSemiProductInfo(String pkField)
    {
        super(pkField);
    }
}