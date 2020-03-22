package com.kingdee.eas.custom.szcount;

import java.io.Serializable;

public class ChickenBasicDataInfo extends AbstractChickenBasicDataInfo implements Serializable 
{
    public ChickenBasicDataInfo()
    {
        super();
    }
    protected ChickenBasicDataInfo(String pkField)
    {
        super(pkField);
    }
}