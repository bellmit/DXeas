package com.kingdee.eas.custom.wages;

import java.io.Serializable;

public class AttendanceBillEntryInfo extends AbstractAttendanceBillEntryInfo implements Serializable 
{
    public AttendanceBillEntryInfo()
    {
        super();
    }
    protected AttendanceBillEntryInfo(String pkField)
    {
        super(pkField);
    }
}