package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CountrycheckEntryCollection extends AbstractObjectCollection 
{
    public CountrycheckEntryCollection()
    {
        super(CountrycheckEntryInfo.class);
    }
    public boolean add(CountrycheckEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CountrycheckEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CountrycheckEntryInfo item)
    {
        return removeObject(item);
    }
    public CountrycheckEntryInfo get(int index)
    {
        return(CountrycheckEntryInfo)getObject(index);
    }
    public CountrycheckEntryInfo get(Object key)
    {
        return(CountrycheckEntryInfo)getObject(key);
    }
    public void set(int index, CountrycheckEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CountrycheckEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CountrycheckEntryInfo item)
    {
        return super.indexOf(item);
    }
}