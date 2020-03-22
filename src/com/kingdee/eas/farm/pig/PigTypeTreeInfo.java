package com.kingdee.eas.farm.pig;

import java.io.Serializable;

public class PigTypeTreeInfo extends AbstractPigTypeTreeInfo implements Serializable 
{
    public PigTypeTreeInfo()
    {
        super();
    }
    protected PigTypeTreeInfo(String pkField)
    {
        super(pkField);
    }
}