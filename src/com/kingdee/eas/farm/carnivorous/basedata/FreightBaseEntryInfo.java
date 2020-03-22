package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class FreightBaseEntryInfo extends AbstractFreightBaseEntryInfo implements Serializable 
{
    public FreightBaseEntryInfo()
    {
        super();
    }
    protected FreightBaseEntryInfo(String pkField)
    {
        super(pkField);
    }
}