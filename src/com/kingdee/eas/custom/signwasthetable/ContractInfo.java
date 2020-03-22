package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;

public class ContractInfo extends AbstractContractInfo implements Serializable 
{
    public ContractInfo()
    {
        super();
    }
    protected ContractInfo(String pkField)
    {
        super(pkField);
    }
}