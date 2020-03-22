package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;

public class SaleFeeInputEntryInfo extends AbstractSaleFeeInputEntryInfo implements Serializable 
{
    public SaleFeeInputEntryInfo()
    {
        super();
    }
    protected SaleFeeInputEntryInfo(String pkField)
    {
        super(pkField);
    }
}