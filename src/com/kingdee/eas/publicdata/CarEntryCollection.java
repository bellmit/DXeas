package com.kingdee.eas.publicdata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CarEntryCollection extends AbstractObjectCollection 
{
    public CarEntryCollection()
    {
        super(CarEntryInfo.class);
    }
    public boolean add(CarEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CarEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CarEntryInfo item)
    {
        return removeObject(item);
    }
    public CarEntryInfo get(int index)
    {
        return(CarEntryInfo)getObject(index);
    }
    public CarEntryInfo get(Object key)
    {
        return(CarEntryInfo)getObject(key);
    }
    public void set(int index, CarEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CarEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CarEntryInfo item)
    {
        return super.indexOf(item);
    }
}