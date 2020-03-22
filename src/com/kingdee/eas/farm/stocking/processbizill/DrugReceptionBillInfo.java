package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;

public class DrugReceptionBillInfo extends AbstractDrugReceptionBillInfo implements Serializable 
{
    public DrugReceptionBillInfo()
    {
        super();
    }
    protected DrugReceptionBillInfo(String pkField)
    {
        super(pkField);
    }
}