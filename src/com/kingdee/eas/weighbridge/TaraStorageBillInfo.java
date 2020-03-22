package com.kingdee.eas.weighbridge;

import java.io.Serializable;

public class TaraStorageBillInfo extends AbstractTaraStorageBillInfo implements Serializable 
{
    public TaraStorageBillInfo()
    {
        super();
    }
    protected TaraStorageBillInfo(String pkField)
    {
        super(pkField);
    }
}