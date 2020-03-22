package com.kingdee.eas.farm.hatch;

import java.io.Serializable;

public class HatchingBoxInfo extends AbstractHatchingBoxInfo implements Serializable 
{
    public HatchingBoxInfo()
    {
        super();
    }
    protected HatchingBoxInfo(String pkField)
    {
        super(pkField);
    }
}