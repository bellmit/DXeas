package com.kingdee.eas.weighbridge;

import java.io.Serializable;

public class FeInStorageBillInfo extends AbstractFeInStorageBillInfo implements Serializable 
{
    public FeInStorageBillInfo()
    {
        super();
    }
    protected FeInStorageBillInfo(String pkField)
    {
        super(pkField);
    }
}