package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;

public class SettlementItemInfo extends AbstractSettlementItemInfo implements Serializable 
{
    public SettlementItemInfo()
    {
        super();
    }
    protected SettlementItemInfo(String pkField)
    {
        super(pkField);
    }
}