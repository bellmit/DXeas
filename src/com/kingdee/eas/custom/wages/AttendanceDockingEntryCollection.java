package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AttendanceDockingEntryCollection extends AbstractObjectCollection 
{
    public AttendanceDockingEntryCollection()
    {
        super(AttendanceDockingEntryInfo.class);
    }
    public boolean add(AttendanceDockingEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AttendanceDockingEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AttendanceDockingEntryInfo item)
    {
        return removeObject(item);
    }
    public AttendanceDockingEntryInfo get(int index)
    {
        return(AttendanceDockingEntryInfo)getObject(index);
    }
    public AttendanceDockingEntryInfo get(Object key)
    {
        return(AttendanceDockingEntryInfo)getObject(key);
    }
    public void set(int index, AttendanceDockingEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AttendanceDockingEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AttendanceDockingEntryInfo item)
    {
        return super.indexOf(item);
    }
}