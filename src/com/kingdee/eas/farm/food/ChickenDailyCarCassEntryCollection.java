package com.kingdee.eas.farm.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ChickenDailyCarCassEntryCollection extends AbstractObjectCollection 
{
    public ChickenDailyCarCassEntryCollection()
    {
        super(ChickenDailyCarCassEntryInfo.class);
    }
    public boolean add(ChickenDailyCarCassEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ChickenDailyCarCassEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ChickenDailyCarCassEntryInfo item)
    {
        return removeObject(item);
    }
    public ChickenDailyCarCassEntryInfo get(int index)
    {
        return(ChickenDailyCarCassEntryInfo)getObject(index);
    }
    public ChickenDailyCarCassEntryInfo get(Object key)
    {
        return(ChickenDailyCarCassEntryInfo)getObject(key);
    }
    public void set(int index, ChickenDailyCarCassEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ChickenDailyCarCassEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ChickenDailyCarCassEntryInfo item)
    {
        return super.indexOf(item);
    }
}