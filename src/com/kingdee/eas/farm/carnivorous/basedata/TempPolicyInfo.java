package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class TempPolicyInfo extends AbstractTempPolicyInfo implements Serializable 
{
    public TempPolicyInfo()
    {
        super();
    }
    protected TempPolicyInfo(String pkField)
    {
        super(pkField);
    }
}