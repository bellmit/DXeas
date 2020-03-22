package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class FreightBaseInfo extends AbstractFreightBaseInfo implements Serializable 
{
    public FreightBaseInfo()
    {
        super();
    }
    protected FreightBaseInfo(String pkField)
    {
        super(pkField);
    }
}