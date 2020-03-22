package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BroodDailyEntryCollection extends AbstractObjectCollection 
{
    public BroodDailyEntryCollection()
    {
        super(BroodDailyEntryInfo.class);
    }
    public boolean add(BroodDailyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BroodDailyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BroodDailyEntryInfo item)
    {
        return removeObject(item);
    }
    public BroodDailyEntryInfo get(int index)
    {
        return(BroodDailyEntryInfo)getObject(index);
    }
    public BroodDailyEntryInfo get(Object key)
    {
        return(BroodDailyEntryInfo)getObject(key);
    }
    public void set(int index, BroodDailyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BroodDailyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BroodDailyEntryInfo item)
    {
        return super.indexOf(item);
    }
}