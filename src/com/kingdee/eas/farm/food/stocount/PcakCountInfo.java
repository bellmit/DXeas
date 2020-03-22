package com.kingdee.eas.farm.food.stocount;

import java.io.Serializable;

public class PcakCountInfo extends AbstractPcakCountInfo implements Serializable 
{
    public PcakCountInfo()
    {
        super();
    }
    protected PcakCountInfo(String pkField)
    {
        super(pkField);
    }
}