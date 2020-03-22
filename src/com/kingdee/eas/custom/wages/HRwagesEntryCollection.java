package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HRwagesEntryCollection extends AbstractObjectCollection 
{
    public HRwagesEntryCollection()
    {
        super(HRwagesEntryInfo.class);
    }
    public boolean add(HRwagesEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HRwagesEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HRwagesEntryInfo item)
    {
        return removeObject(item);
    }
    public HRwagesEntryInfo get(int index)
    {
        return(HRwagesEntryInfo)getObject(index);
    }
    public HRwagesEntryInfo get(Object key)
    {
        return(HRwagesEntryInfo)getObject(key);
    }
    public void set(int index, HRwagesEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HRwagesEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HRwagesEntryInfo item)
    {
        return super.indexOf(item);
    }
}