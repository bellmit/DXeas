package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;

public class ContractEntryInfo extends AbstractContractEntryInfo implements Serializable 
{
    public ContractEntryInfo()
    {
        super();
    }
    protected ContractEntryInfo(String pkField)
    {
        super(pkField);
    }
}