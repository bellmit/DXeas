package com.kingdee.eas.farm.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ChickenDailyBodyEntryCollection extends AbstractObjectCollection 
{
    public ChickenDailyBodyEntryCollection()
    {
        super(ChickenDailyBodyEntryInfo.class);
    }
    public boolean add(ChickenDailyBodyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ChickenDailyBodyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ChickenDailyBodyEntryInfo item)
    {
        return removeObject(item);
    }
    public ChickenDailyBodyEntryInfo get(int index)
    {
        return(ChickenDailyBodyEntryInfo)getObject(index);
    }
    public ChickenDailyBodyEntryInfo get(Object key)
    {
        return(ChickenDailyBodyEntryInfo)getObject(key);
    }
    public void set(int index, ChickenDailyBodyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ChickenDailyBodyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ChickenDailyBodyEntryInfo item)
    {
        return super.indexOf(item);
    }
}