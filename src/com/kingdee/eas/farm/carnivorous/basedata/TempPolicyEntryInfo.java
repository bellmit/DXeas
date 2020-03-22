package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class TempPolicyEntryInfo extends AbstractTempPolicyEntryInfo implements Serializable 
{
    public TempPolicyEntryInfo()
    {
        super();
    }
    protected TempPolicyEntryInfo(String pkField)
    {
        super(pkField);
    }
}