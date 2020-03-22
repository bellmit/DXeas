package com.kingdee.eas.farm.pig;

import java.io.Serializable;

public class StrainTreeInfo extends AbstractStrainTreeInfo implements Serializable 
{
    public StrainTreeInfo()
    {
        super();
    }
    protected StrainTreeInfo(String pkField)
    {
        super(pkField);
    }
}