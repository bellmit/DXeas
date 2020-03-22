package com.kingdee.eas.custom.festival;

import java.io.Serializable;

public class FactoryCalendarInfo extends AbstractFactoryCalendarInfo implements Serializable 
{
    public FactoryCalendarInfo()
    {
        super();
    }
    protected FactoryCalendarInfo(String pkField)
    {
        super(pkField);
    }
}