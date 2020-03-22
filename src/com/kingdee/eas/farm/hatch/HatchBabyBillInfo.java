package com.kingdee.eas.farm.hatch;

import java.io.Serializable;

public class HatchBabyBillInfo extends AbstractHatchBabyBillInfo implements Serializable 
{
    public HatchBabyBillInfo()
    {
        super();
    }
    protected HatchBabyBillInfo(String pkField)
    {
        super(pkField);
    }
}