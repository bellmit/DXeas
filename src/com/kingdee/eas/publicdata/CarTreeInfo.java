package com.kingdee.eas.publicdata;

import java.io.Serializable;

public class CarTreeInfo extends AbstractCarTreeInfo implements Serializable 
{
    public CarTreeInfo()
    {
        super();
    }
    protected CarTreeInfo(String pkField)
    {
        super(pkField);
    }
}