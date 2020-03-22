package com.kingdee.eas.farm.hatch;

import java.io.Serializable;

public class IncubatorInfo extends AbstractIncubatorInfo implements Serializable 
{
    public IncubatorInfo()
    {
        super();
    }
    protected IncubatorInfo(String pkField)
    {
        super(pkField);
    }
}