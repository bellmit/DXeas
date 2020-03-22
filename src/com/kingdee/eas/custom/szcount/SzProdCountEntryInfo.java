package com.kingdee.eas.custom.szcount;

import java.io.Serializable;

public class SzProdCountEntryInfo extends AbstractSzProdCountEntryInfo implements Serializable 
{
    public SzProdCountEntryInfo()
    {
        super();
    }
    protected SzProdCountEntryInfo(String pkField)
    {
        super(pkField);
    }
}