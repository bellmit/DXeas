package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;

public class TechnicianInfo extends AbstractTechnicianInfo implements Serializable 
{
    public TechnicianInfo()
    {
        super();
    }
    protected TechnicianInfo(String pkField)
    {
        super(pkField);
    }
}