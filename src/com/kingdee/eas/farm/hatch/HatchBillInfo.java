package com.kingdee.eas.farm.hatch;

import java.io.Serializable;

public class HatchBillInfo extends AbstractHatchBillInfo implements Serializable 
{
    public HatchBillInfo()
    {
        super();
    }
    protected HatchBillInfo(String pkField)
    {
        super(pkField);
    }
}