package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;

public class FormalBillEntryInfo extends AbstractFormalBillEntryInfo implements Serializable 
{
    public FormalBillEntryInfo()
    {
        super();
    }
    protected FormalBillEntryInfo(String pkField)
    {
        super(pkField);
    }
}