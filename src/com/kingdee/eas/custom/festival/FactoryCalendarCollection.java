package com.kingdee.eas.custom.festival;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FactoryCalendarCollection extends AbstractObjectCollection 
{
    public FactoryCalendarCollection()
    {
        super(FactoryCalendarInfo.class);
    }
    public boolean add(FactoryCalendarInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FactoryCalendarCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FactoryCalendarInfo item)
    {
        return removeObject(item);
    }
    public FactoryCalendarInfo get(int index)
    {
        return(FactoryCalendarInfo)getObject(index);
    }
    public FactoryCalendarInfo get(Object key)
    {
        return(FactoryCalendarInfo)getObject(key);
    }
    public void set(int index, FactoryCalendarInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FactoryCalendarInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FactoryCalendarInfo item)
    {
        return super.indexOf(item);
    }
}