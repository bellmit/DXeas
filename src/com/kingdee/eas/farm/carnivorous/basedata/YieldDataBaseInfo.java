package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class YieldDataBaseInfo extends AbstractYieldDataBaseInfo implements Serializable 
{
    public YieldDataBaseInfo()
    {
        super();
    }
    protected YieldDataBaseInfo(String pkField)
    {
        super(pkField);
    }
}