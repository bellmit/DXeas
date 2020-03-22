package com.kingdee.eas.farm.hatch;

import java.io.Serializable;

public class HatchBillEntryInfo extends AbstractHatchBillEntryInfo implements Serializable 
{
    public HatchBillEntryInfo()
    {
        super();
    }
    protected HatchBillEntryInfo(String pkField)
    {
        super(pkField);
    }
}