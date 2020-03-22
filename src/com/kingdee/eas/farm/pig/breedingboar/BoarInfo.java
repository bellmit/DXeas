package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;

public class BoarInfo extends AbstractBoarInfo implements Serializable 
{
    public BoarInfo()
    {
        super();
    }
    protected BoarInfo(String pkField)
    {
        super(pkField);
    }
}