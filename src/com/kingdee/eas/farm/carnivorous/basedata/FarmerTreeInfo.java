package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class FarmerTreeInfo extends AbstractFarmerTreeInfo implements Serializable 
{
    public FarmerTreeInfo()
    {
        super();
    }
    protected FarmerTreeInfo(String pkField)
    {
        super(pkField);
    }
}