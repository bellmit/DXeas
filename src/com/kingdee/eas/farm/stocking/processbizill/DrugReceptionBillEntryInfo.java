package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;

public class DrugReceptionBillEntryInfo extends AbstractDrugReceptionBillEntryInfo implements Serializable 
{
    public DrugReceptionBillEntryInfo()
    {
        super();
    }
    protected DrugReceptionBillEntryInfo(String pkField)
    {
        super(pkField);
    }
}