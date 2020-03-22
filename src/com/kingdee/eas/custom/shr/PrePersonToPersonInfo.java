package com.kingdee.eas.custom.shr;

import java.io.Serializable;

public class PrePersonToPersonInfo extends AbstractPrePersonToPersonInfo implements Serializable 
{
    public PrePersonToPersonInfo()
    {
        super();
    }
    protected PrePersonToPersonInfo(String pkField)
    {
        super(pkField);
    }
}