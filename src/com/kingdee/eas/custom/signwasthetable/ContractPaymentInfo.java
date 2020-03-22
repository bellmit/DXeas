package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;

public class ContractPaymentInfo extends AbstractContractPaymentInfo implements Serializable 
{
    public ContractPaymentInfo()
    {
        super();
    }
    protected ContractPaymentInfo(String pkField)
    {
        super(pkField);
    }
}