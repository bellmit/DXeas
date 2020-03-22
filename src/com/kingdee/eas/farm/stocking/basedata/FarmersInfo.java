package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;

public class FarmersInfo extends AbstractFarmersInfo implements Serializable 
{
    public FarmersInfo()
    {
        super();
    }
    protected FarmersInfo(String pkField)
    {
        super(pkField);
    }
}