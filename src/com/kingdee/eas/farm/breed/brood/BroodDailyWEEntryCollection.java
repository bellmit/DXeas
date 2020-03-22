package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BroodDailyWEEntryCollection extends AbstractObjectCollection 
{
    public BroodDailyWEEntryCollection()
    {
        super(BroodDailyWEEntryInfo.class);
    }
    public boolean add(BroodDailyWEEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BroodDailyWEEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BroodDailyWEEntryInfo item)
    {
        return removeObject(item);
    }
    public BroodDailyWEEntryInfo get(int index)
    {
        return(BroodDailyWEEntryInfo)getObject(index);
    }
    public BroodDailyWEEntryInfo get(Object key)
    {
        return(BroodDailyWEEntryInfo)getObject(key);
    }
    public void set(int index, BroodDailyWEEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BroodDailyWEEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BroodDailyWEEntryInfo item)
    {
        return super.indexOf(item);
    }
}