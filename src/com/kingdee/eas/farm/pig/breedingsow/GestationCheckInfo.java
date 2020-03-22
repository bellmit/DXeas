package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;

public class GestationCheckInfo extends AbstractGestationCheckInfo implements Serializable 
{
    public GestationCheckInfo()
    {
        super();
    }
    protected GestationCheckInfo(String pkField)
    {
        super(pkField);
    }
}