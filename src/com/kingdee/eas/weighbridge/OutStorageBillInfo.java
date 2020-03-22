package com.kingdee.eas.weighbridge;

import java.io.Serializable;

public class OutStorageBillInfo extends AbstractOutStorageBillInfo implements Serializable 
{
    public OutStorageBillInfo()
    {
        super();
    }
    protected OutStorageBillInfo(String pkField)
    {
        super(pkField);
    }
}