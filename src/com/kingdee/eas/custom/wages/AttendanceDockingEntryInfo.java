package com.kingdee.eas.custom.wages;

import java.io.Serializable;

public class AttendanceDockingEntryInfo extends AbstractAttendanceDockingEntryInfo implements Serializable 
{
    public AttendanceDockingEntryInfo()
    {
        super();
    }
    protected AttendanceDockingEntryInfo(String pkField)
    {
        super(pkField);
    }
}