package com.kingdee.eas.custom.taihe.contract;

import java.io.Serializable;

public class SuccessiveContractInfo extends AbstractSuccessiveContractInfo implements Serializable 
{
    public SuccessiveContractInfo()
    {
        super();
    }
    protected SuccessiveContractInfo(String pkField)
    {
        super(pkField);
    }
}