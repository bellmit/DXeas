package com.kingdee.eas.farm.hatch;

import java.io.Serializable;

public class BEggHatchBillInfo extends AbstractBEggHatchBillInfo implements Serializable 
{
    public BEggHatchBillInfo()
    {
        super();
    }
    protected BEggHatchBillInfo(String pkField)
    {
        super(pkField);
    }
}