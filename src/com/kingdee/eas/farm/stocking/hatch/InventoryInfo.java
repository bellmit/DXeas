package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;

public class InventoryInfo extends AbstractInventoryInfo implements Serializable 
{
    public InventoryInfo()
    {
        super();
    }
    protected InventoryInfo(String pkField)
    {
        super(pkField);
    }
}