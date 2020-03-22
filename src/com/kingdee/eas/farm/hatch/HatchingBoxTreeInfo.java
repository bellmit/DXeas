package com.kingdee.eas.farm.hatch;

import java.io.Serializable;

public class HatchingBoxTreeInfo extends AbstractHatchingBoxTreeInfo implements Serializable 
{
    public HatchingBoxTreeInfo()
    {
        super();
    }
    protected HatchingBoxTreeInfo(String pkField)
    {
        super(pkField);
    }
}