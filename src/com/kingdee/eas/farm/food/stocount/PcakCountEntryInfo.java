package com.kingdee.eas.farm.food.stocount;

import java.io.Serializable;

public class PcakCountEntryInfo extends AbstractPcakCountEntryInfo implements Serializable 
{
    public PcakCountEntryInfo()
    {
        super();
    }
    protected PcakCountEntryInfo(String pkField)
    {
        super(pkField);
    }
}