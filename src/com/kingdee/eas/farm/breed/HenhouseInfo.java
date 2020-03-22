package com.kingdee.eas.farm.breed;

import java.io.Serializable;

public class HenhouseInfo extends AbstractHenhouseInfo implements Serializable 
{
    public HenhouseInfo()
    {
        super();
    }
    protected HenhouseInfo(String pkField)
    {
        super(pkField);
    }
}