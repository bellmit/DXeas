package com.kingdee.eas.custom.szcount;

import java.io.Serializable;

public class PackingConversionInfo extends AbstractPackingConversionInfo implements Serializable 
{
    public PackingConversionInfo()
    {
        super();
    }
    protected PackingConversionInfo(String pkField)
    {
        super(pkField);
    }
}