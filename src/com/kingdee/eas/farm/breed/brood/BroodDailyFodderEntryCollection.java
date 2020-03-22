package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BroodDailyFodderEntryCollection extends AbstractObjectCollection 
{
    public BroodDailyFodderEntryCollection()
    {
        super(BroodDailyFodderEntryInfo.class);
    }
    public boolean add(BroodDailyFodderEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BroodDailyFodderEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BroodDailyFodderEntryInfo item)
    {
        return removeObject(item);
    }
    public BroodDailyFodderEntryInfo get(int index)
    {
        return(BroodDailyFodderEntryInfo)getObject(index);
    }
    public BroodDailyFodderEntryInfo get(Object key)
    {
        return(BroodDailyFodderEntryInfo)getObject(key);
    }
    public void set(int index, BroodDailyFodderEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BroodDailyFodderEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BroodDailyFodderEntryInfo item)
    {
        return super.indexOf(item);
    }
}