package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;

public class BabyPigInfo extends AbstractBabyPigInfo implements Serializable 
{
    public BabyPigInfo()
    {
        super();
    }
    protected BabyPigInfo(String pkField)
    {
        super(pkField);
    }
}