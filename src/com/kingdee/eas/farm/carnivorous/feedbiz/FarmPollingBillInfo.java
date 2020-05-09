package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;

public class FarmPollingBillInfo extends AbstractFarmPollingBillInfo implements Serializable 
{
    public FarmPollingBillInfo()
    {
        super();
    }
    protected FarmPollingBillInfo(String pkField)
    {
        super(pkField);
    }
}