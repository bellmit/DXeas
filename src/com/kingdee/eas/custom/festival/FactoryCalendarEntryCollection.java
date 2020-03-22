package com.kingdee.eas.custom.festival;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FactoryCalendarEntryCollection extends AbstractObjectCollection 
{
    public FactoryCalendarEntryCollection()
    {
        super(FactoryCalendarEntryInfo.class);
    }
    public boolean add(FactoryCalendarEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FactoryCalendarEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FactoryCalendarEntryInfo item)
    {
        return removeObject(item);
    }
    public FactoryCalendarEntryInfo get(int index)
    {
        return(FactoryCalendarEntryInfo)getObject(index);
    }
    public FactoryCalendarEntryInfo get(Object key)
    {
        return(FactoryCalendarEntryInfo)getObject(key);
    }
    public void set(int index, FactoryCalendarEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FactoryCalendarEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FactoryCalendarEntryInfo item)
    {
        return super.indexOf(item);
    }
}