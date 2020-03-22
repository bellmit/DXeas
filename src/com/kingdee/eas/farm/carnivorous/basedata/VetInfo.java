package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class VetInfo extends AbstractVetInfo implements Serializable 
{
    public VetInfo()
    {
        super();
    }
    protected VetInfo(String pkField)
    {
        super(pkField);
    }
}