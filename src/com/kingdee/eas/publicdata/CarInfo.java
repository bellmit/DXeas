package com.kingdee.eas.publicdata;

import java.io.Serializable;

public class CarInfo extends AbstractCarInfo implements Serializable 
{
    public CarInfo()
    {
        super();
    }
    protected CarInfo(String pkField)
    {
        super(pkField);
    }
}