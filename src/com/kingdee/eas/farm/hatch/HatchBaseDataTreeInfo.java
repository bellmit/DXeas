package com.kingdee.eas.farm.hatch;

import java.io.Serializable;

public class HatchBaseDataTreeInfo extends AbstractHatchBaseDataTreeInfo implements Serializable 
{
    public HatchBaseDataTreeInfo()
    {
        super();
    }
    protected HatchBaseDataTreeInfo(String pkField)
    {
        super(pkField);
    }
}