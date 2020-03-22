package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AttendanceBillEntryCollection extends AbstractObjectCollection 
{
    public AttendanceBillEntryCollection()
    {
        super(AttendanceBillEntryInfo.class);
    }
    public boolean add(AttendanceBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AttendanceBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AttendanceBillEntryInfo item)
    {
        return removeObject(item);
    }
    public AttendanceBillEntryInfo get(int index)
    {
        return(AttendanceBillEntryInfo)getObject(index);
    }
    public AttendanceBillEntryInfo get(Object key)
    {
        return(AttendanceBillEntryInfo)getObject(key);
    }
    public void set(int index, AttendanceBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AttendanceBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AttendanceBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}