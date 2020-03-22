package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;

public class EggSettlePolicyInfo extends AbstractEggSettlePolicyInfo implements Serializable 
{
    public EggSettlePolicyInfo()
    {
        super();
    }
    protected EggSettlePolicyInfo(String pkField)
    {
        super(pkField);
    }
}