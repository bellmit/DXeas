package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BroodDailyImmuneEntryCollection extends AbstractObjectCollection 
{
    public BroodDailyImmuneEntryCollection()
    {
        super(BroodDailyImmuneEntryInfo.class);
    }
    public boolean add(BroodDailyImmuneEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BroodDailyImmuneEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BroodDailyImmuneEntryInfo item)
    {
        return removeObject(item);
    }
    public BroodDailyImmuneEntryInfo get(int index)
    {
        return(BroodDailyImmuneEntryInfo)getObject(index);
    }
    public BroodDailyImmuneEntryInfo get(Object key)
    {
        return(BroodDailyImmuneEntryInfo)getObject(key);
    }
    public void set(int index, BroodDailyImmuneEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BroodDailyImmuneEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BroodDailyImmuneEntryInfo item)
    {
        return super.indexOf(item);
    }
}