package com.kingdee.eas.custom.festival;

import java.io.Serializable;

public class HappyHolidayInfo extends AbstractHappyHolidayInfo implements Serializable 
{
    public HappyHolidayInfo()
    {
        super();
    }
    protected HappyHolidayInfo(String pkField)
    {
        super(pkField);
    }
}