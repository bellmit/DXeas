package com.kingdee.eas.custom.settlebill;

import java.io.Serializable;

public class SettleBillInfo extends AbstractSettleBillInfo implements Serializable 
{
    public SettleBillInfo()
    {
        super();
    }
    protected SettleBillInfo(String pkField)
    {
        super(pkField);
    }
}