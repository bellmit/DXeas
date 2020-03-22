package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class SettleDataBaseInfo extends AbstractSettleDataBaseInfo implements Serializable 
{
    public SettleDataBaseInfo()
    {
        super();
    }
    protected SettleDataBaseInfo(String pkField)
    {
        super(pkField);
    }
}