package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AttendanceDockingCollection extends AbstractObjectCollection 
{
    public AttendanceDockingCollection()
    {
        super(AttendanceDockingInfo.class);
    }
    public boolean add(AttendanceDockingInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AttendanceDockingCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AttendanceDockingInfo item)
    {
        return removeObject(item);
    }
    public AttendanceDockingInfo get(int index)
    {
        return(AttendanceDockingInfo)getObject(index);
    }
    public AttendanceDockingInfo get(Object key)
    {
        return(AttendanceDockingInfo)getObject(key);
    }
    public void set(int index, AttendanceDockingInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AttendanceDockingInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AttendanceDockingInfo item)
    {
        return super.indexOf(item);
    }
}