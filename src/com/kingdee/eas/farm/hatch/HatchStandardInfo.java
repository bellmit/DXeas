package com.kingdee.eas.farm.hatch;

import java.io.Serializable;

public class HatchStandardInfo extends AbstractHatchStandardInfo implements Serializable 
{
    public HatchStandardInfo()
    {
        super();
    }
    protected HatchStandardInfo(String pkField)
    {
        super(pkField);
    }
}