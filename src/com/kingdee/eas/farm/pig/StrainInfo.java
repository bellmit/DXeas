package com.kingdee.eas.farm.pig;

import java.io.Serializable;

public class StrainInfo extends AbstractStrainInfo implements Serializable 
{
    public StrainInfo()
    {
        super();
    }
    protected StrainInfo(String pkField)
    {
        super(pkField);
    }
}