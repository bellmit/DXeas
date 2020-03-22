package com.kingdee.eas.custom.lhsm;

import java.io.Serializable;

public class PersonGuaranteeInfo extends AbstractPersonGuaranteeInfo implements Serializable 
{
    public PersonGuaranteeInfo()
    {
        super();
    }
    protected PersonGuaranteeInfo(String pkField)
    {
        super(pkField);
    }
}