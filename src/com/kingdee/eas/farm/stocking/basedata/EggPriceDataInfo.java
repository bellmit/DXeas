package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;

public class EggPriceDataInfo extends AbstractEggPriceDataInfo implements Serializable 
{
    public EggPriceDataInfo()
    {
        super();
    }
    protected EggPriceDataInfo(String pkField)
    {
        super(pkField);
    }
}